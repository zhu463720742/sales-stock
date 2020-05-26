package com.lichao.salesstock.business.controller;

import java.util.List;

import com.lichao.salesstock.business.service.OrderService;
import com.lichao.salesstock.comm.utils.UserUtil;
import com.lichao.salesstock.system.model.SysUser;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lichao.salesstock.comm.page.table.*;
import com.lichao.salesstock.business.dao.OrderDao;
import com.lichao.salesstock.business.model.Order;

import io.swagger.annotations.ApiOperation;

@Api(tags = "商品订单管理")
@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderDao orderDao;

    @PreAuthorize("hasAuthority('order:add')")
    @PostMapping
    @ApiOperation(value = "订单生成")
    public Order save(@RequestBody Order order) {
        SysUser sysUser = UserUtil.getLoginUser();
        order.setUserId(sysUser.getId());
        order.setShopId(sysUser.getShopId());
        orderService.saveOrder(order);
        return order;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取订单信息")
    public Order get(@PathVariable Long id) {
        return orderDao.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "根据id修改订单信息")
    public Order update(@RequestBody Order order) {
        orderDao.update(order);

        return order;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new PageTableHandler.CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return orderDao.count(request.getParams());
            }
        }, new PageTableHandler.ListHandler() {

            @Override
            public List<Order> list(PageTableRequest request) {
                return orderDao.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @PreAuthorize("hasAuthority('order:delete')")
    @DeleteMapping("/{id}")
    @ApiOperation(value = "依据id删除订单记录")
    public void delete(@PathVariable Long id) {
        orderDao.delete(id);
    }

}
