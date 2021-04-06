package edu.zut.wi.planttactic

import android.content.Context
import android.content.res.TypedArray
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.navigation.findNavController
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

        if (holder.roomName.text == "addRoomButton") {

            holder.roomName.visibility = View.GONE
            holder.roomImage.setImageResource(R.drawable.ic_add)

            holder.itemView.setOnClickListener { view ->
                Log.d(TAG, "onClick: clicked on Add Room Button")
                view.findNavController().navigate(R.id.action_homeFragment_to_addRoomFragment)
            }
        } else {
            //TODO: Change this to somehow permanently assign image to corresponding room
            val imgs: TypedArray = context!!.resources.obtainTypedArray(R.array.images)
            val rand = Random()
            val rndInt = rand.nextInt(imgs.length())
            val resID = imgs.getResourceId(rndInt, 0)
            holder.roomImage.setImageResource(resID)

            imgs.recycle()

            holder.parentLayout.setOnClickListener {
                Log.d(TAG, "onClick: clicked on: " + rooms[position].name)
            }
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

    companion object {
        private const val TAG = "RoomsViewAdapter"
    }

    init {
        this.rooms = rooms
        this.context = context
    }
}














