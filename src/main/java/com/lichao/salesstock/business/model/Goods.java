package com.lichao.salesstock.business.model;

import com.lichao.salesstock.comm.model.BaseEntity;
import java.util.Date;

public class Goods extends BaseEntity<Long> {

	private String goodsId;
	private String goodsName;
	private String goodsNorm;
	private String goodsAdress;
	private Float goodsPrice;
	private Integer goodsNum;

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
	public String getGoodsAdress() {
		return goodsAdress;
	}
	public void setGoodsAdress(String goodsAdress) {
		this.goodsAdress = goodsAdress;
	}
	public Float getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(Float goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public Integer getGoodsNum() {
		return goodsNum;
	}
	public void setGoodsNum(Integer goodsNum) {
		this.goodsNum = goodsNum;
	}

}
