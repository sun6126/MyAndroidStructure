package com.example.qi.myandroidstructure.jetpack;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import java.util.HashMap;
import java.util.Map;

public class LiveDataBus {
    // 存放订阅者的map
    private Map<String, MutableLiveData<Object>> map;

    private LiveDataBus() {
        map = new HashMap<>();
    }

    private static LiveDataBus liveDataBus = new LiveDataBus();

    public static LiveDataBus getInstance() {
        return liveDataBus;
    }

    /*
     * 用户订阅方法
     * */
    public synchronized <T> MutableLiveData<T> with(String key, Class<T> type) {
        if (!map.containsKey(key)) {
            map.put(key, new MutableLiveData<Object>());
        }
        return (MutableLiveData<T>) map.get(key);
    }

    /*
    *  修改 liveData中的version，来控制 接收消息方接不接收消息
    * */
    public static class BusMutableLiveData<T> extends MutableLiveData<T>{

        @Override
        public void observe(@NonNull LifecycleOwner owner, @NonNull Observer<? super T> observer) {
            super.observe(owner, observer);
            hook(observer);
        }

        private void hook(Observer<? super T> observer) {
            try{
                // 1/得到mLastVersion

                // 2、得到mVersion

                // 3、把mVersion的值填入到mLastVersion中



            }catch (Exception e){

            }
        }
    }



}













