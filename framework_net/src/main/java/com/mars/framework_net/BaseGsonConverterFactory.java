package com.mars.framework_net;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * File descripition: 重写gson 判断返回值  状态划分
 *
 * @author lp
 * @date 2018/8/24
 */

/**
 * A {@linkplain Converter.Factory converter} which uses Gson for JSON.
 * <p>
 * Because Gson is so flexible in the types it supports, this converter assumes that it can handle
 * all types. If you are mixing JSON serialization with something else (such as protocol buffers),
 * you must {@linkplain Retrofit.Builder#addConverterFactory(Converter.Factory) add this instance}
 * last to allow the other converters a chance to see their types.
 */
public final class BaseGsonConverterFactory extends Converter.Factory {
    /**
     * Create an instance using a default {@link Gson} instance for conversion. Encoding to JSON and
     * decoding from JSON (when no charset is specified by a header) will use UTF-8.
     */
    public static BaseGsonConverterFactory create() {
        return create(new Gson());
    }

    /**
     * Create an instance using {@code gson} for conversion. Encoding to JSON and
     * decoding from JSON (when no charset is specified by a header) will use UTF-8.
     */
    @SuppressWarnings("ConstantConditions") // Guarding public API nullability.
    public static BaseGsonConverterFactory create(Gson gson) {
        if (gson == null) throw new NullPointerException("gson == null");
        return new BaseGsonConverterFactory(gson);
    }

    private final Gson gson;

    private BaseGsonConverterFactory(Gson gson) {
        this.gson = gson;
    }

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations,
                                                            Retrofit retrofit) {
//        if (String.class.equals(type)) {
//            //如果需要处理的类型是String(即我们需要处理的类型)
//            //返回一个转换的Converter对象
//            return new Converter<ResponseBody, String>() {
//                //converter对象实现其抽象方法,将当前类型数据转换成目标类型的convert方法
//                @Override
//                public String convert(ResponseBody value)     throws IOException {
//                    return value==null?null:value.toString();
//                }
//            };
//        }
//        if (List.class.equals(type)) {
//            //如果需要处理的类型是String(即我们需要处理的类型)
//            //返回一个转换的Converter对象
//            return new Converter<ResponseBody, String>() {
//                //converter对象实现其抽象方法,将当前类型数据转换成目标类型的convert方法
//                @Override
//                public String convert(ResponseBody value)     throws IOException {
//                    return value==null?null:value.toString();
//                }
//            };
//        }
        TypeAdapter<?> adapter = gson.getAdapter(TypeToken.get(type));
        return new ResponseConverterFactory<>(gson, adapter);
    }

    @Override
    public Converter<?, RequestBody> requestBodyConverter(Type type,
                                                          Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
        TypeAdapter<?> adapter = gson.getAdapter(TypeToken.get(type));
        return new RequestConverterFactory<>(gson, adapter);
    }
}
