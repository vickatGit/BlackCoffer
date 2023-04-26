package com.example.blackcoffer.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.blackcoffer.R

class FriendsAdapter : RecyclerView.Adapter<FriendsAdapter.FriendHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.friend_layout,parent,false)
        return FriendHolder(view)
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: FriendHolder, position: Int) {

    }
    inner class FriendHolder(itemView: View) : ViewHolder(itemView){

    }
}