package com.zhuang.limitless_android.presenter.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import com.zhuang.limitless_android.R;
import com.zhuang.limitless_android.base.BaseActivityPresenter;
import com.zhuang.limitless_android.presenter.fragment.LoginFragment;
import com.zhuang.limitless_android.view.activity.LoginView;

/**
 * @Package     : com.zhuang.limitless_android.presenter.activity
 * @ClassName   : LoginActivity 
 * @Description : 登陆注册类
 * @author      : Zhuang
 * @date        : 2019-12-04 16:22
 */
public class LoginActivity extends BaseActivityPresenter<LoginView> {
    @Override
    protected Class<LoginView> getLayoutViewClass() {
        return LoginView.class;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        switchFragment(layoutView.getFrameLayout(),new LoginFragment());
        layoutView.setSelected(R.id.login_Btn,1.2f,getResources().getColor(R.color.colorBlue));
    }
}
