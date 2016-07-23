package com.xjy.mvpdatabinding.request;

import com.xjy.mvpdatabinding.PostInfo;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * User: Tom
 * Date: 2016-07-23
 * Time: 15:21
 * FIXME
 */
public interface Api {
    @GET("/query")
    Observable<PostInfo> getCityList(@Query("type") String type, @Query("postid") String postId);
}  