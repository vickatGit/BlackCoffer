package com.example.blackcoffer.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.blackcoffer.Adapter.FriendsAdapter
import com.example.blackcoffer.Adapter.JobSeekersAdapter
import com.example.blackcoffer.R


class JobSeekersFragment : Fragment() {

    private lateinit var jobSeekerRecycler: RecyclerView
    private lateinit var jobSeekerAdapter: JobSeekersAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_job_seekers, container, false)
        initialiseViews(view)
        jobSeekerRecycler.layoutManager= LinearLayoutManager(this@JobSeekersFragment.context)
        jobSeekerAdapter= JobSeekersAdapter()
        jobSeekerRecycler.adapter=jobSeekerAdapter

        return view
    }
    private fun initialiseViews(view: View?) {
        jobSeekerRecycler= view?.findViewById(R.id.job_seeker_recycler)!!
    }


}