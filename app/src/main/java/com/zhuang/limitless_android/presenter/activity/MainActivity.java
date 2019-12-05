package com.zhuang.limitless_android.presenter.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import com.zhuang.limitless_android.base.BaseActivityPresenter;
import com.zhuang.limitless_android.base.ICallBack;
import com.zhuang.limitless_android.bean.User;
import com.zhuang.limitless_android.model.UserModel;
import com.zhuang.limitless_android.util.JsonUtil;
import com.zhuang.limitless_android.util.LimitlessUtil;
import com.zhuang.limitless_android.util.NetStateUtil;
import com.zhuang.limitless_android.util.SharedPreferencesManager;
import com.zhuang.limitless_android.view.activity.MainView;
import okhttp3.Response;

import java.io.IOException;

/**
 * @Package     : com.zhuang.limitless_android.presenter.activity
 * @ClassName   : MainActivity 
 * @Description : 入口Activity
 * @author      : Zhuang
 * @date        : 2019-12-02 18:12
 */
public class MainActivity extends BaseActivityPresenter<MainView> {
    @Override
    protected Class<MainView> getLayoutViewClass() {
        return MainView.class;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!NetStateUtil.isConn(this)) {
            layoutView.toast("无网络");
        }else if(!SharedPreferencesManager.getInstance(this).contain("userName")){
            startActivity(new Intent(this,LoginActivity.class));
            finish();
        }
    }

    public void login() {
        new UserModel(this).login(new ICallBack() {
            @Override
            public void success(Response response) {
                try {
                    if (response.body().string().replace("\"", "").equals("SUCCESS")) {
                        layoutView.toast("成功");
                    } else {
                        layoutView.toast("失败");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void error(String error) {
                layoutView.toast("错误");
            }
        });
    }

    public void isLogin() {
        new UserModel(this).isLogin(new ICallBack() {
            @Override
            public void success(Response response) {
//                Log.e("isLogin",JsonUtil.getInstance(User.class).responseToList(response).toString());
//                try {
//                    if (response.body().string().replace("\"", "").equals("TRUE")) {
//                        layoutView.toast("已登录");
//                    } else {
//                        layoutView.toast("未登录");
//                    }
//                } catch (IOException e) {
//                    e.printStackTrace();
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                    Log.e("E",e.toString());
//                }
//                for (User user : (List<User>)JsonUtil.getInstance(User.class).responseToList(response)){
//                    Log.e("id",user.getId().toString());
//                    Log.e("userName",user.getUserName());
//                    Log.e("userPassword",user.getUserPassword());
//                    Log.e("userPicture", String.valueOf(user.getUserPicture()));
//                }
                User user = (User) JsonUtil.getInstance(User.class).responseToList(response).get(0);
                Log.e("getUserPicture", user.getUserName());
                Bitmap bitmap = LimitlessUtil.byteToBitmap(user.getUserPicture());
                if(bitmap == null){
                    Log.e("null","null");
                }
                layoutView.setImg(bitmap);
            }

            @Override
            public void error(String error) {
                layoutView.toast("错误");
            }
        });
    }
}
