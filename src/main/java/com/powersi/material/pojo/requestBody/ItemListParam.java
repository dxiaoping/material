package com.powersi.material.pojo.requestBody;

import lombok.Data;

import javax.persistence.Entity;

/**
 * DTO类获得查询商品数据
 */

@Data
public class ItemListParam {

    String itemName;

    String itemClass;

}
