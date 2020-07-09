package com.example.qi.myandroidstructure.di;

import com.example.qi.myandroidstructure.di.scope.CarScope;
import com.example.qi.myandroidstructure.model.Car;

import dagger.Module;
import dagger.Provides;

@CarScope
@Module
public class CarModule {
    @CarScope
    @Provides
    public Car provideCar(){
        return new Car();
    }
}
