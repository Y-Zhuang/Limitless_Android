package com.zhuang.limitless_android.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @Package     : com.zhuang.limitless_android.base
 * @ClassName   : BaseFragmentPresenter 
 * @Description : 基础FragmentPresenter封装
 * @author      : Zhuang
 * @date        : 2019-12-02 18:44
 */
public abstract class BaseFragmentPresenter<T extends IBaseView> extends Fragment {

    public T layoutView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            layoutView = getLayoutViewClass().newInstance();
        } catch (java.lang.InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Nullable
    @Override
    public android.view.View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        layoutView.create(inflater,container,savedInstanceState);
        return layoutView.getRootView();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        layoutView.initWidget();
        layoutView.bindEvent();
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if (layoutView == null) {
            try {
                layoutView = getLayoutViewClass().newInstance();
            } catch (java.lang.InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        layoutView = null;
    }

    protected abstract Class<T> getLayoutViewClass();
}
