package com.example.qi.myandroidstructure.jetpack

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.qi.myandroidstructure.model.User

/*
*
* */
class JetpackViewModel : ViewModel() {

    // 存放数据
    private lateinit var liveData: MutableLiveData<List<User>>

    public fun getLiveData(): LiveData<List<User>> {
        if (liveData == null) {
            liveData = MutableLiveData()
        }
        return liveData
    }

}