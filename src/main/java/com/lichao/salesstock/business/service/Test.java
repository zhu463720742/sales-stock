package com.lichao.salesstock.business.service;

import com.alibaba.fastjson.JSONObject;
import com.lichao.salesstock.business.model.Order;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        String s="[{goodsId:'G00014',goodsName:'第四件商品',goodsNorm:'包装',goodsPrice:'5.45',salePrice:'5',goodsNum:'1',totalPrices:'5.00',mark:'添加的第四件商品',undefined:'<a href=\\\"#\\\" onclick=\\\"deltr(\\\" +=\\\"\\\" index=\\\"\\\" ')'=\\\"\\\">删 除</a>'}]";
        String s1="[{goodsId:'G00014',goodsName:'第四件商品',goodsNorm:'包装',goodsPrice:'5.45',salePrice:'5',goodsNum:'1',totalPrices:'5.00',mark:'添加的第四件商品',op1:''}]";
        String s2="[{goodsId:'G00014',goodsName:'第四件商品',goodsNorm:'包装',goodsPrice:'5.45',salePrice:'5',goodsNum:'1',totalPrices:'5.00',mark:'添加的第四件商品',op1:''}]";
        System.out.println(s.replace(" ')'",""));
//        System.out.println(s.replace("\"","").replace("(","").replace(")","").replace("/",""));

        List<Order> orderList= JSONObject.parseArray(s.replace(" ')'",""),Order.class);
        orderList= JSONObject.parseArray(s1,Order.class);
        orderList= JSONObject.parseArray(s2,Order.class);

    }
}
