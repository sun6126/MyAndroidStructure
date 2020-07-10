package com.example.qi.myandroidstructure.jetpack;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

/*
*  实现lifecyclerObserver，可以监听activity的生命周期
*  需要在activity中注册这个observer
* */
public class MyLifeObserver implements LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void start(){
        Log.e("lifecycler", "start");
    }

}
