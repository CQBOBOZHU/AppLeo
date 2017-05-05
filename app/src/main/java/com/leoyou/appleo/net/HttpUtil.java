package com.leoyou.appleo.net;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/5.
 */

public class HttpUtil {

    /**
     * 获取福利
     *
     * @param type
     * @param num
     * @param page
     * @param callBack
     */
    public static void getFuli(String type, int num, int page, CallBack callBack) {
        RetroFitUtil.subScribe(RetroFitUtil.initObservable(RetroFitUtil.getRetorfit().create(ApiService.class).getFuli(type, num, page)), callBack);
    }

    /**
     * 获取订单列表
     *
     * @param memberId
     * @param token
     * @param orderStatus
     * @param limit
     * @param page
     * @param callBack
     */
    public static void getOrderList(String memberId, String token, String orderStatus, int limit, int page, CallBack callBack) {
        RetroFitUtil.subScribe(RetroFitUtil.initObservable(RetroFitUtil.creatService(RetroFitUtil.yunruiBaseUrl).create(ApiService.class).getOrderList(memberId, token, orderStatus, limit, page)), callBack);
    }


    public static void getPhone(String memberId, String token, String orderStatus, int limit, int page, CallBack callBack) {
        Map<String, Object> map = new HashMap<>();
        map.put("memberId", memberId);
        map.put("token", token);
        map.put("orderStatus", orderStatus);
        map.put("limit", limit);
        map.put("page", page);
        RetroFitUtil.subScribe(RetroFitUtil.initObservable(RetroFitUtil.creatService(RetroFitUtil.yunruiBaseUrl).create(ApiService.class).getPhone(map)), callBack);
    }


    public static void getDoubanMovie(int start, int count, CallBack callBack) {
        RetroFitUtil.subScribe(RetroFitUtil.initObservable(RetroFitUtil.creatService(RetroFitUtil.API_DOUBAN).create(ApiService.class).getDoubanMovie(start, count)), callBack);
    }
}
