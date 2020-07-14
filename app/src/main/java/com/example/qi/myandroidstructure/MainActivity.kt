package com.example.qi.myandroidstructure

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.example.qi.myandroidstructure.selfEventBus.MySubscribe
import com.example.qi.myandroidstructure.selfEventBus.MyEventBus
import com.example.qi.myandroidstructure.model.Friend
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Glide.with(this).load(R.drawable.basketball).into(ivBasket)
    }

}
