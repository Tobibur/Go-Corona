package com.tobibur.covid_19.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.tobibur.covid_19.model.Stats
import com.tobibur.covid_19.model.WorldStat
import com.tobibur.covid_19.network.Outcome
import com.tobibur.covid_19.network.repos.WorldStatsRepository

class HomeViewModel(private val statsRepository: WorldStatsRepository) : ViewModel() {

    private var cases: LiveData<Outcome<Stats>>? = null
    private var worldStats: LiveData<Outcome<WorldStat>>? = null

    fun getCases(): LiveData<Outcome<Stats>> {
        if (cases == null) {
            cases = liveData {
                emit(statsRepository.getCases())
            }
        }
        return cases as LiveData<Outcome<Stats>>
    }

    fun getWorldStat(): LiveData<Outcome<WorldStat>> {
        if(worldStats==null) {
            worldStats = liveData {
                emit(statsRepository.getTotalStats())
            }
        }
        return worldStats as LiveData<Outcome<WorldStat>>
    }
}
