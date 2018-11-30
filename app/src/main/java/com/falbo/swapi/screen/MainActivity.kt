package com.falbo.swapi.screen

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.falbo.swapi.R
import com.falbo.swapi.service.PeopleService
import com.falbo.swapi.service.SpeciesService
import com.falbo.swapi.models.Peoples
import com.falbo.swapi.models.Specie
import com.falbo.swapi.service.ConfigService
import com.falbo.swapi.service.PeopleCall
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)



        val pessoas = PeopleCall().getPeople("1")
                    Log.e("FALBOUSER", pessoas.toString())

//        peoplesService.people("2").enqueue(object : Callback<People>{
//            override fun onResponse(call: Call<People>, response: Response<People>) {
//                if(!response.isSuccessful){
//                    Log.e("FALBO","Erro: " + response.code())
//                }else{
//                    val people = response.body()
//                    //Log.e("FALBOUSER", people?.species)
//                }
//            }
//
//            override fun onFailure(call: Call<People>, t: Throwable) {
//                Log.e("FALBO","Erro: " + t.message)
//            }
//
//        })

    }

    fun getSpecie( idSpecie: String){

        val speciesService = ConfigService().retrofit.create(SpeciesService::class.java)
        speciesService.specie(idSpecie).enqueue(object : Callback<Specie>{
            override fun onResponse(call: Call<Specie>, response: Response<Specie>) {
                if(!response.isSuccessful){
                    Log.e("FALBO","Erro: " + response.code())
                }else{
                    val specie = response.body()
                    Log.e("FALBOUSER", specie?.name)
                }
            }

            override fun onFailure(call: Call<Specie>, t: Throwable) {
                Log.e("FALBO","Erro: " + t.message)
            }

        })


    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_camera -> {
                // Handle the camera action
            }
            R.id.nav_gallery -> {

            }
            R.id.nav_slideshow -> {

            }
            R.id.nav_manage -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
