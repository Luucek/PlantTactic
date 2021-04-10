package edu.zut.wi.planttactic.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import edu.zut.wi.planttactic.R
import edu.zut.wi.planttactic.classes.Room
import kotlinx.android.synthetic.main.fragment_add_room.*

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
}