package com.lichao.salesstock.business.controller;

import java.util.List;

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
import com.lichao.salesstock.business.dao.GoodsDao;
import com.lichao.salesstock.business.model.Goods;

import io.swagger.annotations.ApiOperation;

@Api(tags = "商品信息管理")
@RestController
@RequestMapping("/goodss")
public class GoodsController {

    @Autowired
    private GoodsDao goodsDao;

    @PreAuthorize("hasAuthority('goods:add')")
    @PostMapping
    @ApiOperation(value = "新商品信息新增")
    public Goods save(@RequestBody Goods goods) {
        goodsDao.save(goods);

        return goods;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取商品信息")
    public Goods get(@PathVariable Long id) {
        return goodsDao.getById(id);
    }

    @GetMapping("/order/{goodsId}")
    @ApiOperation(value = "根据goodsId获取商品信息")
    public Goods getGoodsByGoodsId(@PathVariable String goodsId) {
        return goodsDao.getByGoodsId(goodsId);
    }

    @PutMapping
    @ApiOperation(value = "修改商品信息")
    public Goods update(@RequestBody Goods goods) {
        goodsDao.update(goods);

        return goods;
    }

    @GetMapping
    @ApiOperation(value = "获取商品信息列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new PageTableHandler.CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return goodsDao.count(request.getParams());
            }
        }, new PageTableHandler.ListHandler() {

            @Override
            public List<Goods> list(PageTableRequest request) {
                return goodsDao.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @PreAuthorize("hasAuthority('goods:delete')")
    @DeleteMapping("/{id}")
    @ApiOperation(value = "根据id删除商品信息")
    public void delete(@PathVariable Long id) {
        goodsDao.delete(id);
    }
}
