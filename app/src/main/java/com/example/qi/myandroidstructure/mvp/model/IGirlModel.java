package com.example.qi.myandroidstructure.mvp.model;

import com.example.qi.myandroidstructure.mvp.bean.Girl;

public interface IGirlModel {
    void loadGirl(OnLoadListener listener);

    interface OnLoadListener{
        void onComplete(Girl girl);
    }

}
