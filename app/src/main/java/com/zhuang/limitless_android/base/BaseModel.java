package com.zhuang.limitless_android.base;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.zhuang.limitless_android.contract.MainContract;

/**
 * 基础模型类
 */
public class BaseModel implements MainContract.IBaseModel {
    protected Handler mHandler;
    protected Context mContext;
    public static final String ERROR = "error";

    @Override
    public void onBinding(Handler handler, Context context) {
        mHandler = handler;
        mContext = context;
    }

    @Override
    public void onUnbind() {
        mHandler = null;
    }

    @Override
    public void sendMessage(Message message) {
        mHandler.sendMessage(message);
    }

    @Override
    public void sendMessageDelayed(Message message, long delayedTime) {
        mHandler.sendMessageDelayed(message, delayedTime);
    }

    @Override
    public void sendEmptyMessage(int what) {
        mHandler.sendEmptyMessage(what);
    }

    @Override
    public boolean isEmpty(Handler handler) {
        if (mHandler != null) {
            return true;
        }
        return false;
    }
}
