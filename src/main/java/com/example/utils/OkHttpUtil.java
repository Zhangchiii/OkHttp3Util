package com.example.utils;

import okhttp3.*;

import java.io.IOException;

/**
 * Created by Ricky on 2017/3/17.
 */
public class OkHttpUtil {

    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private static final OkHttpClient okHttpClient = new OkHttpClient();

    /**
     * get同步请求
     *
     * @param url 请求的url
     * @return 返回的字符串
     * @throws IOException 网络请求异常
     */
    public static String get(String url) throws IOException {
        Request request = new Request.Builder().url(url).get().build();
        Response response = okHttpClient.newCall(request).execute();
        return response.body().string();
    }

    /**
     * post请求，json数据为body
     *
     * @param url  请求路径
     * @param json 请求body（json）
     */
    public static String post(String url, String json) throws IOException {

        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder().url(url).post(body).build();
        Response response = okHttpClient.newCall(request).execute();
        return response.body().string();

    }

    /**
     * 异步get请求
     *
     * @param url 请求url
     * @return 响应的json字符串
     */
    public static void asynchronousGet(String url) {
        Request request = new Request.Builder().url(url).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("获取结果失败");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();
                System.out.println(result);
            }
        });
    }

    /**
     * 异步post
     * @param url 请求url
     * @param json 请求body(json)
     */
    public static void asynchronousPost(String url, String json) {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder().url(url).post(body).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("获取结果失败");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();
                System.out.println(result);
            }
        });
    }
}
