package com.example.qi.myandroidstructure.di;

import com.example.qi.myandroidstructure.model.DatabaseObject;

import dagger.Module;
import dagger.Provides;

/*
* 用来提供对象
* */
@Module
public class DatabaseModule {
    // 返回值就是提供的对象
    @Provides // 使方法具备提供对象的功能
    public DatabaseObject provideDatabaseObjects(){
        return new DatabaseObject();
    }
}
