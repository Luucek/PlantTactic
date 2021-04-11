package edu.zut.wi.planttactic.classes

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import java.io.File
import java.io.FileOutputStream

class Room() {

    var name: String = ""
    var imageName: String = ""
    var devices: ArrayList<PotDevice> = ArrayList()

    constructor(name: String, imageName: String) : this() {
        this.name = name
        this.imageName = imageName
    }

    fun getJSONstring(): String {
        val gson = Gson()
        return gson.toJson(this)
    }

    fun saveToFile(context: Context?) {

        val dir = File(context?.filesDir, "rooms")
        dir.mkdirs()

        val fileOutputStream = FileOutputStream(File(dir, name))
        fileOutputStream.write(this.getJSONstring().toByteArray())
    }

    companion object {
        fun loadSavedRooms(context: Context?): ArrayList<Room> {

            val path: String = context?.filesDir.toString() + "/rooms"
            Log.d("Files", "Path: $path")

            val directory = File(path)
            val files = directory.listFiles()

            val userRooms = ArrayList<Room>()

            if (files?.isNotEmpty() == true) {

                files.forEach {
                    val json = it?.readText(Charsets.UTF_8)
                    val room: Room = Gson().fromJson(json, Room::class.java)
                    userRooms.add(room)
                }
            }
            return userRooms
        }

        fun getRoomFromName(context: Context?, roomName: String): Room {

            val path: String = context?.filesDir.toString() + "/rooms"

            val directory = File(path)
            val files = directory.listFiles()

            val file = files?.first { it.name == roomName }
            val json = file?.readText(Charsets.UTF_8)

            return Gson().fromJson(json, Room::class.java)
        }
    }

    fun addDevice(device: PotDevice) {
        this.devices.add(device)
    }
}