package com.example.qi.myandroidstructure;

import android.app.Application;

import com.example.qi.myandroidstructure.di.DaggerCarComponent;
import com.example.qi.myandroidstructure.di.DaggerMyComponent;
import com.example.qi.myandroidstructure.di.DatabaseModule;
import com.example.qi.myandroidstructure.di.HttpModule;
import com.example.qi.myandroidstructure.di.MyComponent;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

import dagger.Component;

public class MyApplication extends Application {

    private static RefWatcher refWatcher;
    private MyComponent myComponent;

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

        // 提前注入component,生成module和component对象
        myComponent = DaggerMyComponent.builder()
                .databaseModule(new DatabaseModule())
                .httpModule(new HttpModule())
                .carComponent(DaggerCarComponent.create()) // 增加依赖的component
                .build();
    }

    public static RefWatcher getRefWatcher() {
        return refWatcher;
    }

    public MyComponent getComponent() {
        return myComponent;
    }

}
