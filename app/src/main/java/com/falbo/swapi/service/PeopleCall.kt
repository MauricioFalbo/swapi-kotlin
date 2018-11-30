package com.falbo.swapi.service

import android.util.Log
import com.falbo.swapi.models.Peoples
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PeopleCall {

    fun getPeople(page: String){

        val peoplesService = ConfigService().retrofit.create(PeopleService::class.java)
        return peoplesService.peoples(page).enqueue(object : Callback<Peoples> {

            override fun onResponse(call: Call<Peoples>, response: Response<Peoples>) {
                if(!response.isSuccessful){
                    Log.e("FALBOUSER","Erro: " + response.code())
                }else{
                    val peoples = response.body()

                    peoples?.results?.forEach{
                        it.specie = it.species[0]

                    }
                }
            }

            override fun onFailure(call: Call<Peoples>, t: Throwable) {
                Log.e("FALBO","Erro: " + t.message)
            }
        })



    }




    fun getPerson(){

    }

}