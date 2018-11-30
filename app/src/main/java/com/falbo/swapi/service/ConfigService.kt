package com.falbo.swapi.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ConfigService {

    val retrofit = Retrofit.Builder()
            .baseUrl("https://swapi.co/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
}