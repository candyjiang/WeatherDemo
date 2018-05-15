package com.candyjiang.weatherdemo.util;

import java.util.concurrent.TimeUnit;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by othzjiang
 * on 2018/5/15.
 */

public class HttpUtil {

    public static void sendOkHttpRequest(String url, Callback callback){
        OkHttpClient client = new OkHttpClient();
        client = new OkHttpClient().newBuilder().
                connectTimeout(10, TimeUnit.SECONDS).
                writeTimeout(10, TimeUnit.SECONDS).
                readTimeout(30, TimeUnit.SECONDS).
                build();
        Request request = new Request.Builder().url(url).build();
        client.newCall(request).enqueue(callback);
    }

}
