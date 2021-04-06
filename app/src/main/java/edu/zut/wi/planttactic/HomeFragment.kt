package edu.zut.wi.planttactic

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment(R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val userRooms = Room.loadSavedRooms(this.context)

        initRecyclerView(userRooms)
    }

    private fun initRecyclerView(rooms: ArrayList<Room>) {
        Log.d("TAG", "initRecyclerView: init recyclerview.")

        val recyclerView: RecyclerView? = view?.findViewById(R.id.roomsView)
        val adapter = RoomsViewAdapter(this.context, rooms)

        recyclerView?.adapter = adapter
        recyclerView?.layoutManager = GridLayoutManager(this.context, 2)
    }
}