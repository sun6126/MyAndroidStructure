package com.example.qi.myandroidstructure

import androidx.annotation.MainThread
import io.reactivex.*
import io.reactivex.annotations.SchedulerSupport.IO
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import io.reactivex.functions.Predicate
import io.reactivex.schedulers.Schedulers
import io.reactivex.schedulers.Schedulers.io
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    /*
    * 观察者
    * */
    @Test
    fun testObservable() {
        val observable = Observable.create(ObservableOnSubscribe<String> {
            System.out.println("observableOnSubscribe")
            it.onNext("test1")
            it.onNext("test2")
            it.onNext("test3")
            it.onComplete()
        })

        val observer = object : Observer<String> {
            override fun onComplete() {
                System.out.println("onComplete")
            }

            override fun onSubscribe(d: Disposable) {
                System.out.println(d.toString())
            }

            override fun onNext(t: String) {
                System.out.println(t)
            }

            override fun onError(e: Throwable) {
                e.printStackTrace()
            }

        }

        observable.subscribe(observer)

        // 支持背压的flowable
        val flowable = Flowable.create(FlowableOnSubscribe<String> {
            it.onNext("flowable")
        }, BackpressureStrategy.BUFFER) // 背压策略为缓存策略

        val consumer = Consumer<String> {
            System.out.println(it)
        }

        flowable.subscribe(consumer)
    }

    /*
    * 操作符
    * */
    @Test
    public fun operationCharacter() {

        Observable.concat( // 组合多个被观察者，然后按照他们的顺序发送事件
            Observable.just(1, 2),
            Observable.just(3, 4),
            Observable.just<String>("测试泛型")
        )
            .subscribe(Consumer {
                System.out.println(it)
            })

        Observable.just(1, 2, 3)
            .filter {
                it < 3 // 注意：lambda最后一行会被当做返回值返回
            }
            .subscribe {
                System.out.println(it)
            }
    }

}
