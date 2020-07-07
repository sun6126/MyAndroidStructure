package com.example.qi.myandroidstructure.network;

import com.example.qi.myandroidstructure.model.User;
import com.example.qi.myandroidstructure.network.base.HttpResult;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/*
*  所有的接口定义在此
* */
public interface ApiService {
    @GET("/login")
    Observable<HttpResult<User>> login(@Query("name") String name);
}
