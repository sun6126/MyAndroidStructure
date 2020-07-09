package com.example.qi.myandroidstructure.di;

import com.example.qi.myandroidstructure.di.scope.CarScope;
import com.example.qi.myandroidstructure.model.Car;

import dagger.Component;

/*
 *  如果有多个component想要去注入对象给 activity 的话
 *  需要将多个component 依赖在一起
 *  例如：此component只负责提供car对象
 * */
@CarScope // 单例模式
@Component(modules = {CarModule.class})
public interface CarComponent {
    Car provideCar();
}
