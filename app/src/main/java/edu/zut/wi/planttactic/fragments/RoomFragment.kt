package edu.zut.wi.planttactic.fragments

import android.os.Bundle
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.zut.wi.planttactic.PotDevicesViewAdapter
import edu.zut.wi.planttactic.R
import edu.zut.wi.planttactic.classes.PotDevice
import edu.zut.wi.planttactic.classes.Room
import kotlinx.android.synthetic.main.fragment_room.*


class RoomFragment : Fragment(R.layout.fragment_room) {

    private val args: RoomFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val room = Room.getRoomFromName(this.context, args.roomName)
        val devices = room.devices

        initRecyclerView(devices)

        button_room_more.setOnClickListener {
            val popup = PopupMenu(this.context, button_room_more)
            val inflater: MenuInflater = popup.menuInflater
            inflater.inflate(R.menu.more_button_menu, popup.menu)

            popup.setOnMenuItemClickListener { item: MenuItem ->
                if (item.itemId == R.id.add_device_item) {
                    val action = RoomFragmentDirections.actionRoomFragmentToAddPotDeviceFragment(room.name)
                    view.findNavController().navigate(action)
                } else if (item.itemId == R.id.edit_room_item) {
                    val action = RoomFragmentDirections.actionRoomFragmentToEditRoomFragment(room.name)
                    view.findNavController().navigate(action)
                }
                true
            }

            popup.show()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == R.menu.more_button_menu)
            view?.findNavController()?.navigate(R.id.action_roomFragment_to_addPotDeviceFragment)

        return super.onOptionsItemSelected(item)
    }

    private fun initRecyclerView(devices: ArrayList<PotDevice>) {

        val recyclerView: RecyclerView? = view?.findViewById(R.id.devicesView)
        val adapter = PotDevicesViewAdapter(this.context, devices)

        recyclerView?.adapter = adapter
        recyclerView?.layoutManager = LinearLayoutManager(this.context)
    }
}