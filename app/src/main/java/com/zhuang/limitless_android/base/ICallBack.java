package com.zhuang.limitless_android.base;

import okhttp3.Response;

/**
 * @Package         : com.zhuang.limitless_android.base
 * @InterfaceName   : ICallBack 
 * @Description     : model层回调
 * @author          : Zhuang
 * @date            : 2019-12-04 10:57
 */
public interface ICallBack {
    void success(Response response);
    void error(String error);
}
