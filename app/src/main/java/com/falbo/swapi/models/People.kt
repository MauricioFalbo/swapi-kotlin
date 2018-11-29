package com.falbo.swapi.models

class People {

    var name: String = ""
    var height: String = ""
    var mass: String = ""
    var eye_color: String = ""
    var skin_color: String = ""
    var hair_color: String = ""
    var birth_year: String = ""
    var gender: String = ""

    var homeworld: String = ""


    lateinit var species: List<String>

    var specie: String = ""
        get() {
            val idPeople = field.split("/")
            return idPeople[idPeople.count() - 2]
        }

    var url:String = ""
    get() {
        val idPeople = field.split("/")
        return idPeople[idPeople.count() - 2]
    }

}