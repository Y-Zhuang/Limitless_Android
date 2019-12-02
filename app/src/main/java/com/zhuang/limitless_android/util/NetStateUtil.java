package com.zhuang.limitless_android.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.zhuang.limitless_android.R;

/**
 * 得到网络状态的工具类
 */
/**
 * @Package     : com.zhuang.limitless_android.util
 * @ClassName   : NetStateUtil
 * @Description : 获取网络状态
 * @author      : Zhuang
 * @date        : 2019-12-02 14:20
 */
public class NetStateUtil {

    /**
     * @FunctionName : isConn
     * @Description  : 判断网络连接是否已开
     * @author       : Zhuang
     * @param        : context 上下文
     * @return       : boolean 返回网络状态
     */
    public static boolean isConn(Context context) {
        boolean bisConnFlag = false;
        ConnectivityManager conManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo network = conManager.getActiveNetworkInfo();
        if (network != null) {
            bisConnFlag = conManager.getActiveNetworkInfo().isAvailable();
        }
        return bisConnFlag;
    }

    /**
     * @FunctionName : showNoNetWorkDlg
     * @Description  : 判断当前手机没有网络时选择是否打开网络设置
     * @author       : Zhuang
     * @param        : context 上下文
     * @return       : void
     */
    public static void showNoNetWorkDlg(final Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setIcon(R.mipmap.ic_launcher)         //
                .setTitle(R.string.app_name)            //
                .setMessage("当前无网络").setPositiveButton("设置", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // 跳转到系统的网络设置界面
                Intent intent = null;
                // 先判断当前系统版本
                if (android.os.Build.VERSION.SDK_INT > 10) {  // 3.0以上
                    intent = new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS);
                } else {
                    intent = new Intent();
                    intent.setClassName("com.android.settings", "com.android.settings.WirelessSettings");
                }
                context.startActivity(intent);

            }
        }).setNegativeButton("知道了", null).show();
    }

}
