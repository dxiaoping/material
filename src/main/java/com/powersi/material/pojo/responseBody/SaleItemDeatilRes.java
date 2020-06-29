package com.powersi.material.pojo.responseBody;

import com.powersi.material.pojo.Item;
import com.powersi.material.pojo.ItemSaleDetail;
import com.powersi.material.pojo.Repo;
import com.powersi.material.pojo.Supplier;

/**
 * @description: 销售详情
 * @author: Duan xiaoping
 * @mailbox: xiaoping.duan@powersi.com.cn
 * @create: 2020-06-23 14:39
 */
public class SaleItemDeatilRes {
    /**商品*/
    private Item item;
    /**仓库*/
    private Repo repo;
    /**供货商*/
    private Supplier supplier;
    /**销售商品详情*/
    private ItemSaleDetail itemSaleDetail;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Repo getRepo() {
        return repo;
    }

    public void setRepo(Repo repo) {
        this.repo = repo;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public ItemSaleDetail getItemSaleDetail() {
        return itemSaleDetail;
    }

    public void setItemSaleDetail(ItemSaleDetail itemSaleDetail) {
        this.itemSaleDetail = itemSaleDetail;
    }
}
