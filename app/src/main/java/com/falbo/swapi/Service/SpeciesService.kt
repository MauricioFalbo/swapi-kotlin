package com.falbo.swapi.Service

import com.falbo.swapi.models.Specie
import com.falbo.swapi.models.Species
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface SpeciesService {

    @GET("species/")
    fun species(@Query("page") page: String): Call<Species>

    @GET("species/{id}")
    fun specie(@Path("id") id: String): Call<Specie>
}