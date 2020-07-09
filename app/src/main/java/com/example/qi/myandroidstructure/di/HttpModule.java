package com.example.qi.myandroidstructure.di;

import com.example.qi.myandroidstructure.di.scope.MyScope;
import com.example.qi.myandroidstructure.model.HttpObject;

import dagger.Module;
import dagger.Provides;

/*
* 用来提供对象
* */
//@Singleton
@Module
public class HttpModule {
    // 返回值就是提供的对象
//    @Singleton // 可以将生成对象指定为单例，这样这个类也需要指定成单例，而且 component 类也要制定成单例,但是不推荐使用
    @MyScope
    @Provides // 使方法具备提供对象的功能
    public HttpObject provideHttpObjects(){
        return new HttpObject();
    }
}
