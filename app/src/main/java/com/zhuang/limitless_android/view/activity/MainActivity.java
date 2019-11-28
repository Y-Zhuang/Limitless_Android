package com.zhuang.limitless_android.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import com.zhuang.limitless_android.R;
import com.zhuang.limitless_android.base.BaseActivity;
import com.zhuang.limitless_android.presenter.MainPresenter;
import com.zhuang.limitless_android.utils.SharedPreferencesUtils;

public class MainActivity extends BaseActivity<MainPresenter> {

    @Override
    protected void initLayout(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        if(!hasNetwork()){
            showMessage("无网络");
        }
        else if(SharedPreferencesUtils.getInstance(this).contain("userName")){
            setIntent(LoginActivity.class,null);
        }
    }

    @Override
    protected void initData() {

    }

    @Override
    protected MainPresenter binPresenter() {
        return new MainPresenter();
    }

}
