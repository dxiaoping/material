package com.powersi.material.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.powersi.material.mapper.ItemClassMapper;
import com.powersi.material.mapper.ItemMapper;
import com.powersi.material.pojo.Item;
import com.powersi.material.pojo.ItemClass;
import com.powersi.material.pojo.requestBody.SearchItemDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
@RequiredArgsConstructor
public class ItemService {

    private final ItemMapper mapper;

    private final ItemClassMapper classmapper;

    private final RedisTemplate<String,Object> redisTemplate;

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

}
