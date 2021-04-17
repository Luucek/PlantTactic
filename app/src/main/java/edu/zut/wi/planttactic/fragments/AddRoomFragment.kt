package edu.zut.wi.planttactic.fragments

import android.content.res.TypedArray
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import edu.zut.wi.planttactic.R
import edu.zut.wi.planttactic.classes.Room
import kotlinx.android.synthetic.main.fragment_add_room.*
import java.util.*

class AddRoomFragment : Fragment(R.layout.fragment_add_room) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button_add_room.setOnClickListener {

            val roomName = edit_text_room_name.text.toString().trimEnd()

            //TODO: Let user choose room image
//            val imageID = getImageID()

            val imgs: TypedArray = view.context.resources.obtainTypedArray(R.array.images)
            val rand = Random()
            val rndInt = rand.nextInt(imgs.length())
            val resID = imgs.getResourceId(rndInt, 0)

            val room = Room(roomName, resID)
            room.saveToFile(this.context)

            imgs.recycle()

            val action = AddRoomFragmentDirections.actionAddRoomFragmentToHomeFragment()
            findNavController().navigate(action)
        }
    }
}