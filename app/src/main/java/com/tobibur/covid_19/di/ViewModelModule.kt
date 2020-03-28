package com.tobibur.covid_19.di

import com.tobibur.covid_19.view.HomeViewModel
import com.tobibur.covid_19.view.SearchViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { HomeViewModel(get()) }
    viewModel { SearchViewModel(get()) }
}