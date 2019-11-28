package com.zhuang.limitless_android.contract;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public interface MainContract {
    /**
     * 基础视图接口
     */
    interface IBaseView {
        /**
         * 展示提示信息
         *
         * @param message 要提示的信息
         */
        void showMessage(String message);

        /**
         * 显示加载进度
         */
        void showProgress();

        /**
         * 隐藏加载进度
         */
        void dismissProgress();

        /**
         * 判断是否有网络
         *
         * @return 是否有网络
         */
        boolean hasNetwork();

        /**
         * activity 跳转
         *
         * @param clazz  目标 activity
         * @param bundle 传递的数据
         */
        void setIntent(Class clazz, Bundle bundle);

        /**
         * 获取上下文
         *
         * @return 返回上下文
         * */
        Context getContext();
    }

    /**
     * 基础控制接口
     */
    interface IBasePresenter<V extends IBaseView> {
        /**
         * 绑定视图
         *
         * @param view 需绑定的视图
         */
        void onBinding(V view);

        /**
         * 解除绑定
         */
        void onUnbind();

        /**
         * 获取 handler
         *
         * @return 返回 handler
         */
        Handler getHandler();
    }

    /**
     * 基础模型接口
     */
    interface IBaseModel {
        /**
         * 绑定handler
         *
         * @param handler 需绑定的 handler
         * @param context 上下文
         */
        void onBinding(Handler handler, Context context);

        /**
         * 解除绑定
         */
        void onUnbind();

        /**
         * 发送消息到P层
         *
         * @param message 消息
         */
        void sendMessage(Message message);

        /**
         * 发送延时消息到P层
         *
         * @param message     消息
         * @param delayedTime 延时时间
         */
        void sendMessageDelayed(Message message, long delayedTime);

        /**
         * 发送空消息到P层
         *
         * @param what 信息
         */
        void sendEmptyMessage(int what);

        /**
         * 判断是否为空
         *
         * @param handler 需判断的 handler
         * @return 是否为空
         */
        boolean isEmpty(Handler handler);
    }
}
