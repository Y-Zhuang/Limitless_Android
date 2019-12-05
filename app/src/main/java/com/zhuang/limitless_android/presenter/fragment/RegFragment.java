package com.zhuang.limitless_android.presenter.fragment;

import com.zhuang.limitless_android.base.BaseFragmentPresenter;
import com.zhuang.limitless_android.view.fragment.RegLayer;

/**
 * @Package     : com.zhuang.limitless_android.presenter.fragment
 * @ClassName   : RegFragment 
 * @Description : 注册fragment
 * @author      : Zhuang
 * @date        : 2019-12-05 16:40
 */
public class RegFragment extends BaseFragmentPresenter<RegLayer> {
    @Override
    protected Class<RegLayer> getLayoutViewClass() {
        return RegLayer.class;
    }
}
