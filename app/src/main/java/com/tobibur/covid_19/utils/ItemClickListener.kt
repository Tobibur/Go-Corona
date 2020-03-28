package com.tobibur.covid_19.utils

import com.tobibur.covid_19.model.CountriesStat

interface ItemClickListener {

    fun onItemClick(statsObject: CountriesStat)

}