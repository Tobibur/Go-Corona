package com.tobibur.covid_19.model

import androidx.annotation.Keep
import java.io.Serializable

@Keep
data class Tips (
    val tipsImage: Int,
    val tipTitle: String,
    val tipContent: String
): Serializable