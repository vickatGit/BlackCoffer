package com.example.blackcoffer.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.blackcoffer.Adapter.FriendsAdapter
import com.example.blackcoffer.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class FriendsFragment : Fragment() {
    private lateinit var friendRecycler:RecyclerView
    private lateinit var friendsAdapter:FriendsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_friends, container, false)
        initialiseViews(view)
        friendRecycler.layoutManager=LinearLayoutManager(this@FriendsFragment.context)
        friendsAdapter= FriendsAdapter()
        friendRecycler.adapter=friendsAdapter

        return view
    }

    private fun initialiseViews(view: View?) {
        friendRecycler= view?.findViewById(R.id.friends_recycler)!!


    }


}