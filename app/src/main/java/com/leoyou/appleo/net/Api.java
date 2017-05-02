package com.leoyou.appleo.net;

import com.leoyou.appleo.bean.FuliBean;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Administrator on 2017/5/2.
 */

public interface Api {
    @GET("/api/data/{type}/{size}/{page}")
    Observable<FuliBean> getFuli(@Path("type") String type, @Path("size") int size, @Path("page") int page);
}
