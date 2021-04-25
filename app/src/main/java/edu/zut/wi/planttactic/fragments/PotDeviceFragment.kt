package edu.zut.wi.planttactic.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.google.firebase.firestore.FirebaseFirestore
import edu.zut.wi.planttactic.R
import kotlinx.android.synthetic.main.fragment_potdevice.*


class PotDeviceFragment : Fragment(R.layout.fragment_potdevice) {

    private val args: PotDeviceFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pot_device_name.text = args.deviceName

        val db = FirebaseFirestore.getInstance()

        val device = hashMapOf(
            "name" to args.deviceName,
            "state" to "CA",
            "country" to "USA"
        )

        db.collection("devices").add(device).addOnSuccessListener {
            Log.d("PotDeviceFragment", "Dodano - " + args.deviceName)
        }.addOnFailureListener { Log.d("PotDeviceFragment", "Nie dodano doniczki") }
    }
}