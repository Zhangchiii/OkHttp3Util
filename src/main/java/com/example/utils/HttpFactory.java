package com.example.utils;

/**
 * Created by itxuye on 2017/3/17.
 */
public class HttpFactory {
    private static HttpWrapper sInstance;

    private HttpFactory() {

    }

    /**
     * 获取http
     *
     * @return
     */
    public static HttpWrapper getLoader() {
        if (sInstance == null) {
            synchronized (HttpFactory.class) {
                if (sInstance == null) {
                    sInstance = new OkhttpLoader();
                }
            }
        }
        return sInstance;
    }
}

