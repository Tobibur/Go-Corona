package com.tobibur.covid_19.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.tobibur.covid_19.network.repos.WorldStatsRepository

class HomeViewModel(private val statsRepository: WorldStatsRepository) : ViewModel() {

    fun getCases() = liveData {
        emit(statsRepository.getCases())
    }
}
