package com.zhuang.limitless_android.presenter.fragment;

import com.zhuang.limitless_android.base.BaseFragmentPresenter;
import com.zhuang.limitless_android.view.fragment.LoginLayer;

/**
 * @Package     : com.zhuang.limitless_android.presenter.fragment
 * @ClassName   : LoginFragment 
 * @Description : 登录fragment
 * @author      : Zhuang
 * @date        : 2019-12-05 14:59
 */
public class LoginFragment extends BaseFragmentPresenter<LoginLayer> {
    @Override
    protected Class<LoginLayer> getLayoutViewClass() {
        return LoginLayer.class;
    }
}
