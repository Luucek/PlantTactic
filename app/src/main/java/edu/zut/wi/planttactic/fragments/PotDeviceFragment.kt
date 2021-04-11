package edu.zut.wi.planttactic.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import edu.zut.wi.planttactic.R
import kotlinx.android.synthetic.main.fragment_potdevice.*

class PotDeviceFragment : Fragment(R.layout.fragment_potdevice) {

    private val args: PotDeviceFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pot_device_name.text = args.deviceName
    }
}