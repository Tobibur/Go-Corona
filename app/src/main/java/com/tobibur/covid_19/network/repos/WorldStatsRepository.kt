package com.tobibur.covid_19.network.repos

import com.tobibur.covid_19.model.Stats
import com.tobibur.covid_19.network.ApiService
import com.tobibur.covid_19.network.Outcome

class WorldStatsRepository(private val apiService : ApiService) {
    suspend fun getCases(): Outcome<Stats> {
        val moviesDataSource = StatsDataSource(apiService)
        moviesDataSource.fetchCases()
        return moviesDataSource.downloadedCasesResponse.value as Outcome<Stats>
    }
}