package edu.zut.wi.planttactic

import android.content.Context
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_add_room.*
import java.io.FileInputStream
import java.io.FileOutputStream

class AddRoomFragment : Fragment(R.layout.fragment_add_room) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button_add_room.setOnClickListener {
            val roomName = edit_text_room_name.text.toString()
            val imageName = edit_text_room_photo.text.toString()

            val room = Room(roomName, imageName)
            room.saveToFile(this.context)

            val action = AddRoomFragmentDirections.actionAddRoomFragmentToHomeFragment()
            findNavController().navigate(action)
        }
    }

//    private fun saveRoomToFile(room: Room) {
//
//        context?.openFileOutput(room.name, Context.MODE_PRIVATE).use { output ->
//            output?.write(room.getJSONstring().toByteArray())
//        }
//    }
}