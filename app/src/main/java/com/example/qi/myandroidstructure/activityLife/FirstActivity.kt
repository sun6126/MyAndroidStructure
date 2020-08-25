package com.example.qi.myandroidstructure.activityLife

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.qi.myandroidstructure.R
import kotlinx.android.synthetic.main.activity_first.*

class FirstActivity : AppCompatActivity() {
    val tag = "FirstActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        btnStartSecond.setOnClickListener {
            startActivity(Intent(this@FirstActivity,SecondActivity::class.java))
        }
    }

    override fun onStart() {
        super.onStart()
        Log.e(tag,"onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e(tag,"onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.e(tag,"onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e(tag,"onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(tag,"onDestroy")
    }
}
