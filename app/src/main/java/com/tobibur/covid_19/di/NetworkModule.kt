package com.tobibur.covid_19.di

import com.tobibur.covid_19.network.ApiConstants
import com.tobibur.covid_19.network.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val networkModule = module {
    single {
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }
    single {
        OkHttpClient.Builder().apply {
            addInterceptor(get<HttpLoggingInterceptor>())
            addInterceptor { chain ->
                val requestBuilder = chain.request().newBuilder()
                requestBuilder.addHeader("x-rapidapi-key", ApiConstants.API_KEY)
                    .addHeader("x-rapidapi-host", ApiConstants.HOST)
                chain.proceed(requestBuilder.build())
            }
        }.build()
    }
    single {
        Retrofit.Builder()
            .baseUrl(ApiConstants.BASE_URL)
            .client(get<OkHttpClient>())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    single { get<Retrofit>().create(ApiService::class.java) }
}