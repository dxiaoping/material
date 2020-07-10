package com.powersi.material.controller;

import com.powersi.material.pojo.Item;
import com.powersi.material.pojo.Supplier;
import com.powersi.material.pojo.SupplierItem;
import com.powersi.material.pojo.responseBody.SupplierResp;
import com.powersi.material.service.IItemService;
import com.powersi.material.service.IOrderService;
import com.powersi.material.service.ISupplierService;
import com.powersi.material.utils.ListPageUtil;
import com.powersi.material.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/supplier")
public class SupplierController {
    public static final int PAGE_SIZE = 5;
    @Autowired
    private ISupplierService supplierService;
    @Autowired
    private IItemService itemService;
    @Autowired
    private IOrderService orderService;


    @RequestMapping("/findAllSuppliers")
    public PageBean findAllSuppliers(@RequestParam(value="pageNum",required=false,defaultValue="1")int pageNum){
//    public List<SupplierResp> findAllSuppliers(){
        List<SupplierResp> supplierRespList=new ArrayList<>();
        List<SupplierItem> supplierItems = supplierService.findAllSupplierItems();
        for (SupplierItem supplierItem : supplierItems) {
            SupplierResp supplierResp=new SupplierResp();
            String itemId=supplierItem.getItemId();
            supplierResp.setSupplierId(supplierItem.getSupplierId());
            supplierResp.setSupplierName(supplierService.findSupplierById(supplierItem.getSupplierId()).getSupplierName());
            supplierResp.setItemId(itemId);
            System.out.println("qqqqqqqqqqqqq"+supplierItem.getItemId());
            Item item=itemService.findItemById(itemId);
            supplierResp.setItemName(item.getItemName());
            //调用orderService查询出进货价
            String inPrice = orderService.findInPriceByItemIdAndSupplierName(supplierItem.getItemId(), supplierService.findSupplierById(supplierItem.getSupplierId()).getSupplierName());
            supplierResp.setInPrice(new BigDecimal(Double.parseDouble(inPrice)));
            supplierRespList.add(supplierResp);
        }
        ListPageUtil listPageUtil=new ListPageUtil(supplierRespList,PAGE_SIZE);
        PageBean pageBean=new PageBean();
        pageBean.setTotal(supplierRespList.size());
        pageBean.setPagedList(listPageUtil.getPagedList(pageNum));
        return pageBean;
    }

    //sql形式实现代码
    @RequestMapping("/findAllSuppliersSql")
    public PageBean findAllSuppliersSql(@RequestParam(value="pageNum",required=false,defaultValue="1")int pageNum){

        List<SupplierResp> supplierRespList = supplierService.findAllSuppliersSql();
        ListPageUtil listPageUtil=new ListPageUtil(supplierRespList,PAGE_SIZE);
        PageBean pageBean=new PageBean();
        pageBean.setTotal(supplierRespList.size());
        pageBean.setPagedList(listPageUtil.getPagedList(pageNum));
        return pageBean;
    }

    //这里用resp来接受是因为之前用resp向前端发送为了简便直接用resp来接收了,没有重新创req对象了
    @RequestMapping("/updateInPrice")
    public void updateInPrice(@RequestBody SupplierResp supplierResp){
        SupplierItem supplierItem=new SupplierItem();
        supplierItem.setSupplierId(supplierResp.getSupplierId());
        supplierItem.setInPrice(supplierResp.getInPrice());
        supplierItem.setItemId(supplierResp.getItemId());
        supplierService.updateInPice(supplierItem);
    }
}
