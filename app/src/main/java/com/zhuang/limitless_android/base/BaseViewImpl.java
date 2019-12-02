package com.zhuang.limitless_android.base;

import android.app.Activity;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.Toast;

/**
 * @Package     : com.zhuang.limitless_android.base
 * @ClassName   : BaseViewImpl 
 * @Description : 基础视图实现类
 * @author      : Zhuang
 * @date        : 2019-12-02 18:22
 */
public abstract class BaseViewImpl implements IBaseView {

    protected final SparseArray<View> mViews = new SparseArray<View>();
    protected View rootView;

    @Override
    public void create(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(getRootLayoutId(),container,false);
    }

    @Override
    public View getRootView() {
        return rootView;
    }

    public void setRootView(View rootView){
        this.rootView = rootView;
    }

    @Override
    public void initWidget() {

    }

    @Override
    public void bindEvent() {

    }

    public void toast(CharSequence msg) {
        Toast.makeText(rootView.getContext(), msg, Toast.LENGTH_SHORT).show();
    }

    public <T extends Activity> T getActivity() {
        return (T)rootView.getContext();
    }

    public <T extends View> T bindView(int id) {
        T view = (T) mViews.get(id);
        if (view == null) {
            view = (T) rootView.findViewById(id);
            mViews.put(id, view);
        }
        return view;
    }

    public <T extends View> T get(int id) {
        return (T) bindView(id);
    }


    public abstract int getRootLayoutId();
}
