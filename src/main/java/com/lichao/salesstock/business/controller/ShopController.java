package com.lichao.salesstock.business.controller;

import java.util.List;

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
import com.lichao.salesstock.business.dao.ShopDao;
import com.lichao.salesstock.business.model.Shop;

import io.swagger.annotations.ApiOperation;

@Api(tags = "商店管理")
@RestController
@RequestMapping("/shops")
public class ShopController {

    @Autowired
    private ShopDao shopDao;

    @PreAuthorize("hasAuthority('shop:add')")
    @PostMapping
    @ApiOperation(value = "创建商店")
    public Shop save(@RequestBody Shop shop) {
        SysUser sysUser=UserUtil.getLoginUser();
        shop.setUserId(sysUser.getId());
        shopDao.save(shop);
        return shop;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取商店信息")
    public Shop get(@PathVariable Long id) {
        return shopDao.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "根据id修改商店信息")
    public Shop update(@RequestBody Shop shop) {
        shopDao.update(shop);
        return shop;
    }

    @PreAuthorize("hasAuthority('shop:query')")
    @GetMapping
    @ApiOperation(value = "获取商店列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new PageTableHandler.CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return shopDao.count(request.getParams());
            }
        }, new PageTableHandler.ListHandler() {

            @Override
            public List<Shop> list(PageTableRequest request) {
                return shopDao.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @PreAuthorize("hasAuthority('shop:del')")
    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        shopDao.delete(id);
    }
}
