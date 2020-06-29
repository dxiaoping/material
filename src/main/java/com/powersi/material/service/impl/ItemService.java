package com.powersi.material.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.powersi.material.commons.Id;
import com.powersi.material.configure.ConfigProperties;
import com.powersi.material.mapper.ItemClassMapper;
import com.powersi.material.mapper.ItemMapper;
import com.powersi.material.pojo.Item;
import com.powersi.material.pojo.ItemClass;
import com.powersi.material.pojo.ItemExample;
import com.powersi.material.pojo.requestBody.SeLectItemDTO;
import com.powersi.material.pojo.responseBody.SearchItemDTO;
import com.powersi.material.pojo.responseBody.SelectItemRes;
import com.powersi.material.units.BarcodeUtil;
import com.powersi.material.units.PingYinUtils;
import com.powersi.material.units.PinyinToWubi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.security.util.Debug;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
@RequiredArgsConstructor
public class ItemService {

    private final ItemMapper mapper;

    private final ItemClassMapper classmapper;

    private final RedisTemplate<String,Object> redisTemplate;

    @Autowired
    private Id myid;

    @Autowired
    ConfigProperties config;


    public PageInfo<SelectItemRes> selectItem(SeLectItemDTO dto,Integer pageNO,Integer pageSize){

        PageHelper.startPage(pageNO,pageSize);

        List<SelectItemRes> list = mapper.selectItem(dto);

        PageInfo<SelectItemRes> info = new PageInfo<>(list);

        return info;
    }


    public PageInfo<SearchItemDTO> searchItem(Integer pageNO,String itemName,String itemClass){

        List<SearchItemDTO> list = null;

        PageHelper.startPage(pageNO,10);

        if(itemClass == null || itemClass.equals("") ){

            list = mapper.selectByItemName(itemName);

        }else{

            list = mapper.selectByItemNameAndClass(itemName,itemClass);

        }

        PageInfo<SearchItemDTO> page = new PageInfo<SearchItemDTO>(list);

        return page;
    }

    public List<ItemClass> getItemClass(){

        Object o = redisTemplate.opsForValue().get("itemclass");

        //如果itemclass保存在redis中则直接拿来使用
        if (o != null){
            log.info("redis保存的商品类别集合");
            return (List<ItemClass>) o;
        }
        log.info("redis没有保存集合");
        //没有保存则在数据库中查找，并保存在redis中
        List<ItemClass> list = classmapper.selectAllItem();
        redisTemplate.opsForValue().set("itemclass",list,12, TimeUnit.HOURS);
        log.info("redis已保存集合");
        return list;
    }


    /**
     * 添加商品
     * @return
     */
    @Transactional
    public Item addItem(Item item){

        //生成主键
        long itemid = myid.nextId();
        //主键
        item.setId(itemid+"");
        //五笔码
        item.setItemWubi(PinyinToWubi.getWBCode(item.getItemName()));
        //拼音码
        item.setItemSpell(PingYinUtils.getAllPinYinHeadChar(item.getItemName()));
        //条形码
//        log.info("条形码路径"+config.getRootFile().getAbsolutePath());
        //获得项目的根目录
//        String rootpath = config.getRootFile().getAbsolutePath();
//        log.info("项目根目录:",rootpath);
        //保存在项目的Codes的文件夹下
//        String path = rootpath+"/../src/main/resources/Codes/barcode_"+item.getId()+".png";
        //将文件保存在D盘,方便用nginx获得的
        //定义根目录
        String rootpath = config.getPicrootpath();
        //生成文件夹
        new File(rootpath).mkdir();

        String path = "barcode_"+item.getId()+".png";
        //生成条形码文件
        BarcodeUtil.generateFile(item.getId(),rootpath+path);
        //将条形码文件保存
        item.setItemCode(path);

        System.out.println(JSON.toJSONString(item));
        int i = mapper.insertSelective(item);

        if (i > 0){
            return item;
        }

        return null;
    }


    @Transactional
    public Item updateItem(Item item){
        //重新保存数据库路径
        item.setItemCode(item.getItemCode().substring(item.getItemCode().lastIndexOf("/")+1));
        //重新修改五笔码
        item.setItemWubi(PinyinToWubi.getWBCode(item.getItemName()));
        //重新修改拼音码
        item.setItemSpell(PingYinUtils.getAllPinYinHeadChar(item.getItemName()));

        int i = mapper.updateByPrimaryKeySelective(item);

        if (i > 0){
            return item;
        }

        return null;
    }


    @Transactional
    public boolean deleteItem(String id){

        int i = mapper.deleteByPrimaryKey(id);

        if (i > 0){
            return true;
        }

        return false;
    }


    @Transactional
    public Item searchItemById(String id){

        Item item = mapper.selectByPrimaryKey(id);

        return item;
    }


    public List<Item> search(String keyWord){

        List<Item> list = mapper.selectByKeyWord("%"+keyWord+"%");
        return list;
    }
}
