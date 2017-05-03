package com.leoyou.appleo.net;

import com.leoyou.appleo.bean.FuliBean;
import com.leoyou.appleo.bean.OrderBean;

import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Administrator on 2017/5/2.
 */

public interface Api {
    @GET("/api/data/{type}/{size}/{page}")
    Observable<FuliBean> getFuli(@Path("type") String type, @Path("size") int size, @Path("page") int page);

    @POST("/leoyonapp/order/sellerOrderList")
    Observable<OrderBean> getOrderList(@Query("memberId") String memberId,
                                       @Query("token") String token,
                                       @Query("orderStatus") String orderStatus,
                                       @Query("limit") int limit,
                                       @Query("page") int page);
}
