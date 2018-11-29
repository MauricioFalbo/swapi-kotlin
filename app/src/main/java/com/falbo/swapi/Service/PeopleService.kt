package com.falbo.swapi.Service

import com.falbo.swapi.models.People
import com.falbo.swapi.models.Peoples
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PeopleService {

    @GET("people/")
    fun peoples(@Query("page") page: String): Call<Peoples>


    @GET("people/{id}")
    fun people(@Path("id") id: String): Call<People>
}