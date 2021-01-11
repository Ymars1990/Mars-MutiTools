package com.mars.mars_mutitools.test;

import com.mars.framework_net.BaseResponse;
import com.mars.mars_mutitools.test.bean.WeChatBean;

import java.util.ArrayList;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("/wxarticle/chapters/json")
    Observable<ArrayList<WeChatBean>> getWxarticle();

}
