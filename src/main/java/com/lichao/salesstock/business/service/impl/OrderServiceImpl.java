package com.lichao.salesstock.business.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.lichao.salesstock.business.dao.OrderDao;
import com.lichao.salesstock.business.model.Order;
import com.lichao.salesstock.business.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URLDecoder;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;
    @Override
    public Order saveOrder(Order order) {
        List<Order> orders=JsonToList(order.getOp());
        for(Order order1:orders){
            order1.setShopId(order.getShopId());
            order1.setUserId(order.getUserId());
            orderDao.save(order1);
        }
        return order;
    }

    private List<Order> JsonToList(String json){
        String op_new=json.replace(" ')'","")
                           .replace("\"","")
                            .replace("<a href=# onclick=deltr( += index==>删 除</a>","");
        return JSONObject.parseArray(json,Order.class);
    }
}
