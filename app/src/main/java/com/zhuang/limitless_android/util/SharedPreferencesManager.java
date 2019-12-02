package com.zhuang.limitless_android.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.zhuang.limitless_android.config.AppConfig;

/**
 * @Package     : com.zhuang.limitless_android.util
 * @ClassName   : SharedPreferencesManager
 * @Description : SharedPreferences管理类
 * @author      : Zhuang
 * @date        : 2019-12-02 14:20
 */
public class SharedPreferencesManager {
    private static SharedPreferencesManager preferencesUtils;
    private static SharedPreferences preferences;
    private static SharedPreferences.Editor editor;

    private SharedPreferencesManager(Context context) {
        preferences = context.getSharedPreferences(AppConfig.USER, Context.MODE_PRIVATE);
        editor = preferences.edit();
    }

    public static SharedPreferencesManager getInstance(Context context) {
        if (preferencesUtils == null || preferences == null || editor == null) {
            preferencesUtils = new SharedPreferencesManager(context);
        }
        return preferencesUtils;
    }

    /**
     * @FunctionName : put
     * @Description  : 存储数据
     * @author       : Zhuang
     * @param        : key 存储的键
     * @param        : object 存储的值
     * @return       : void
     */
    public void put(String key, Object object) {
        if (object instanceof String) {
            editor.putString(key, (String) object);
        } else if (object instanceof Integer) {
            editor.putInt(key, (Integer) object);
        } else if (object instanceof Boolean) {
            editor.putBoolean(key, (Boolean) object);
        } else if (object instanceof Float) {
            editor.putFloat(key, (Float) object);
        } else if (object instanceof Long) {
            editor.putLong(key, (Long) object);
        } else {
            editor.putString(key, object.toString());
        }
        editor.commit();
    }

    /**
     * @FunctionName : get
     * @Description  : 获取数据
     * @author       : Zhuang
     * @param        : key 获取的键
     * @param        : defaultObject 默认值
     * @return       : java.lang.Object 返回数据
     */
    public Object get(String key, Object defaultObject) {
        if (defaultObject instanceof String) {
            return preferences.getString(key, (String) defaultObject);
        } else if (defaultObject instanceof Integer) {
            return preferences.getInt(key, (Integer) defaultObject);
        } else if (defaultObject instanceof Boolean) {
            return preferences.getBoolean(key, (Boolean) defaultObject);
        } else if (defaultObject instanceof Float) {
            return preferences.getFloat(key, (Float) defaultObject);
        } else if (defaultObject instanceof Long) {
            return preferences.getLong(key, (Long) defaultObject);
        } else {
            return preferences.getString(key, null);
        }
    }

    /**
     * @FunctionName : remove
     * @Description  : 清除某个键对应的值
     * @author       : Zhuang
     * @param        : key 清除数据的键
     * @return       : void
     */
    public void remove(String key) {
        editor.remove(key);
        editor.commit();
    }

    /**
     * @FunctionName : clear
     * @Description  : 清除全部数据
     * @author       : Zhuang
     * @param        : void
     * @return       : void
     */
    public void clear() {
        editor.clear();
        editor.commit();
    }

    /**
     * @FunctionName : contain
     * @Description  : 查询某个键是否存在
     * @author       : Zhuang
     * @param        : key 存储的键
     * @return       : java.lang.Boolean 返回结果
     */
    public Boolean contain(String key) {
        return preferences.contains(key);
    }
}
