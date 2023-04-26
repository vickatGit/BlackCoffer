package com.example.blackcoffer.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.blackcoffer.R

class JobSeekersAdapter: RecyclerView.Adapter<JobSeekersAdapter.JobSeekerHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobSeekerHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.job_seeker_layout, parent, false)
        return JobSeekerHolder(view)
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: JobSeekerHolder, position: Int) {

    }

    inner class JobSeekerHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}