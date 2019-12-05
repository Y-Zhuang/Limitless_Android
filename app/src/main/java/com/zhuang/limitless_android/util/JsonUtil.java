package com.zhuang.limitless_android.util;

import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package     : com.zhuang.limitless_android.util
 * @ClassName   : JsonUtil 
 * @Description : Json解析工具
 * @author      : Zhuang
 * @date        : 2019-12-04 17:19
 */
public class JsonUtil<T> {

    private static JsonUtil jsonUtil;
    private Class clazz;

    private JsonUtil(Class clazz) {
        this.clazz = clazz;
    }

    public static JsonUtil getInstance(Class clazz) {
        if (jsonUtil == null) {
            jsonUtil = new JsonUtil(clazz);
        }
        return jsonUtil;
    }

    /**
     * @FunctionName : responseToList
     * @Description  : Response转化成List
     * @author       : Zhuang
     * @param        : response OkHttp回调结果
     * @return       : java.util.List<T> 返回实体类List
     */
    public List<T> responseToList(Response response) {
        List<T> list = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(response.body().string());
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                list.add((T)com.alibaba.fastjson.JSONObject.parseObject(jsonObject.toString(),clazz));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
