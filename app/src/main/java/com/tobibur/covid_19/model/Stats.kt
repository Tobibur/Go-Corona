package com.tobibur.covid_19.model


import com.google.gson.annotations.SerializedName

data class Stats(
    @SerializedName("countries_stat")
    val countriesStat: List<CountriesStat>,
    @SerializedName("statistic_taken_at")
    val statisticTakenAt: String
)