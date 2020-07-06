package com.example.qi.myandroidstructure.mvp.presenter;

import com.example.qi.myandroidstructure.mvp.bean.Girl;
import com.example.qi.myandroidstructure.mvp.model.GirlModel;
import com.example.qi.myandroidstructure.mvp.model.IGirlModel;
import com.example.qi.myandroidstructure.mvp.view.IGirlView;

import java.lang.ref.WeakReference;

public class GirlPresenter<T extends IGirlView> extends BasePresenter<T> {

    // 持有model对象
    GirlModel girlModel = new GirlModel();

    // 获取girl信息
    public void getGirlMessage() {
        girlModel.loadGirl(new IGirlModel.OnLoadListener() {
            @Override
            public void onComplete(Girl girl) {
                if (girl != null) {
                    iGirlView.get().showGirlMessage(girl);
                }
            }
        });
    }

}
