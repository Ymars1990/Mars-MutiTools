package com.mars.framework_net;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.mars.framework_comutils_java.LogUtils;
import com.mars.framework_comutils_java.StringUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import okhttp3.MediaType;
import okhttp3.ResponseBody;
import retrofit2.Converter;

import static com.mars.framework_net.NetConstant.RESPONSE_CODE;
import static com.mars.framework_net.NetConstant.RESPONSE_DATA;
import static com.mars.framework_net.NetConstant.RESPONSE_MSG;
import static okhttp3.internal.Util.UTF_8;

/**
 * 处理服务器返回数据
 * 将数据转换成对象
 */
class ResponseConverterFactory<T> implements Converter<ResponseBody, T> {
    private final Gson gson;
    private final TypeAdapter<T> adapter;

    ResponseConverterFactory(Gson gson, TypeAdapter<T> adapter) {
        this.gson = gson;
        this.adapter = adapter;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        String jsonString = value.string();
        try {
            JSONObject object = new JSONObject(jsonString);
            int status = object.getInt(RESPONSE_CODE);
            if (status == NetConstant.REQUSET_SUCCESS_CODE) {
                if (!StringUtils.isNotNullString(object.getString(RESPONSE_DATA))) {
                    throw new HttpException(status, "请求数据异常[0xE1]");
                }
            } else {
                if (!StringUtils.isNotNullString(object.getString(RESPONSE_MSG))) {
                    throw new HttpException(status, "请求数据异常[0xE2]");
                }
            }
            return adapter.fromJson(object.getString("data"));

        } catch (JSONException e) {
            e.printStackTrace();
            //数据解析异常
            throw new HttpException(0xE3, String.format("请求数据解析异常[%s]", e.getMessage()));
        } finally {
            value.close();
        }
    }
}

