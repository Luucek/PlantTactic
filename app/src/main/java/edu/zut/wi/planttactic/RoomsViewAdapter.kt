package edu.zut.wi.planttactic

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.*


class RoomsViewAdapter(context: Context?, rooms: ArrayList<Room>) : RecyclerView.Adapter<RoomsViewAdapter.ViewHolder>() {

    private var rooms = ArrayList<Room>()
    private val context: Context?

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.layout_room_listitem, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d(TAG, "onBindViewHolder: called.")

        holder.roomName.text = rooms[position].name
//TODO: Add imageView
        holder.parentLayout.setOnClickListener {
            if (rooms[position] == rooms[rooms.lastIndex])
                Log.d(TAG, "onClick: clicked on Add Button")
            else
                Log.d(TAG, "onClick: clicked on: " + rooms[position].name)
        }
    }

    override fun getItemCount(): Int {
        return rooms.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        var roomImage: ImageView = itemView.findViewById(R.id.room_image)
        var roomName: TextView = itemView.findViewById(R.id.room_name)
        var parentLayout: RelativeLayout = itemView.findViewById(R.id.parent_layout)

    }

    companion object {
        private const val TAG = "RoomsViewAdapter"
    }

    init {
        this.rooms = rooms
        this.context = context
    }
}














