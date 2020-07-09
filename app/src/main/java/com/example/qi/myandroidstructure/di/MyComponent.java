package com.example.qi.myandroidstructure.di;

import com.example.qi.myandroidstructure.di.scope.MyScope;

import dagger.Component;

/*
* 这是一个组件
*
* 一般不推荐使用 @Singleton 建议使用自定义的 @Scope
* 1、多个component不能使用同一个scope
* 2、没有Scope 不能依赖 有 Scope的组件
* */
//@Singleton
@MyScope  // 替换@Singleton
@Component(modules = {DatabaseModule.class,HttpModule.class},dependencies = {CarComponent.class}) // 依赖carComponent
public interface MyComponent {
    /*
    * 注入到 mainactivity
    * 这里必须指定要注入的对象，不能使用多肽
    * 方法名随便取
    * */
    void injectMain(DiActivity diActivity);

}
