package com.topp.sc_main.ui.di

import com.topp.sc_main.ui.MainViewModel
import com.topp.sc_main.ui.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


/**
 * Create by liwen on 2020/5/25
 */

val treeRepoModule = module {
//    single { TreeRepository(get()) }
//    single { HomeRepository(get()) }
//    single { ProjectRepository(get()) }
//    single { NavigationRepository(get()) }
}


val treeViewModelModule = module {
    viewModel { SplashViewModel() }
    viewModel { MainViewModel() }
//    viewModel { HomeViewModel(get()) }
//    viewModel { ProjectViewModel(get()) }
//    viewModel { TabItemViewModel(get()) }
//    viewModel { MineViewModel() }
//    viewModel { NavigationViewModel(get()) }
//    viewModel { NavigationDataPageViewModel() }
//    viewModel { HomeListViewModel(get()) }
}

