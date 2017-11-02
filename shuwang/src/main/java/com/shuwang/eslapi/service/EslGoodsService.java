package com.shuwang.eslapi.service;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.shuwang.eslapi.model.GoodsUpdateRequest;
import com.shuwang.eslapi.model.GoodsUpdateResponse;

public class EslGoodsService {
	protected final Logger log = LoggerFactory.getLogger(getClass());
	private Gson gson = new Gson();

	private String appid = null;
	private String appsecret = null;
	private String gatewayUrl = null;

	/**
	 * check whether initialized
	 * 
	 * @return boolean
	 */
	public boolean isInitialized() {
		return appid != null;
	}

	/**
	 * initial service
	 * 
	 * @param appid
	 *            应用编号
	 * @param appsecret
	 *            应用秘钥
	 * @param gatewayUrl
	 *            接口网关
	 */
	public void initial(String appid, String appsecret, String gatewayUrl) {
		this.appid = appid;
		this.appsecret = appsecret;
		this.gatewayUrl = gatewayUrl;
	}

	/**
	 * 发送商品数据更新
	 * 
	 * @param request
	 *            商品数据更新请求
	 * @return
	 */
	public GoodsUpdateResponse updateGoods(GoodsUpdateRequest request) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("method", "eslapi.goods.update");
		params.put("merchant", request.getMerchant());
		params.put("branch", request.getBranch());
		params.put("sum", request.getSum());
		params.put("pageNo", request.getPageNo());
		params.put("pageSize", request.getPageSize());
		params.put("goods", gson.toJson(request.getGoods()));
		String result = GatewayProtocolService.callMethod(params, appid,
				appsecret, gatewayUrl);
		log.debug("updateGoods() result={}", result);
		//
		GoodsUpdateResponse response = gson.fromJson(result,
				GoodsUpdateResponse.class);
		return response;
	}
}
