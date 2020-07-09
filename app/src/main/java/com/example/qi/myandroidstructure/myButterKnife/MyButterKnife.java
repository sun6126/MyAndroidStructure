package com.example.qi.myandroidstructure.myButterKnife;

import android.app.Activity;

public class MyButterKnife {

    public static void bind(Activity activity){
        String name = activity.getClass().getName() + "_ViewBinding"; // 得到全类名 + “viewbinding”
        try {
            // 获取到通过注解生成器生成的类，他已经实现了 IBinder接口
            Class<?> aClass = Class.forName(name);
            IBinder instance = (IBinder)aClass.newInstance();
            instance.bind(activity);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
