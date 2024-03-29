package com.zhuang.limitless_android.config;

/**
 * @Package     : com.zhuang.limitless_android.config
 * @ClassName   : AppConfig
 * @Description : APP配置类
 * @author      : Zhuang
 * @date        : 2019-12-02 14:20
 */
public class AppConfig {
    public static final String USER = "USER";
    public static final String IP = "http://192.168.12.113:";
    public static final int PORT = 8080;

    //判断是否登录
    public static final String IS_LOGIN = "/user/isLogin";
    //登录
    public static final String LOGIN ="/user/loginUser";
    //获取所有板块
    public static final String GET_PLATE_ALL = "/admin/getUserAll";
    public static final String ADMIN_LOGIN = "/admin/loginAdmin";
}
