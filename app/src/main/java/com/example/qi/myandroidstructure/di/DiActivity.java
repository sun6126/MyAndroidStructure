package com.example.qi.myandroidstructure.di;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.qi.myandroidstructure.MyApplication;
import com.example.qi.myandroidstructure.R;
import com.example.qi.myandroidstructure.model.Car;
import com.example.qi.myandroidstructure.model.DatabaseObject;
import com.example.qi.myandroidstructure.model.HttpObject;

import javax.inject.Inject;

import dagger.Component;

public class DiActivity extends AppCompatActivity {

    // 注册对象
    @Inject
    HttpObject httpObject1;
    @Inject
    HttpObject httpObject2;

    @Inject
    DatabaseObject databaseObject1;
    @Inject
    DatabaseObject databaseObject2;

    @Inject
    Car car;
    @Inject
    Car car2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_di);
        // 先编译，再进行注册
        // injectMain()就是我自定义的myComponent里的，通过自动生成的实现类 来使用
//        DaggerMyComponent.create().injectMain(this);
        // 同上的 第二种创建方法
//        DaggerMyComponent.builder()
//                .httpModule(new HttpModule())
//                .databaseModule(new DatabaseModule())
//                .build()
//                .injectMain(this);

        // 直接在application中注册，然后拿来使用
        MyApplication myApplication = (MyApplication) getApplication();
        myApplication.getComponent().injectMain(this);

        Log.e("dagger2", httpObject1.hashCode() + "\n"
                + httpObject2.hashCode() + "\n"
                + databaseObject1.hashCode() + "\n"
                + databaseObject2.hashCode() + "\n"
                + car.hashCode() + "\n"
                + car2.hashCode() + "");

    }
}
