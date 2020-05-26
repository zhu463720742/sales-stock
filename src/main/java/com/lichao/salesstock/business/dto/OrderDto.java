package com.lichao.salesstock.business.dto;

import com.lichao.salesstock.business.model.Order;

import java.util.List;

public class OrderDto {
    private List<Order> orders;

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
