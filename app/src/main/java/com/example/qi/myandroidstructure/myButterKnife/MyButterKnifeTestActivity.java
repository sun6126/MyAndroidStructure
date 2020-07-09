package com.example.qi.myandroidstructure.myButterKnife;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.qi.annotation.BinderView;
import com.example.qi.myandroidstructure.R;

public class MyButterKnifeTestActivity extends AppCompatActivity {

    @BinderView(R.id.tv_test)
    TextView tvTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_butter_knife);
        MyButterKnife.bind(this);
    }
}
