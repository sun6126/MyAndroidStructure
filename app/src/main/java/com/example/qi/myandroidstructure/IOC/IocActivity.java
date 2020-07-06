package com.example.qi.myandroidstructure.IOC;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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

        Log.e("ioc", btnTest1.toString());
        Log.e("ioc", btnTest2.toString());
    }


    @OnClick({R.id.btnTest1, R.id.btnTest2})
    public void click(View view) {
        Toast.makeText(IocActivity.this, "按钮被点击了", Toast.LENGTH_SHORT).show();
    }

    @OnLongClick({R.id.btnTest1, R.id.btnTest2})
    public boolean onLongClick(View view) {
        Toast.makeText(IocActivity.this, "长按了", Toast.LENGTH_SHORT).show();
        return true;
    }

}
