package com.mars.biz_user;

import com.mars.biz_user.bean.LoginBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface UserApiInterface {
    @FormUrlEncoded
    @POST("user/login")
    Observable<LoginBean> login(@Field("username") String username, @Field("password") String password);

}
