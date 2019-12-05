package com.zhuang.limitless_android.view.activity;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.zhuang.limitless_android.R;
import com.zhuang.limitless_android.base.BaseViewImpl;
import com.zhuang.limitless_android.presenter.activity.MainActivity;

/**
 * @Package     : com.zhuang.limitless_android.view.activity
 * @ClassName   : MainView 
 * @Description : 入口视图
 * @author      : Zhuang
 * @date        : 2019-12-02 19:29
 */
public class MainView extends BaseViewImpl implements View.OnClickListener {
    private Button loginBtn;
    private Button isLoginBtn;
    private ImageView img;

    @Override
    public int getRootLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initWidget() {
        super.initWidget();
        loginBtn = get(R.id.login_Btn);
        isLoginBtn = get(R.id.isLogin_Btn);
        img = get(R.id.img);
    }

    @Override
    public void bindEvent() {
        super.bindEvent();
        loginBtn.setOnClickListener(this);
        isLoginBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.login_Btn:
                ((MainActivity)getActivity()).login();
                break;
            case R.id.isLogin_Btn:
                ((MainActivity)getActivity()).isLogin();
                break;
            default:
                break;
        }
    }

    public void setImg(final Bitmap bitmap){
        img.post(new Runnable() {
            @Override
            public void run() {
                img.setImageBitmap(bitmap);
            }
        });
    }
}
