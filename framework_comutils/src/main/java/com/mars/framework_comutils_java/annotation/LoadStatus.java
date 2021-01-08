package com.mars.framework_comutils_java.annotation;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class LoadStatus {
    private final int code;
    private final String desc;

    public LoadStatus(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Type {
        LoadStatus LOAD_LOADING = new LoadStatus(1, "正在加载");
        LoadStatus LOAD_SUCCESS = new LoadStatus(2, "加载成功");
        LoadStatus LOAD_FAILED = new LoadStatus(3, "加载失败");
        LoadStatus LOAD_NEWWORK_ERROR = new LoadStatus(4, "网络异常");
        LoadStatus LOAD_DATA_ERROR = new LoadStatus(5, "数据异常");
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "LoadStatus{" +
                "code=" + code +
                ", desc='" + desc + '\'' +
                '}';
    }
}
