package com.zhuang.limitless_android.base;

import android.os.Handler;
import android.os.Message;
import com.zhuang.limitless_android.contract.MainContract;

import java.lang.ref.WeakReference;

/**
 * 基础控制类
 */
public abstract class BasePresenter<V extends MainContract.IBaseView, M extends BaseModel> implements MainContract.IBasePresenter {
    protected V mView;
    protected M mModel;

    @Override
    public void onBinding(MainContract.IBaseView view) {
        mView =(V) view;
        mModel = binModel();
        mModel.onBinding(getHandler(), mView.getContext());
    }

    @Override
    public void onUnbind() {
        mModel.onUnbind();
        mModel = null;
        mView = null;
    }

    @Override
    public Handler getHandler() {
        return new BaseHandler(this);
    }

    /**
     * 绑定模型
     *
     * @return 模型
     */
    public abstract M binModel();

    /**
     * 处理返回的消息
     *
     * @param msg 消息
     */
    public abstract void modelResponse(Message msg);

    /**
     * 基础 Handler
     */
    public static class BaseHandler extends Handler {
        //弱引用Activity或者Fragment 避免Handler持有导致内存泄漏
        private final WeakReference<BasePresenter> presenter;

        public BaseHandler(BasePresenter presenter) {
            this.presenter = new WeakReference<>(presenter);
        }

        @Override
        public void handleMessage(Message msg) {
            if (presenter.get() != null && presenter.get().mView != null) {
                presenter.get().modelResponse(msg);
            }
        }
    }
}
