package com.xjy.mvpdatabinding.request;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * User: Tom
 * Date: 2016-07-23
 * Time: 15:21
 * FIXME
 */
public class Request {
    private static final String sUrl = "http://www.kuaidi100.com";
    private static Retrofit mRetrofit;

    protected static Retrofit retrofit() {
        if (null == mRetrofit) {
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .writeTimeout(60, TimeUnit.SECONDS)
                    .readTimeout(60, TimeUnit.SECONDS)
                    .build();

            mRetrofit = new Retrofit.Builder()
                    .baseUrl(sUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create()) // 使用RxJava作为回调适配器
                    .client(okHttpClient)
                    .build();
        }
        return mRetrofit;
    }

    private static Api api;

    public static Api getApi() {
        if (null == api)
            api = retrofit().create(Api.class);
        return api;
    }
}