package edu.zut.wi.planttactic

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import edu.zut.wi.planttactic.classes.PotDevice
import edu.zut.wi.planttactic.fragments.PotDeviceFragmentDirections
import java.util.*


class PotDevicesViewAdapter(context: Context?, devices: ArrayList<PotDevice>) :
    RecyclerView.Adapter<PotDevicesViewAdapter.ViewHolder>() {

    private var devices = ArrayList<PotDevice>()
    private val context: Context?

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_device_listitem, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.deviceName.text = devices[position].name

        holder.parentLayout.setOnClickListener { view ->
            val action =
                PotDeviceFragmentDirections.actionGlobalPotDeviceFragment(devices[position].name)
            view.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return devices.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var deviceImage: ImageView = itemView.findViewById(R.id.device_image)
        var deviceName: TextView = itemView.findViewById(R.id.device_name)
        var parentLayout: RelativeLayout = itemView.findViewById(R.id.parent_layout)

    }

    init {
        this.devices = devices
        this.context = context
    }
}














