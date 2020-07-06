package com.example.qi.myandroidstructure.mvp.presenter;

import com.example.qi.myandroidstructure.mvp.view.IGirlView;

import java.lang.ref.WeakReference;

public class BasePresenter<T extends IGirlView> {
    // 持有view对象
    WeakReference<T> iGirlView;

    public void attachView(T view){
        iGirlView = new WeakReference<>(view);
    }

    // 避免内存泄漏
    public void detachView(){
        if (iGirlView != null){
            iGirlView.clear();
            iGirlView = null;
        }
    }


}
