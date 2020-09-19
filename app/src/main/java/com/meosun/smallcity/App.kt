package com.meosun.smallcity

import android.app.Application
import androidx.core.content.ContextCompat
import com.alibaba.android.arouter.launcher.ARouter
import com.meosun.smallcity.R
import com.next.easytitlebar.view.EasyTitleBar
import com.tencent.mmkv.MMKV
import com.meosun.lib_base.utils.BaseContext
import com.meosun.smallcity.di.allModule
import com.umeng.analytics.MobclickAgent
import com.umeng.commonsdk.UMConfigure
import com.umeng.socialize.PlatformConfig
import com.umeng.socialize.UMShareAPI
import com.umeng.socialize.UMShareConfig

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

        //初始化组件化基础库, 所有友盟业务SDK都必须调用此初始化接口。
        //建议在宿主App的Application.onCreate函数中调用基础组件库初始化函数。
        UMConfigure.init(
            this,
            "5f6603cba4ae0a7f7d08c432",
            "Umeng",
            UMConfigure.DEVICE_TYPE_PHONE,
            ""
        )
        //选择AUTO页面采集模式，统计SDK基础指标无需手动埋点可自动采集。
        //建议在宿主App的Application.onCreate函数中调用此函数。
        MobclickAgent.setPageCollectionMode(MobclickAgent.PageMode.AUTO);

        //三方获取用户资料时是否每次都要进行授权
        val config = UMShareConfig()
        config.isNeedAuthOnGetUserInfo(true)
        UMShareAPI.get(this).setShareConfig(config)

        //TODO 友盟微信配置
        PlatformConfig.setWeixin("wx848706b1d40ae452", "6709ec59f74ddb279d3db0ded599d41e")

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