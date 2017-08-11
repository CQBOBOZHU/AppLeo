package com.leoyou.appleo.net;

import com.leoyou.appleo.bean.BookBean;
import com.leoyou.appleo.bean.DoubanMovieBean;
import com.leoyou.appleo.bean.FuliBean;
import com.leoyou.appleo.bean.OrderBean;
import com.leoyou.appleo.bean.QueryBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by Administrator on 2017/5/2.
 */

public interface ApiService {
    @GET("/api/data/{type}/{size}/{page}")
    Observable<FuliBean> getFuli(@Path("type") String type, @Path("size") int size, @Path("page") int page);

    @POST("/leoyonapp/order/sellerOrderList")
    Observable<OrderBean> getOrderList(@Query("memberId") String memberId,
                                       @Query("token") String token,
                                       @Query("orderStatus") String orderStatus,
                                       @Query("limit") int limit,
                                       @Query("page") int page);

    @POST("/leoyonapp/order/sellerOrderList")
    Observable<OrderBean> getPhone(@QueryMap(encoded = true) Map<String, Object> map);

    @GET("/v2/movie/top250")
    Observable<DoubanMovieBean> getDoubanMovie(@Query("start")int start,@Query("count")int count);

    @GET("/v2/book/search")
    Observable<BookBean> getDoubanBook(@Query("tag") String tag, @Query("start") int start, @Query("count") int count);

    @GET("/api/search/query/listview/category/{type}/count/{count}/page/{page} ")
    Observable<QueryBean> getQueryList(@Path("type")String type, @Path("count")int count, @Path("page")int page);
    // all | Android | iOS | 休息视频 | 福利 | 拓展资源 | 前端 | 瞎推荐 | App
}
