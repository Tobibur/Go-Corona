package com.tobibur.covid_19.model

import java.io.Serializable

data class Tips (
    val tipsImage: Int,
    val tipTitle: String,
    val tipContent: String
): Serializable