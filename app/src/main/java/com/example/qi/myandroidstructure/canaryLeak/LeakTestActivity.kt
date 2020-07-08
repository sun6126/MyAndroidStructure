package com.example.qi.myandroidstructure.canaryLeak

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import com.example.qi.myandroidstructure.R

class LeakTestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_leak_test)
        val handler = Handler(object : Handler.Callback {
            override fun handleMessage(msg: Message): Boolean {
                Log.e("test", "test")
                return true
            }
        })

        handler.sendEmptyMessageDelayed(0, 15000)
    }
}
