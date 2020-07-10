package com.example.qi.myandroidstructure.jetpack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Debug
import android.os.Environment
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.qi.myandroidstructure.R
import com.example.qi.myandroidstructure.jetpack.model.HuaWei
import kotlinx.android.synthetic.main.activity_jetpack.*
import java.io.File

class JetpackActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 增加监听方法耗时的文件
        val file = File(Environment.getExternalStorageState(), "app.trace")
        Debug.startMethodTracing(file.absolutePath)

        setContentView(R.layout.activity_jetpack)
        lifecycle.addObserver(MyLifeObserver()) // 添加生命周期监听者

        registerLiveDataBus()
        initListener()

        // 结束方法监听
        Debug.stopMethodTracing()
    }

    private fun initListener() {

        btnSendMessage.setOnClickListener {
            LiveDataBus.getInstance().with("HuaWei", HuaWei::class.java).postValue(HuaWei())
        }
    }

    private fun registerLiveDataBus() {
        LiveDataBus.getInstance().with("HuaWei", HuaWei::class.java)
            .observe(this, object : Observer<HuaWei> {
                override fun onChanged(t: HuaWei?) {
                    Toast.makeText(
                        this@JetpackActivity,
                        t.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }

            })
    }
}
