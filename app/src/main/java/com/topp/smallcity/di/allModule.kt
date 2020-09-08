package com.topp.smallcity.di

import com.topp.sc_login.ui.di.LoginViewModelModule
import com.topp.sc_main.ui.di.treeViewModelModule



val allModule = listOf(
    treeViewModelModule, LoginViewModelModule
)