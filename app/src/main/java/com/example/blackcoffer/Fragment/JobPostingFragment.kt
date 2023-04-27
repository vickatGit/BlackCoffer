package com.example.blackcoffer.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.blackcoffer.Adapter.JobPostAdapter
import com.example.blackcoffer.Adapter.JobSeekersAdapter
import com.example.blackcoffer.R


class JobPostingFragment : Fragment() {
    private lateinit var jobPostingRecycler: RecyclerView
    private lateinit var jobPostingAdapter: JobPostAdapter
    private lateinit var filter:ImageView

    interface JobPostingFilterListener {
        fun jobPostFilterClicked()
    }
    private lateinit var jobPostingFilterListener: JobPostingFilterListener
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_job_posting, container, false)
        initialiseViews(view)
        jobPostingRecycler.layoutManager= LinearLayoutManager(this@JobPostingFragment.context)
        jobPostingAdapter= JobPostAdapter()
        jobPostingRecycler.adapter=jobPostingAdapter
        filter.setOnClickListener {
            jobPostingFilterListener.jobPostFilterClicked()
        }

        return view
    }
    private fun initialiseViews(view: View?) {
        jobPostingRecycler= view?.findViewById(R.id.job_poster_recycler)!!
        filter=view?.findViewById(R.id.filter)!!


    }
    fun setFilterClickListener(listener: JobPostingFilterListener) {
        jobPostingFilterListener = listener
    }


}