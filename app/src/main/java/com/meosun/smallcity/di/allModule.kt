package com.meosun.smallcity.di

import com.google.gson.GsonBuilder
import com.meosun.sc_login.ui.di.LoginViewModelModule
import com.meosun.sc_login.ui.di.loginRepoModule
import com.meosun.sc_main.ui.di.treeViewModelModule
import com.topp.lib_net.net.RetrofitClient
import org.koin.dsl.module

val otherModule = module {

    single {
        RetrofitClient.instance
    }

    single {
        GsonBuilder().disableHtmlEscaping().create()
    }
}

val allModule = listOf(
    otherModule,
    treeViewModelModule,
    LoginViewModelModule, loginRepoModule,
)