package com.example.blackcoffer.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.blackcoffer.Fragment.FriendsFragment
import com.example.blackcoffer.Fragment.JobPostingFragment
import com.example.blackcoffer.Fragment.JobSeekersFragment
import com.example.blackcoffer.MainActivity

class ExploreTabsAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle,
    private val parentActivity: MainActivity
) : FragmentStateAdapter(fragmentManager, lifecycle)  {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                val frag=FriendsFragment()
                frag.setFilterClickListener(parentActivity)
                frag
            }
            1 -> {
                val frag=JobSeekersFragment()
                frag.setFilterClickListener(parentActivity)
                frag
            }
            2 -> {
                val frag=JobPostingFragment()
                frag.setFilterClickListener(parentActivity)
                frag
            }

            else -> {FriendsFragment()}
        }
    }
}