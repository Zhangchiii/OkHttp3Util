package com.example.utils;

import okhttp3.*;

import java.io.IOException;

/**
 * Created by itxuye on 2017/3/17.
 */
public class OkhttpLoader implements HttpWrapper{
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private static final OkHttpClient okHttpClient = new OkHttpClient();

    OkhttpLoader(){

    }
    /**
     * get同步请求
     *
     * @param url 请求url
     * @return 返回的字符串
     * @throws IOException 网络请求异常
     */
    public  String get(String url) throws IOException {
        Request request = new Request.Builder().url(url).get().build();
        Response response = okHttpClient.newCall(request).execute();
        return response.body().string();
    }

    /**
     * post同步请求
     *
     * @param url  请求url
     * @param json 请求body(json)
     * @return 返回的字符串
     * @throws IOException 网络请求异常
     */
    public String post(String url, String json) throws IOException {

        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder().url(url).post(body).build();
        Response response = okHttpClient.newCall(request).execute();
        return response.body().string();

    }

    /**
     * 异步get请求
     *
     * @param url 请求url
     */
    public void asynchronousGet(String url, Callback callback) {
        Request request = new Request.Builder().url(url).build();
        okHttpClient.newCall(request).enqueue(callback);
    }

    /**
     * 异步post
     *
     * @param url  请求url
     * @param json 请求body(json)
     */
    public void asynchronousPost(String url, String json, Callback callback) {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder().url(url).post(body).build();
        okHttpClient.newCall(request).enqueue(callback);
    }
}
