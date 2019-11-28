package com.zhuang.limitless_android.presenter;

import android.os.Message;
import com.zhuang.limitless_android.base.BasePresenter;
import com.zhuang.limitless_android.model.modelimpl.MainModel;
import com.zhuang.limitless_android.view.activity.LoginActivity;
import com.zhuang.limitless_android.view.activity.MainActivity;

public class MainPresenter extends BasePresenter<MainActivity, MainModel> {
    @Override
    public MainModel binModel() {
        return new MainModel();
    }

    @Override
    public void modelResponse(Message msg) {
        switch (msg.obj.toString()) {

        }
    }

}
