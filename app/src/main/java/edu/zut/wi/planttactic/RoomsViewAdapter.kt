package edu.zut.wi.planttactic

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import edu.zut.wi.planttactic.classes.Room
import edu.zut.wi.planttactic.fragments.RoomFragmentDirections
import java.util.*


class RoomsViewAdapter(context: Context?, rooms: ArrayList<Room>) :
    RecyclerView.Adapter<RoomsViewAdapter.ViewHolder>() {

    private var rooms = ArrayList<Room>()
    private val context: Context?

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_room_listitem, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.roomName.text = rooms[position].name
        holder.roomImage.setImageResource(rooms[position].imageID)
        holder.parentLayout.setOnClickListener { view ->
            val action = RoomFragmentDirections.actionGlobalRoomFragment(rooms[position].name)
            view.findNavController().navigate(action)
        }
    }


    override fun getItemCount(): Int {
        return rooms.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var roomImage: ImageView = itemView.findViewById(R.id.room_image)
        var roomName: TextView = itemView.findViewById(R.id.room_name)
        var parentLayout: RelativeLayout = itemView.findViewById(R.id.parent_layout)

    }

    init {
        this.rooms = rooms
        this.context = context
    }
}














