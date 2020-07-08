package com.example.qi.myandroidstructure.okhttp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import com.example.qi.myandroidstructure.R
import okhttp3.*
import java.io.IOException
import java.lang.Exception
import kotlin.math.log

class OkhttpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_okhttp)

        // 简单使用
       /* val client = OkHttpClient.Builder().addInterceptor(object : Interceptor {
            override fun intercept(chain: Interceptor.Chain): Response {
                val request = chain.request()
                Log.e("okhttp", request.url().toString())
                Log.e("okhttp", request.body().toString())
                return chain.proceed(request)
            }
        }).build()

        val request = Request.Builder()
            .url("https://www.baidu.com")
            .build()
        try {
            client.newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                }

                override fun onResponse(call: Call, response: Response) {
                    Log.e("okhttp", response.message())
                    Log.e("okhttp", response.body().toString())
                    Log.e("okhttp", response.code().toString())
                }
            })
        } catch (e: Exception) {
            e.printStackTrace()
        }*/


    }
}
