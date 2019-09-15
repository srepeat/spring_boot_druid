package com.sxt.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author 鲜磊 on 2019/9/14
 **/
public class GsonUtils {

    public static Gson createGson(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setDateFormat("yyyy-MM-dd HH:mm:ss");
        return gsonBuilder.create();
    }
}
