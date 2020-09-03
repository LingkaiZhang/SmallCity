package com.topp.smallcity

import android.app.Application
import com.topp.lib_base.utils.BaseContext
import com.topp.smallcity.di.allModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


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

        startKoin {
            androidContext(this@App)
            modules(allModule)
        }
    }
}