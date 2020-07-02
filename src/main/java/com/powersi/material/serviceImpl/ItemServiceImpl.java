package com.powersi.material.serviceImpl;

import com.powersi.material.mapper.ItemMapper;
import com.powersi.material.pojo.Item;
import com.powersi.material.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements IItemService {

    @Autowired
    private ItemMapper itemMapper;
    @Override
    public Item findItemById(String id) {
        return itemMapper.selectByPrimaryKey(id);
    }
}
