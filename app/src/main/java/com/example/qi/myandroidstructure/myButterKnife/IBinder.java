package com.example.qi.myandroidstructure.myButterKnife;

public interface IBinder<T> {
    // 用来绑定activity
    void bind(T target);
}
