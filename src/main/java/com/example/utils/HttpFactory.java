package com.example.utils;

/**
 * Created by itxuye on 2017/3/17.
 */
public class HttpFactory {

    private static HttpWrapper sInstance;

    private HttpFactory() {

    }

    /**
     * 获取OkHttp实例
     *
     * @return 返回一个OkHttp实例
     */
    public static HttpWrapper getLoader() {
        if (sInstance == null) {
            synchronized (HttpFactory.class) {
                if (sInstance == null) {
                    sInstance = new OkHttpLoader();
                }
            }
        }
        return sInstance;
    }
}

