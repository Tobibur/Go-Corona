package com.tobibur.covid_19.model

import androidx.annotation.Keep
import java.io.Serializable

@Keep
data class Help(
    val place: String,
    val helpline: String
): Serializable