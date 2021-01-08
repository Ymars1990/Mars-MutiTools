package com.mars.framework_net;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

//请求管理类
public class HttpManager {

    public static HttpManager mInstance = null;

    public static HttpManager get() {
        if (mInstance == null) {
            synchronized (HttpManager.class) {
                if (mInstance == null) {
                    mInstance = new HttpManager();
                }
            }
        }
        return mInstance;
    }

    /**
     * 设置okHttp
     */
    private static OkHttpClient okHttpClient() {

        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(NetConstant.CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(NetConstant.WRITE_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(NetConstant.READ_TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(new HttpInterceptor())
                .build();
        return client;
    }

    /**
     * 获取Retrofit
     */
    public Retrofit getRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient())
                .baseUrl(NetConstant.HTTP_BASE_URL)
                .addConverterFactory(BaseGsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit;
    }
}
