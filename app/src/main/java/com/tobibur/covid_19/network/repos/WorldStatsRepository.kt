package com.tobibur.covid_19.network.repos

import com.tobibur.covid_19.model.Stats
import com.tobibur.covid_19.model.WorldStat
import com.tobibur.covid_19.network.ApiService
import com.tobibur.covid_19.network.Outcome

class WorldStatsRepository(private val apiService : ApiService) {
    suspend fun getCases(): Outcome<Stats> {
        val statsDataSource = StatsDataSource(apiService)
        statsDataSource.fetchCases()
        return statsDataSource.downloadedCasesResponse.value as Outcome<Stats>
    }

    suspend fun getTotalStats(): Outcome<WorldStat> {
        val worldStatDataSource = StatsDataSource(apiService)
        worldStatDataSource.fetchWorldStat()
        return worldStatDataSource.downloadedWorldStatResponse.value as Outcome<WorldStat>
    }
}