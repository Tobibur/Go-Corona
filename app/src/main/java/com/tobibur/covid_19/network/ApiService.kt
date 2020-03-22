package com.tobibur.covid_19.network

import com.tobibur.covid_19.model.Stats
import retrofit2.http.GET

interface ApiService {

    @GET("cases_by_country.php")
    suspend fun getCasesByCountry(): Stats
}