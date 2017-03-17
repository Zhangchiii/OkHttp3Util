package com.example.controller;

import com.example.utils.HttpFactory;
import com.example.utils.HttpWrapper;

import java.io.IOException;

/**
 * com.example.controller
 * Created by zhangchi on 2017/3/17.
 */
public class Test {


    public static void main(String[] args) {
        HttpWrapper httpWrapper = HttpFactory.getLoader();
        try {
            String result = httpWrapper.get("http://www.baidu.com");
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
