package com.leoyou.appleo.net;

import com.leoyou.appleo.bean.BookBean;
import com.leoyou.appleo.bean.DoubanMovieBean;
import com.leoyou.appleo.bean.FuliBean;
import com.leoyou.appleo.bean.OrderBean;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

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

}
