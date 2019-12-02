package com.zhuang.limitless_android.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;

/**
 * @Package         : com.zhuang.limitless_android.base
 * @InterfaceName   : IBaseView
 * @Description     : 基础视图接口
 * @author          : Zhuang
 * @date            : 2019-12-02 14:20
 */
public interface IBaseView {
    /**
     * @FunctionName : create
     * @Description  : 创建视图
     * @author       : Zhuang
     * @param        : inflater
     * @param        : container
     * @param        : savedInstanceState
     * @return       : void
     */
    void create(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    /**
     * @FunctionName : getRootView
     * @Description  : 获取视图
     * @author       : Zhuang
     * @param        : void
     * @return       : View
     */
    View getRootView();

    /**
     * @FunctionName : initWidget
     * @Description  : 初始化
     * @author       : Zhuang
     * @param        : void
     * @return       : void
     */
    void initWidget();

    /**
     * @FunctionName : bindEvent
     * @Description  : 绑定事件监听器
     * @author       : Zhuang
     * @param        : void
     * @return       : void
     */
    void bindEvent();
}
