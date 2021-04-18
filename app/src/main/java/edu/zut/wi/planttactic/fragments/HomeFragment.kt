package edu.zut.wi.planttactic.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import edu.zut.wi.planttactic.R
import edu.zut.wi.planttactic.RoomsViewAdapter
import edu.zut.wi.planttactic.classes.Room
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment(R.layout.fragment_home) {

    lateinit var auth: FirebaseAuth

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireActivity().invalidateOptionsMenu()

        auth = FirebaseAuth.getInstance()

        if (auth.currentUser != null) {
            val userRooms = Room.loadSavedRooms(this.context)
            initRecyclerView(userRooms)
        } else {
            login_hint.visibility = View.VISIBLE
        }

        fab_add_room.setOnClickListener {
            if (auth.currentUser != null)
                view.findNavController().navigate(R.id.action_homeFragment_to_addRoomFragment)
            else {
                Toast.makeText(
                    this.activity,
                    getString(R.string.log_in_before),
                    Toast.LENGTH_SHORT
                ).show()
                view.findNavController().navigate(R.id.action_global_loginFragment)
            }
        }
    }

    private fun initRecyclerView(rooms: ArrayList<Room>) {

        val recyclerView: RecyclerView? = view?.findViewById(R.id.roomsView)
        val adapter = RoomsViewAdapter(this.context, rooms)

        recyclerView?.adapter = adapter
        recyclerView?.layoutManager = GridLayoutManager(this.context, 2)
    }
}