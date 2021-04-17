package edu.zut.wi.planttactic.fragments

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import edu.zut.wi.planttactic.R
import edu.zut.wi.planttactic.classes.Room
import kotlinx.android.synthetic.main.fragment_edit_room.*

class EditRoomFragment : Fragment(R.layout.fragment_edit_room) {

    private val args: RoomFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val room = Room.getRoomFromName(this.context, args.roomName)

        edit_room_image.setImageResource(room.imageID)

        edit_room_newimage.visibility = View.INVISIBLE

        edit_room_save.setOnClickListener {

            room.delete(this.context)
            room.name = edit_room_newname.text.toString().trimEnd()
            room.saveToFile(this.context)

            view.findNavController().navigate(R.id.action_editRoomFragment_to_homeFragment)
        }

        edit_room_delete.setOnClickListener {

            val builder = this.context?.let { it1 -> AlertDialog.Builder(it1) }

            builder?.setTitle(getString(R.string.dialog_title))
            builder?.setMessage(getString(R.string.dialog_message) + " " + room.name)

            builder?.setPositiveButton(android.R.string.ok) { _, _ ->
                room.delete(this.context)
                view.findNavController().navigate(R.id.action_editRoomFragment_to_homeFragment)
            }

            builder?.setNegativeButton(android.R.string.cancel) { _, _ ->

            }

            builder?.show()
        }
    }
}