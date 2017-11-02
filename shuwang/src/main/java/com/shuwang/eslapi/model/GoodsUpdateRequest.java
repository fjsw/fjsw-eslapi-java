package com.shuwang.eslapi.model;

import java.util.List;

public class GoodsUpdateRequest {
	private int merchant;
	private int branch;
	private int sum;
	private int pageNo;
	private int pageSize;
	private List<GoodsDetail> goods;

	public int getMerchant() {
		return merchant;
	}

	public void setMerchant(int merchant) {
		this.merchant = merchant;
	}

	public int getBranch() {
		return branch;
	}

	public void setBranch(int branch) {
		this.branch = branch;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<GoodsDetail> getGoods() {
		return goods;
	}

	public void setGoods(List<GoodsDetail> goods) {
		this.goods = goods;
	}
}
