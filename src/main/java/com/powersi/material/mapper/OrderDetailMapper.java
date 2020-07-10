package com.powersi.material.mapper;

import com.powersi.material.pojo.OrderDetail;
import com.powersi.material.pojo.OrderDetailExample;
import com.powersi.material.pojo.OrderDetailKey;
import com.powersi.material.pojo.responseBody.OrderDetialResp;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderDetailMapper {
    int countByExample(OrderDetailExample example);

    int deleteByExample(OrderDetailExample example);

    int deleteByPrimaryKey(OrderDetailKey key);

    int insert(OrderDetail record);

    int insertSelective(OrderDetail record);

    List<OrderDetail> selectByExample(OrderDetailExample example);

    OrderDetail selectByPrimaryKey(OrderDetailKey key);

    int updateByExampleSelective(@Param("record") OrderDetail record, @Param("example") OrderDetailExample example);

    int updateByExample(@Param("record") OrderDetail record, @Param("example") OrderDetailExample example);

    int updateByPrimaryKeySelective(OrderDetail record);

    int updateByPrimaryKey(OrderDetail record);

    //这里用注解就不用再mapper.xml文件声明实现这个方法了
    @Select("SELECT\n" +
            "\t\tod.order_number,\n" +
            "    i.item_name,\n" +
            "\t  i.item_factory_name,\n" +
            "\t\ti.item_lately_pic,\n" +
            "    supplier.supplier_name\n" +
            "\tFROM\n" +
            "\t\torder_detail AS od\n" +
            "\tINNER JOIN `order` AS o ON od.order_id = o.id\n" +
            "and o.id=#{orderId} \n" +
            "  INNER JOIN `item` AS i ON od.item_id = i.id \n" +
            "\tINNER JOIN supplier on od.supplier_id=supplier.id\n")
    List<OrderDetialResp> findOrderDetailRespsByOrderId(String orderId);
}