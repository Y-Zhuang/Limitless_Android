package com.zhuang.limitless_android.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;


/**
 * @Package     : com.zhuang.limitless_android.util
 * @ClassName   : LimitlessUtil
 * @Description : APP工具类
 * @author      : Zhuang
 * @date        : 2019-12-02 14:20
 */
public class LimitlessUtil {

    /**
     * @FunctionName : byteToBitmap
     * @Description  : byte转换成Bitmap
     * @author       : Zhuang
     * @param        : bytes 图片byte
     * @return       : android.graphics.Bitmap
     */
    public static Bitmap byteToBitmap(byte[] bytes) {
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
    }
}
