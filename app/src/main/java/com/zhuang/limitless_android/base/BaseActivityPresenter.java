package com.zhuang.limitless_android.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * @Package     : com.zhuang.limitless_android.base
 * @ClassName   : BaseActivityPresenter 
 * @Description : 基础ActivityPresenter封装
 * @author      : Zhuang
 * @date        : 2019-12-02 18:36
 */
public abstract class BaseActivityPresenter<T extends IBaseView> extends AppCompatActivity {

    protected T layoutView;

    public BaseActivityPresenter(){
        try {
            layoutView = getLayoutViewClass().newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException("create View error");
        } catch (IllegalAccessException e) {
            throw new RuntimeException("create View error");
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        layoutView.create(getLayoutInflater(),null,savedInstanceState);
        setContentView(layoutView.getRootView());
        layoutView.initWidget();
        layoutView.bindEvent();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (viewDelegate == null) {
            try {
                layoutView = getLayoutViewClass().newInstance();
            } catch (InstantiationException e) {
                throw new RuntimeException("create View error");
            } catch (IllegalAccessException e) {
                throw new RuntimeException("create View error");
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        layoutView = null;
    }

    protected abstract Class<T> getLayoutViewClass();
}
