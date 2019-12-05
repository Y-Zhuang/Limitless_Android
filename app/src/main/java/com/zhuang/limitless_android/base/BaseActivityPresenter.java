package com.zhuang.limitless_android.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import com.zhuang.limitless_android.R;

import java.util.List;

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
        if (layoutView == null) {
            try {
                layoutView = getLayoutViewClass().newInstance();
            } catch (InstantiationException e) {
                throw new RuntimeException("create View error");
            } catch (IllegalAccessException e) {
                throw new RuntimeException("create View error");
            }
        }
    }

    /**
     * @FunctionName : switchFragment
     * @Description  : fragment显示方法
     * @author       : Zhuang
     * @param        : frameLayout 在activity的frameLayout布局id
     * @param        : fragment 要显示的fragment
     * @return       : void
     */
    public void switchFragment(int frameLayout,Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        List<Fragment> childFragments = getSupportFragmentManager().getFragments();
        for (Fragment childFragment : childFragments) {
            fragmentTransaction.hide(childFragment);
        }
        if(!childFragments.contains(fragment)){
            fragmentTransaction.add(frameLayout,fragment);
        }else{
            fragmentTransaction.show(fragment);
        }
        fragmentTransaction.commit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        layoutView = null;
    }

    protected abstract Class<T> getLayoutViewClass();
}
