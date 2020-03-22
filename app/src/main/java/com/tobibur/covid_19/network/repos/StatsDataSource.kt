package com.tobibur.covid_19.network.repos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tobibur.covid_19.model.Stats
import com.tobibur.covid_19.network.ApiService
import com.tobibur.covid_19.network.Outcome
import java.lang.Exception

class StatsDataSource(private val apiService : ApiService) {
    private val _downloadedCasesDetailsResponse =  MutableLiveData<Outcome<Stats>>()
    val downloadedCasesResponse: LiveData<Outcome<Stats>>
        get() = _downloadedCasesDetailsResponse

    suspend fun fetchCases() {
        try {
            val casesResponse = apiService.getCasesByCountry()
            _downloadedCasesDetailsResponse.value = Outcome.success(casesResponse)
        }catch (e: Exception){
            _downloadedCasesDetailsResponse.value = Outcome.failure(e)
        }
    }
}