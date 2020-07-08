package com.example.qi.myandroidstructure;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

public class MyApplication extends Application {

    private static RefWatcher refWatcher;

    @Override
    public void onCreate() {
        super.onCreate();
        /*
         *在注册之前先判断LeakCanary是否已经运行在手机上，
         * 比如你同时有多个APP集成了LeakCanary，其他app已经运行了LeakCanary则不需要重新install
         * */
//        if (LeakCanary.isInAnalyzerProcess(this)) {
//            return;
//        }
        // 要获取此对象的话，就不需要判断是否已经安装
        refWatcher = LeakCanary.install(this);
    }

    public static RefWatcher getRefWatcher() {
        return refWatcher;
    }

}
