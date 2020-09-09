package com.topp.sc_login.ui.di

import com.topp.sc_login.ui.LoginRepository
import com.topp.sc_login.ui.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


/**
 * @ClassName LoginViewModelModule
 * @Description TODO
 * @Author Admin
 * @Date 2020/9/8 13:43
 * @Version 1.0
 */

val loginRepoModule = module {
    single {
        LoginRepository(get())
    }
}

val LoginViewModelModule = module {
    viewModel { LoginViewModel(get()) }
}