package com.zhuang.limitless_android.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.zhuang.limitless_android.config.AppConfig;

import java.util.HashMap;

public class SharedPreferencesUtils {
    private static SharedPreferencesUtils preferencesUtils;
    private static SharedPreferences preferences;
    private static SharedPreferences.Editor editor;

    private SharedPreferencesUtils(Context context) {
        preferences = context.getSharedPreferences(AppConfig.USER, Context.MODE_PRIVATE);
        editor = preferences.edit();
    }

    public static SharedPreferencesUtils getInstance(Context context) {
        if (preferencesUtils == null || preferences == null || editor == null) {
            preferencesUtils = new SharedPreferencesUtils(context);
        }
        return preferencesUtils;
    }

    /**
     * 存储数据
     *
     * @param key    存储的键
     * @param object 存储的值
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
     * 获取数据
     *
     * @param key           存储的键
     * @param defaultObject 默认值
     * @return 返回数据
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
     * 清除某个键对应的值
     *
     * @param key 存储的键
     */
    public void remove(String key) {
        editor.remove(key);
        editor.commit();
    }

    /**
     * 清除所有数据
     */
    public void clear() {
        editor.clear();
        editor.commit();
    }

    /**
     * 查询某个键是否存在
     *
     * @param key 存储的键
     * @return 返回结果
     */
    public Boolean contain(String key) {
        return preferences.contains(key);
    }
}
