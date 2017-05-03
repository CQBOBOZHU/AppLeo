package com.leoyou.appleo.util;

import android.net.ParseException;

import com.google.gson.JsonParseException;

import org.json.JSONException;

import java.net.ConnectException;

import retrofit2.HttpException;

/**
 * Created by Administrator on 2017/5/3.
 */

public class ExceptionUtil {

    //对应HTTP的状态码
    private static final int UNAUTHORIZED = 401;
    private static final int FORBIDDEN = 403;
    private static final int NOT_FOUND = 404;
    private static final int REQUEST_TIMEOUT = 408;
    private static final int INTERNAL_SERVER_ERROR = 500;
    private static final int BAD_GATEWAY = 502;
    private static final int SERVICE_UNAVAILABLE = 503;
    private static final int GATEWAY_TIMEOUT = 504;

    public static final int NET_ERROE = 10001;//网络错误
    public static final int SERVER_ERROE = 10002;//服务器错误
    public static final int UNKNOWN_ERROE = 10003;//未知错误
    public static final int PARSE_ERROE = 10004;//解析错误

    public static int getExceptionCode(Throwable e) {
        if (e instanceof HttpException) {
            switch (((HttpException) e).code()) {
                case UNAUTHORIZED:
                case FORBIDDEN:
                case NOT_FOUND:
                case REQUEST_TIMEOUT:
                case INTERNAL_SERVER_ERROR:
                case BAD_GATEWAY:
                case SERVICE_UNAVAILABLE:
                case GATEWAY_TIMEOUT:
                    return NET_ERROE;
            }
        }
//        else if (e instanceof JsonParseException
//                || e instanceof JSONException
//                || e instanceof ParseException) {
//            return PARSE_ERROE;
//        }
        else if (e instanceof ConnectException) {
            return NET_ERROE;
        }
        return UNKNOWN_ERROE;
    }
}
