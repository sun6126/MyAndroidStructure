package com.example.qi.myandroidstructure.selfRxjava

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.qi.myandroidstructure.R
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import io.reactivex.ObservableOnSubscribe
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_rx_java.*
import kotlin.math.log

class RxJavaActivity : AppCompatActivity() {

    lateinit var disposeList: MutableList<Disposable>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rx_java)
        initData()
        initListener()
    }

    private fun initListener() {
        rxJavaPost.setOnClickListener {
            testRxJava()
        }
    }

    private fun initData() {
        disposeList = ArrayList()
    }

    fun testRxJava() {
        val subscribe = Observable.create(object : ObservableOnSubscribe<Int> {
            override fun subscribe(emitter: ObservableEmitter<Int>) { // 在subscribeOn()指定的线程执行
                Log.e("subscribe", Thread.currentThread().name)
                emitter.onNext(1)
                emitter.onNext(2)
                emitter.onNext(3)
            }
        })
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<Int> {
                override fun onComplete() {
                    Log.e("onComplete", Thread.currentThread().name)
                }

                /*
                * d调用dispose()方法后，上游不会再发送事件，下游也不再接收
                * */
                override fun onSubscribe(d: Disposable) { // 在哪个线程进行订阅的就是在哪个线程执行，发生在订阅之前,即在 subscribe之前
                    Log.e("onSubscribe", Thread.currentThread().name)
//                    d.dispose()
                }

                override fun onNext(t: Int) {
                    Log.e("onNext", t.toString())
                    Log.e("onNext", Thread.currentThread().name)
                }

                override fun onError(e: Throwable) {
                    Log.e("onError", Thread.currentThread().name)
                }
            }
            )
//        disposeList.add(subscribe)
    }

    override fun onDestroy() {
        super.onDestroy()
        if (disposeList.size > 0) {
            disposeList.forEach {
                it.dispose()
            }
        }
    }
}
