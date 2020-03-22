package com.tobibur.covid_19.di

import com.tobibur.covid_19.network.repos.WorldStatsRepository
import org.koin.dsl.module

val dataModule = module {

    single { WorldStatsRepository(get()) }
}