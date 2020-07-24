package com.example.qi.myandroidstructure

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.example.qi.myandroidstructure.jetpack.JetpackActivity
import com.example.qi.myandroidstructure.selfEventBus.MySubscribe
import com.example.qi.myandroidstructure.selfEventBus.MyEventBus
import com.example.qi.myandroidstructure.model.Friend
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initListener()
    }

    private fun initListener() {
        btnJetpackActivity.setOnClickListener {
            startActivity(Intent(this@MainActivity, JetpackActivity::class.java))
        }

    }

}
