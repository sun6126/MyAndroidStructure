package com.example.qi.myandroidstructure.network;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConfig {
    private static ApiService SERVICE;
    private static String BASE_URL = "https://192.168.1.8080:";

    // 请求超时时间
    private static final int DEFAULT_TIME_OUT = 10000;

    // 初始化retrofit
    public static ApiService getDefault() {
        if (SERVICE == null) {
            OkHttpClient okhttpClient = new OkHttpClient.Builder()
                    .connectTimeout(DEFAULT_TIME_OUT, TimeUnit.MILLISECONDS)
                    .addInterceptor(new Interceptor() {
                        // 对所有响应 添加统一请求头
                        @Override
                        public Response intercept(Chain chain) throws IOException {
                            Request request = chain.request();
                            Response response = chain.proceed(request);
                            return response.newBuilder()
                                    .addHeader("key1", "value1")
                                    .addHeader("key2", "value2")
                                    .build();
                        }
                    })
                    .build();
            SERVICE = new Retrofit.Builder()
                    .client(okhttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .baseUrl(BASE_URL)
                    .build()
                    .create(ApiService.class);
        }
        return SERVICE;
    }


}
