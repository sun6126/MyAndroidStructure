package com.example.qi.myandroidstructure

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.qi.myandroidstructure.selfEventBus.MySubscribe
import com.example.qi.myandroidstructure.selfEventBus.MyEventBus
import com.example.qi.myandroidstructure.model.Friend
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MyEventBus.register(this)
        initListener()
    }

    private fun initListener() {
        btnPostEvent.setOnClickListener {
            MyEventBus.post(Friend(20,"xiaoshuai"))
        }
    }

    @MySubscribe
    public fun testEventBus(friend: Friend) {
        Log.e("myEventBus", friend.toString())
    }


    override fun onDestroy() {
        super.onDestroy()
        MyEventBus.unRegister(this)
    }
}
