package com.lichao.salesstock.business.model;

import com.lichao.salesstock.comm.model.BaseEntity;
import java.util.Date;

public class Order extends BaseEntity<Long> {

	private String goodsId;
	private String goodsName;
	private String goodsNorm;
	private Float goodsPrice;
	private Float salePrice;
	private Integer goodsNum;
	private Float totalPrices;
	private String mark;
	private Long userId;
	private Long shopId;
	private String op;

	public String getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getGoodsNorm() {
		return goodsNorm;
	}
	public void setGoodsNorm(String goodsNorm) {
		this.goodsNorm = goodsNorm;
	}
	public Float getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(Float goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public Float getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(Float salePrice) {
		this.salePrice = salePrice;
	}
	public Integer getGoodsNum() {
		return goodsNum;
	}
	public void setGoodsNum(Integer goodsNum) {
		this.goodsNum = goodsNum;
	}
	public Float getTotalPrices() {
		return totalPrices;
	}
	public void setTotalPrices(Float totalPrices) {
		this.totalPrices = totalPrices;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public String getOp() {
		return op;
	}

	public void setOp(String op) {
		this.op = op;
	}
}
