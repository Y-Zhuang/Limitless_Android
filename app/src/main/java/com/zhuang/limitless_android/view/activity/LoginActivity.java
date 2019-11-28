package com.zhuang.limitless_android.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import com.zhuang.limitless_android.R;
import com.zhuang.limitless_android.base.BaseActivity;
import com.zhuang.limitless_android.presenter.MainPresenter;

public class LoginActivity extends BaseActivity<MainPresenter> {

    @Override
    protected void initLayout(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_login);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected MainPresenter binPresenter() {
        return new MainPresenter();
    }
}
