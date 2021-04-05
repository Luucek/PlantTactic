package edu.zut.wi.planttactic

import com.google.gson.Gson

class Room() {

    var name: String = ""
    var imageName: String = ""

    fun getJSONstring(): String {
        val gson = Gson()
        return gson.toJson(this)
    }
}