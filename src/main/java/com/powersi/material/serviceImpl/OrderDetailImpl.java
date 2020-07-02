package com.powersi.material.serviceImpl;

import com.powersi.material.mapper.ItemMapper;
import com.powersi.material.mapper.OrderDetailMapper;
import com.powersi.material.pojo.Item;
import com.powersi.material.pojo.ItemExample;
import com.powersi.material.pojo.OrderDetail;
import com.powersi.material.pojo.OrderDetailExample;
import com.powersi.material.service.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Transactional
@Service
public class OrderDetailImpl implements IOrderDetailService {

    @Resource
    private OrderDetailMapper orderDetailMapper;
    @Resource
    private ItemMapper itemMapper;

    @Override
    public List<OrderDetail> findAll() {
        return orderDetailMapper.selectByExample(null);
    }

    @Override
    public OrderDetail findOrderDetailById(String id) {

        OrderDetailExample example=new OrderDetailExample();
        OrderDetailExample.Criteria criteria = example.createCriteria();
        criteria.andItemIdEqualTo(id);
        List<OrderDetail> orderDetails = orderDetailMapper.selectByExample(example);
        return orderDetails.get(0);
    }

    @Override
    public void updateOrderDetail(OrderDetail orderDetail) {

        orderDetailMapper.updateByPrimaryKeySelective(orderDetail);
    }

    @Override
    public void deleteOrderDetailById(String id) {

        OrderDetailExample example=new OrderDetailExample();
        OrderDetailExample.Criteria criteria = example.createCriteria();
        criteria.andItemIdEqualTo(id);
        orderDetailMapper.deleteByExample(example);
    }

    @Override
    public void insertOrderDetail(OrderDetail orderDetail) {

        orderDetailMapper.insert(orderDetail);
    }

    @Override
    public List<OrderDetail> findByExample(String itemId,String itemName) {
        OrderDetailExample example=new OrderDetailExample();
        OrderDetailExample.Criteria criteria = example.createCriteria();
        if (itemId!=null&&itemId!=""){
            criteria.andItemIdLike("%"+itemId+"%");
        }

        ItemExample itemExample=new ItemExample();
        ItemExample.Criteria itemExampleCriteria = itemExample.createCriteria();
        if(itemName!=null&&itemName!=""){
            itemExampleCriteria.andItemNameLike("%"+itemName+"%");
            List<Item> items = itemMapper.selectByExample(itemExample);
            for (Item item : items) {
                criteria.andItemIdEqualTo(item.getId());
                return orderDetailMapper.selectByExample(example);
            }
        }

        return orderDetailMapper.selectByExample(example);


    }
}
