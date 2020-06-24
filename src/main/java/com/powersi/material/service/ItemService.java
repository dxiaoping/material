package com.powersi.material.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.powersi.material.mapper.ItemClassMapper;
import com.powersi.material.mapper.ItemMapper;
import com.powersi.material.pojo.Item;
import com.powersi.material.pojo.ItemClass;
import com.powersi.material.pojo.requestBody.SearchItemDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemMapper mapper;

    private final ItemClassMapper classmapper;

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

        List<ItemClass> list = classmapper.selectAllItem();

        return list;
    }

}
