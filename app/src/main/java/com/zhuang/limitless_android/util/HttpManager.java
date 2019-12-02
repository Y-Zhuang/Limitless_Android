package com.zhuang.limitless_android.util;

import android.content.Context;
import com.franmontiel.persistentcookiejar.PersistentCookieJar;
import com.franmontiel.persistentcookiejar.cache.SetCookieCache;
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor;
import okhttp3.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @Package     : com.zhuang.limitless_android.util
 * @ClassName   : HttpManager
 * @Description : OkHttp管理类
 * @author      : Zhuang
 * @date        : 2019-12-02 14:20
 */
public class HttpManager {
    private OkHttpClient mOkHttpClient;
    private static HttpManager mHttpManager;
    private Context context;

    private HttpManager(Context context) {
        this.context = context;
        mOkHttpClient = new OkHttpClient.Builder()
                .cookieJar(new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(context)))
                .followRedirects(true)
                .followSslRedirects(true)
                .build();
    }

    public static HttpManager getInstance(Context context) {
        if (mHttpManager == null) {
            mHttpManager = new HttpManager(context);
        }
        return mHttpManager;
    }

    /**
     * @FunctionName : get
     * @Description  : GET请求
     * @author       : Zhuang
     * @param        : url 请求地址
     * @param        : callback 回调对象
     * @return       : void
     */
    public void get(String url, Callback callback) {
        Request.Builder builder = new Request.Builder().url(url);
        builder.method("GET", null);
        Request request = builder.build();
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(callback);
    }

    /**
     * @FunctionName : post
     * @Description  : POST请求
     * @author       : Zhuang
     * @param        : url 请求地址
     * @param        : param 请求参数
     * @param        : callback 结果回调
     * @return       : void
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
     * @FunctionName : setParam
     * @Description  : 设置POST传输数据
     * @author       : Zhuang
     * @param        : param 需传输的数据
     * @return       : okhttp3.FormBody.Builder 返回表单数据
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
