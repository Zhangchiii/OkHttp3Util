package com.example.utils;

import okhttp3.Callback;


import java.io.IOException;

/**
 * Created by itxuye on 2017/3/17.
 */
public interface HttpWrapper {

    /**
     * get同步请求
     *
     * @param url 请求url
     * @return 返回的字符串
     * @throws IOException 网络请求异常
     */
    String get(String url) throws IOException;

    /**
     * post同步请求
     *
     * @param url  请求url
     * @param json 请求body(json)
     * @return 返回的字符串
     * @throws IOException 网络请求异常
     */
    String post(String url, String json) throws IOException;

    /**
     * 异步get请求
     *
     * @param url 请求url
     */
    void asynchronousGet(String url, Callback callback);

    /**
     * 异步post
     *
     * @param url  请求url
     * @param json 请求body(json)
     */
    void asynchronousPost(String url, String json, Callback callback);
}
