package com.example.blackcoffer.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.blackcoffer.Adapter.ExploreTabsAdapter
import com.example.blackcoffer.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class ExploreFragment : Fragment() {

    private lateinit var exploreTabs: TabLayout
    private lateinit var exploreTabsAdapter: ExploreTabsAdapter
    private lateinit var exploreTabsViewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_explore, container, false)
        initialiseViews(view)
        initialiseTabs()

        return view

    }

    private fun initialiseTabs() {
        exploreTabs.addTab(exploreTabs.newTab(), 0)
        exploreTabs.addTab(exploreTabs.newTab(), 1)
        exploreTabs.addTab(exploreTabs.newTab(), 2)
        exploreTabsAdapter =
            ExploreTabsAdapter(requireFragmentManager(), this@ExploreFragment.lifecycle)
        exploreTabsViewPager.setAdapter(exploreTabsAdapter)



        TabLayoutMediator(
            exploreTabs, exploreTabsViewPager
        ) { tab, position ->
            if (position == 0) tab.setIcon(R.drawable.users_icon)
            if (position == 1) tab.setIcon(R.drawable.office_bag_icon)
            if (position == 2) tab.setIcon(R.drawable.store_icon)
        }.attach()
    }

    private fun initialiseViews(view: View) {
        exploreTabsViewPager=view.findViewById(R.id.explore_tabs_pager)
        exploreTabs=view.findViewById(R.id.explore_tabs)
    }


}