package com.flag.myapplication.shipin;

import android.app.Application;


import org.xutils.x;

/**
 * @anthor : 大海
 * 每天进步一点点
 */


public class MyApplication extends Application {

    private static MyApplication instance;


    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        //是否输出debug日志
        x.Ext.setDebug(BuildConfig.DEBUG);
        //数据库配置
        Xutils.initDbConfiginit();
        //JPushInterface.setDebugMode(true); 	// 设置开启日志,发布时请关闭日志
       // JPushInterface.init(this);

    }


    public static MyApplication getInstance() {
        return instance;
    }
}
