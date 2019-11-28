package com.zhuang.limitless_android.utils;

import android.content.Context;
import com.franmontiel.persistentcookiejar.PersistentCookieJar;
import com.franmontiel.persistentcookiejar.cache.SetCookieCache;
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor;
import okhttp3.*;

import java.util.HashMap;
import java.util.Map;

/**
 * OkHttp工具类
 */
public class HttpUtils {
    private OkHttpClient mOkHttpClient;
    private static HttpUtils mHttpUtils;
    private Context context;

    private HttpUtils(Context context) {
        this.context = context;
        mOkHttpClient = new OkHttpClient.Builder()
                .cookieJar(new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(context)))
                .followRedirects(true)
                .followSslRedirects(true)
                .build();
    }

    public static HttpUtils getInstance(Context context) {
        if (mHttpUtils == null) {
            mHttpUtils = new HttpUtils(context);
        }
        return mHttpUtils;
    }

    /**
     * GET请求
     *
     * @param url      请求地址
     * @param callback 回调对象
     */
    public void get(String url, Callback callback) {
        Request.Builder builder = new Request.Builder().url(url);
        builder.method("GET", null);
        Request request = builder.build();
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(callback);
    }

    /**
     * POST请求
     *
     * @param url      请求地址
     * @param param    请求参数
     * @param callback 回调对象
     */
    public void post(String url, HashMap<String, String> param, Callback callback) {
        RequestBody requestBody = setParam(param).build();
        Request.Builder builder = new Request.Builder();
        Request request = builder.post(requestBody)
                .url(url)
                .build();
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(callback);
    }

    /**
     * 设置请求参数
     *
     * @param param 请求参数
     * @return 返回表单数据
     */
    public FormBody.Builder setParam(HashMap<String, String> param) {
        FormBody.Builder formBody = new FormBody.Builder();
        if (!param.isEmpty()) {
            for (Map.Entry<String, String> entry : param.entrySet()) {
                formBody.add(entry.getKey(), entry.getValue());
            }
        }
        return formBody;
    }
}
