package com.example.blackcoffer.Adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.blackcoffer.Fragment.FriendsFragment
import com.example.blackcoffer.Fragment.JobPostingFragment
import com.example.blackcoffer.Fragment.JobSeekersFragment

class ExploreTabsAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager, lifecycle)  {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> FriendsFragment()
            1 -> JobSeekersFragment()
            2 -> JobPostingFragment()

            else -> {FriendsFragment()}
        }
    }
}