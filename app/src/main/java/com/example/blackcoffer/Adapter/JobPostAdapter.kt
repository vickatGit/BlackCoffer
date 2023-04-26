package com.example.blackcoffer.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.blackcoffer.R

class JobPostAdapter: RecyclerView.Adapter<JobPostAdapter.JobPostHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobPostHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.job_post_layout, parent, false)
        return JobPostHolder(view)
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: JobPostHolder, position: Int) {

    }

    inner class JobPostHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}