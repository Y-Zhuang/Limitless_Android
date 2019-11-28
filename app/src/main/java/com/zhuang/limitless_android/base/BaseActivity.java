package com.zhuang.limitless_android.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import butterknife.ButterKnife;
import com.zhuang.limitless_android.utils.NetStateUtils;
import com.zhuang.limitless_android.contract.MainContract;
import com.zhuang.limitless_android.view.activity.MainActivity;

/**
 * 基础 Activity
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements MainContract.IBaseView {

    protected P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initLayout(savedInstanceState);
        ButterKnife.bind(this);
        mPresenter = binPresenter();
        //绑定view
        mPresenter.onBinding(this);
        initData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onUnbind();
        mPresenter = null;
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void dismissProgress() {

    }

    @Override
    public boolean hasNetwork() {
        return NetStateUtils.isConn(this);
    }

    @Override
    public void setIntent(Class clazz, Bundle bundle){
        Intent intent = new Intent(this, clazz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    @Override
    public Context getContext(){
        return this;
    }

    /**
     * 初始化布局
     **/
    protected abstract void initLayout(@Nullable Bundle savedInstanceState);

    /**
     * 初始化data
     **/
    protected abstract void initData();

    /**
     * 获取Presenter
     **/
    protected abstract P binPresenter();
}
