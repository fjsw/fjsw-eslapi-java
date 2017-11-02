package com.shuwang.eslapi.test;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.shuwang.eslapi.model.GoodsDetail;
import com.shuwang.eslapi.model.GoodsUpdateRequest;
import com.shuwang.eslapi.model.GoodsUpdateResponse;
import com.shuwang.eslapi.service.EslGoodsService;
import com.shuwang.eslapi.test.config.EslapiConfig;

public class Application {
	protected static final Logger log = LoggerFactory
			.getLogger(Application.class);

	public static void main(String[] args) {
		updateGoods();
	}

	/**
	 * 发送商品数据更新
	 */
	private static void updateGoods() {
		// 构造请求数据
		int sum = 2;
		GoodsUpdateRequest request = new GoodsUpdateRequest();
		request.setMerchant(1);
		request.setBranch(1);
		request.setSum(sum);
		request.setPageNo(1);
		request.setPageSize(10);
		List<GoodsDetail> goods = new ArrayList<GoodsDetail>(sum);
		// goods 1
		GoodsDetail goodsDetail1 = new GoodsDetail();
		goodsDetail1.setSku(514893);
		goodsDetail1.setName("牛奶");
		goodsDetail1.setEan("6965234");
		goodsDetail1.setPrice(2.00);
		goodsDetail1.setUnit("盒");
		goods.add(goodsDetail1);
		// goods 2
		GoodsDetail goodsDetail2 = new GoodsDetail();
		goodsDetail2.setSku(514894);
		goodsDetail2.setName("香蕉");
		goodsDetail2.setEan("6965235");
		goodsDetail2.setPrice(3.68);
		goodsDetail2.setUnit("斤");
		goods.add(goodsDetail2);
		//
		request.setGoods(goods);
		// 配置参数
		EslGoodsService eslGoodsService = new EslGoodsService();
		eslGoodsService.initial(EslapiConfig.ESLAPP_APPID,
				EslapiConfig.ESLAPP_APPSECRET, EslapiConfig.GATEWAY_URL);
		//
		GoodsUpdateResponse response = eslGoodsService.updateGoods(request);
		log.debug("response: {}", response);
	}

}
