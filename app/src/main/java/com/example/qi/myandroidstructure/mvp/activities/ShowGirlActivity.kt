package com.example.qi.myandroidstructure.mvp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.qi.myandroidstructure.R
import com.example.qi.myandroidstructure.mvp.bean.Girl
import com.example.qi.myandroidstructure.mvp.presenter.GirlPresenter
import com.example.qi.myandroidstructure.mvp.view.IGirlView
import kotlinx.android.synthetic.main.activity_show_girl.*

class ShowGirlActivity : BaseMvpActivity<GirlPresenter<IGirlView>, IGirlView>(), IGirlView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_girl)
        initData()
    }

    // 初始化数据
    private fun initData() {
        presenter.getGirlMessage()
    }

    override fun showGirlMessage(girl: Girl?) {
        ivHeadPic.setImageResource(girl?.headPic!!)
        tvName.text = girl.name
    }

    // 创建自己的presenter
    override fun createPresenter(): GirlPresenter<IGirlView> {
        return GirlPresenter()
    }
}
