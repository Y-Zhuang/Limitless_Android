package com.zhuang.limitless_android.model;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import com.zhuang.limitless_android.base.ICallBack;
import com.zhuang.limitless_android.config.AppConfig;
import com.zhuang.limitless_android.util.HttpManager;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.HashMap;

/**
 * @Package     : com.zhuang.limitless_android.model
 * @ClassName   : UserModel 
 * @Description : 用户操作类
 * @author      : Zhuang
 * @date        : 2019-12-03 9:14
 */
public class UserModel {

    private Context context;

    public UserModel(Context context){
        this.context = context;
    }

    public void login(final ICallBack iCallBack){
        HashMap<String,String> user = new HashMap<>();
        user.put("adminName","admin");
        user.put("adminPassword","admin");
        HttpManager.getInstance(context).post(AppConfig.IP + AppConfig.PORT + AppConfig.ADMIN_LOGIN, user, new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                iCallBack.error(e.toString());
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull final Response response) throws IOException {
                iCallBack.success(response);
            }
        });
    }

    public void isLogin(final ICallBack iCallBack){
        HttpManager.getInstance(context).post(AppConfig.IP + AppConfig.PORT + AppConfig.GET_PLATE_ALL, null, new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                iCallBack.error(e.toString());
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                iCallBack.success(response);
            }
        });
    }

}
