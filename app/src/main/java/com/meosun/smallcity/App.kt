package com.meosun.smallcity

import android.app.Application
import androidx.core.content.ContextCompat
import com.alibaba.android.arouter.launcher.ARouter
import com.meosun.smallcity.R
import com.next.easytitlebar.view.EasyTitleBar
import com.tencent.mmkv.MMKV
import com.meosun.lib_base.utils.BaseContext
import com.meosun.smallcity.di.allModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import java.time.format.TextStyle


/**
 * @ClassName App
 * @Description TODO
 * @Author Admin
 * @Date 2020/9/2 10:45
 * @Version 1.0
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()

        BaseContext.instance.init(this)
        //初始化阿里路由
        ARouter.init(this)
        MMKV.initialize(this)

        startKoin {
            androidContext(this@App)
            modules(allModule)
        }

        initEasyTitleBar()
    }

    private fun initEasyTitleBar() {
        EasyTitleBar.init()
            .backgroud(ContextCompat.getColor(this, R.color.white))
            .titleSize(18)
            .titleColor(ContextCompat.getColor(this, R.color.common_text))
            .titleBarHeight(52)
    }
}