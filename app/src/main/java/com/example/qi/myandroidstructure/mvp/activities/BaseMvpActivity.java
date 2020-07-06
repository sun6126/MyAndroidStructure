package com.example.qi.myandroidstructure.mvp.activities;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.qi.myandroidstructure.mvp.presenter.BasePresenter;
import com.example.qi.myandroidstructure.mvp.view.IGirlView;

public abstract class BaseMvpActivity<T extends BasePresenter,V extends IGirlView> extends AppCompatActivity {
    // 持有P层，把P的初始化抽离到这层
    T presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 初始化presenter，实现类activity自己去创建自己对应的P
        presenter = createPresenter();
        presenter.attachView((V)this);
    }

    public abstract T createPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }
}
