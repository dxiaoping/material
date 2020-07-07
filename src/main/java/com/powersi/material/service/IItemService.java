package com.powersi.material.service;

import com.powersi.material.pojo.Item;

public interface IItemService {
    public Item findItemById(String id);

    public void updateItem(Item item);
}
