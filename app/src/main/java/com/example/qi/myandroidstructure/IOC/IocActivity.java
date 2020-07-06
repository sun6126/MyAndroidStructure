package com.example.qi.myandroidstructure.IOC;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.example.qi.myandroidstructure.R;

@ContentView(R.layout.activity_ioc) // 绑定一个布局 ， 继承 BaseActivity，就可以自动注入布局
public class IocActivity extends BaseActivity {

    @ViewInject(R.id.btnTest1)
    Button btnTest1;

    @ViewInject(R.id.btnTest2)
    Button btnTest2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 改用注解注入
//        setContentView(R.layout.activity_ioc);

        Log.e("ioc",btnTest1.toString());
        Log.e("ioc",btnTest2.toString());
    }
}
