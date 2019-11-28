package com.zhuang.limitless_android.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.zhuang.limitless_android.utils.NetStateUtils;
import com.zhuang.limitless_android.contract.MainContract;

public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements MainContract.IBaseView {

    protected P mPresenter;
    protected View mView;
    private Unbinder unbinder;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = binPresenter();
        //绑定view
        mPresenter.onBinding(this);
        initData();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(initLayout(), container, false);
        unbinder = ButterKnife.bind(this, mView);
        initData();
        return mView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.onUnbind();
        mPresenter = null;
        unbinder.unbind();
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void dismissProgress() {

    }

    @Override
    public boolean hasNetwork() {
        return NetStateUtils.isConn(getContext());
    }

    @Override
    public void setIntent(Class clazz, Bundle bundle) {
        Intent intent = new Intent(getActivity(), clazz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    @Override
    public Context getContext(){
        return getContext();
    }

    /**
     * 初始化布局
     **/
    protected abstract int initLayout();

    /**
     * 初始化data
     **/
    protected abstract void initData();

    /**
     * 获取Presenter
     **/
    protected abstract P binPresenter();
}
