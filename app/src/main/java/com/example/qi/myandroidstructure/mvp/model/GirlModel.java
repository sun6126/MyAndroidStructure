package com.example.qi.myandroidstructure.mvp.model;

import com.example.qi.myandroidstructure.R;
import com.example.qi.myandroidstructure.mvp.bean.Girl;

public class GirlModel implements IGirlModel {

    /*
    * 模拟数据，创建一个girl并返回
    * */
    @Override
    public void loadGirl(OnLoadListener listener) {
        Girl girl = new Girl();
        girl.setHeadPic(R.drawable.ic_launcher_background);
        girl.setName("Lily");
        listener.onComplete(girl);
    }
}
