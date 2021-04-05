package edu.zut.wi.planttactic

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_home.*
import java.io.File


class HomeFragment : Fragment(R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button_login.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToLoginFragment()
            findNavController().navigate(action)
        }

        cardview_add.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToAddRoomFragment()
            findNavController().navigate(action)
        }

        loadSavedRooms()

    }

    private fun loadSavedRooms() {

        val path: String = context?.filesDir.toString()
        Log.d("Files", "Path: $path")

        val directory = File(path)
        val files = directory.listFiles()

        files?.forEach { file: File ->
            val json = file.readText(Charsets.UTF_8)
            val room: Room = Gson().fromJson(json, Room::class.java)
            Log.d("Room name", room.name)
        }
    }
}