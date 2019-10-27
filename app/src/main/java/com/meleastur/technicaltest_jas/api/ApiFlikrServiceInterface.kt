package com.meleastur.technicaltest_jas.api

import com.meleastur.technicaltest_jas.util.Constants
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

interface ApiFlikrServiceInterface {

    companion object Factory {
        fun create(): ApiFlikrServiceInterface {
            val retrofit = retrofit2.Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(Constants.BASE_URL)
                    .build()

            return retrofit.create(ApiFlikrServiceInterface::class.java)
        }
    }
}