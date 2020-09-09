package com.topp.smallcity.di

import com.google.gson.GsonBuilder
import com.topp.lib_net.net.RetrofitClient
import com.topp.sc_login.ui.di.LoginViewModelModule
import com.topp.sc_login.ui.di.loginRepoModule
import com.topp.sc_main.ui.di.treeViewModelModule
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