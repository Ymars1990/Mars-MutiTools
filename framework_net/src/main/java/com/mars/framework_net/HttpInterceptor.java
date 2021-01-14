package com.mars.framework_net;

import com.mars.framework_comutils_java.JsonFormaterUtils;
import com.mars.framework_comutils_java.LogUtils;
import com.mars.framework_comutils_java.SystemUtils;

import java.io.IOException;
import java.nio.charset.Charset;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;

public class HttpInterceptor implements Interceptor {
    private String TAG = HttpInterceptor.class.getSimpleName();

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        StringBuffer sb = new StringBuffer();
        String url = request.url().toString();
        sb.append(url);
        String request_body = "";
        Response response = chain.proceed(request);
        if(request!=null) {
            RequestBody requestBody = request.body();
            Buffer buffer = new Buffer();
            requestBody.writeTo(buffer);
            Charset charset = Charset.forName("UTF-8");
            request_body = buffer.readString(charset);
        }
        MediaType mediaType = response.body().contentType();
        String content = response.body().string();
        LogUtils.logI(TAG, "Request Start", System.currentTimeMillis());
        LogUtils.logI(TAG, String.format("url:%s", request.url()));
        LogUtils.logI(TAG, String.format("Mothod:%s", request.method()));
        LogUtils.logI(TAG, String.format("headers:%s", request.headers().toString()));
        LogUtils.logI(TAG, String.format("request:%s", request_body));
        LogUtils.logI(TAG, String.format("response:%s", JsonFormaterUtils.format(content)));
        LogUtils.logI(TAG, "Request End", System.currentTimeMillis());
        return response.newBuilder().body(ResponseBody.create(mediaType, content)).build();
    }
}
