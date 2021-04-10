package edu.zut.wi.planttactic.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import edu.zut.wi.planttactic.R
import edu.zut.wi.planttactic.classes.PotDevice
import edu.zut.wi.planttactic.classes.Room
import kotlinx.android.synthetic.main.fragment_add_potdevice.*

class AddPotDeviceFragment : Fragment(R.layout.fragment_add_potdevice) {

    private val args: AddPotDeviceFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button_add_pot_device.setOnClickListener {
            val deviceName = edit_text_device_name.text.toString()
            val imageName = edit_text_device_photo.text.toString()

            val device = PotDevice(deviceName, imageName)
            val room = Room.getRoomFromName(this.context, args.roomName)
            room.addDevice(device)
            room.saveToFile(this.context)

            val action = AddPotDeviceFragmentDirections.actionAddPotDeviceFragmentToRoomFragment(room.name)
            findNavController().navigate(action)
        }
    }
}