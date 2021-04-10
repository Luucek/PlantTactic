package edu.zut.wi.planttactic.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
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

        val rooms = Room.loadSavedRooms(this.context)
        val devices = rooms.first { it.name == args.roomName }.devices

        initRecyclerView(devices)

        button_add_device.setOnClickListener {
            val action = RoomFragmentDirections.actionRoomFragmentToAddPotDeviceFragment(args.roomName)
            findNavController().navigate(action)
        }
    }

    private fun initRecyclerView(devices: ArrayList<PotDevice>) {

        val recyclerView: RecyclerView? = view?.findViewById(R.id.devicesView)
        val adapter = PotDevicesViewAdapter(this.context, devices)

        recyclerView?.adapter = adapter
        recyclerView?.layoutManager = LinearLayoutManager(this.context)
    }
}