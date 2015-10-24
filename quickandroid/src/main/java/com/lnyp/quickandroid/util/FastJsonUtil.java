package com.lnyp.quickandroid.util;

import com.alibaba.fastjson.JSON;

import java.util.List;

public class FastJsonUtil {

    /**
     * 将对象转化为字符串
     */
    public String Object2Json2(Object obj) {
        return JSON.toJSONString(obj);
    }

    /**
     * 将对象转化为字符串(泛型实现)
     */
    public static <T> String t2Json2(T t) {
        return JSON.toJSONString(t);
    }

    /**
     * 将字符转化为对象
     */
    public static <T> T json2T(String jsonString, Class<T> clazz) {
        return JSON.parseObject(jsonString, clazz);
    }

    /**
     * 将字符串数组转化为对象集合
     */
    public static <T> List<T> json2Collection(String jsonStr, Class<T> clazz) {
        return JSON.parseArray(jsonStr, clazz);
    }
}
