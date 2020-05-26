package com.lichao.salesstock.business.model;

import com.lichao.salesstock.comm.model.BaseEntity;
import java.util.Date;

public class Shop extends BaseEntity<Long> {

	private String shopName;
	private String shopAdress;
	private Long userId;

	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getShopAdress() {
		return shopAdress;
	}
	public void setShopAdress(String shopAdress) {
		this.shopAdress = shopAdress;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
}
