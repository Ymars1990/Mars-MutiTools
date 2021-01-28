package com.mars.mars_mutitools.test;

import com.mars.mars_mutitools.test.bean.WeChatBean;

import java.util.ArrayList;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {

    @GET("/wxarticle/chapters/json")
    Observable<ArrayList<WeChatBean>> getWxarticle();
}
