package com.powersi.material.mapper;

import com.powersi.material.pojo.Order;
import com.powersi.material.pojo.OrderExample;
import com.powersi.material.pojo.responseBody.NewOrderResp;
import com.powersi.material.pojo.responseBody.OrderResp;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderMapper {
    int countByExample(OrderExample example);

    int deleteByExample(OrderExample example);

    int deleteByPrimaryKey(String id);

    int insert(Order record);

    int insertSelective(Order record);

    List<Order> selectByExample(OrderExample example);

    Order selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByExample(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);


    @Select("SELECT\n" +
            "\to.id as orderId,\n" +
            "\to.order_amount_money,\n" +
            "\to.order_is_arrive as isArrive,\n" +
            "\to.order_oper_date as orderDate,\n" +
            "\to.orde_status as orderStatus,\n" +
            "\te.emp_name\n" +
            "FROM\n" +
            "\t`order` o\n" +
            "INNER JOIN employee e ON o.employee_id = e.id")
    List<NewOrderResp> findAllNewOrderResps();

    @Select("SELECT\n" +
            "\tod.item_id AS id,\n" +
            "\titem.item_name,\n" +
            "\titem.item_spec,\n" +
            "\titem.item_lately_pic AS itemLatelyPrice,\n" +
            "\tod.order_number,\n" +
            "\titem.item_factory_name AS itemFactoryName,\n" +
            "\tsup.supplier_name\n" +
            "FROM\n" +
            "\torder_detail od\n" +
            "INNER JOIN item ON od.item_id = item.id\n" +
            "INNER JOIN supplier sup ON od.supplier_id = sup.id")
    List<OrderResp> findAllOrderResp();
}