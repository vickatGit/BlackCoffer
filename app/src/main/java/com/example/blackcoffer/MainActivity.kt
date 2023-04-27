package com.example.blackcoffer

import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.isVisible
import androidx.drawerlayout.widget.DrawerLayout
import com.example.blackcoffer.Fragment.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), FriendsFragment.FriendFilterListener,
    JobPostingFragment.JobPostingFilterListener, JobSeekersFragment.JobSeekersFilterListener {
    private lateinit var toolbar: Toolbar
    private lateinit var appDrawer: DrawerLayout
    private lateinit var menuNav: NavigationView
    private lateinit var bottomNav: BottomNavigationView
    private lateinit var friendsFilter: View
    private lateinit var jobSeekerFilter: View
    private lateinit var jobPosterFilter: View


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initialiseViews()
        initialiseFilters()
        setSupportActionBar(toolbar)
        setNavigationIconToToolbar(toolbar)
    }


    private fun setNavigationIconToToolbar(toolbar: Toolbar) {
        val drawable: Drawable = getResources().getDrawable(R.drawable.menu_icon)
        val bitmap: Bitmap = (drawable as BitmapDrawable).getBitmap()
        val transformedIcon: Drawable =
            BitmapDrawable(resources, Bitmap.createScaledBitmap(bitmap, 80, 80, true))
        transformedIcon.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP)
        toolbar.navigationIcon = transformedIcon
        val menuToggle = ActionBarDrawerToggle(
            this,
            appDrawer,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )

        appDrawer.addDrawerListener(menuToggle)
        menuToggle.syncState()
        menuToggle.drawerArrowDrawable = CustomMenuIconDrawable(this)

        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.explore -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, ExploreFragment(this)).commit()
                    true
                }
                R.id.refine -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, RefineFragment()).commit()
                    true
                }
                R.id.network -> {
                    true
                }
                R.id.chat -> {
                    true
                }
                R.id.contacts -> {
                    true
                }
                else -> {
                    false
                }
            }
        }
        bottomNav.selectedItemId = R.id.refine


    }

    private fun initialiseViews() {
        toolbar = findViewById(R.id.toolbar)
        appDrawer = findViewById(R.id.app_drawer)
        menuNav = findViewById(R.id.nav_menu)
        bottomNav = findViewById(R.id.bottom_nav)
        friendsFilter = findViewById(R.id.friends_filter_layout)
        jobSeekerFilter = findViewById(R.id.job_seeker_layout)
        jobPosterFilter = findViewById(R.id.job_poster_layout)
    }

    private fun initialiseFilters() {
        friendsFilter.findViewById<ImageView>(R.id.exit_friend_filter).setOnClickListener {
            closeFilter(friendsFilter)
        }
        friendsFilter.findViewById<Button>(R.id.apply_friend_filter).setOnClickListener {
            closeFilter(friendsFilter)
        }
        jobPosterFilter.findViewById<ImageView>(R.id.exit_job_poster_filter).setOnClickListener {
            closeFilter(jobPosterFilter)
        }
        jobPosterFilter.findViewById<Button>(R.id.job_poster_filter_apply).setOnClickListener {
            closeFilter(jobPosterFilter)
        }
        jobSeekerFilter.findViewById<ImageView>(R.id.exit_job_seeker_filter).setOnClickListener {
            closeFilter(jobSeekerFilter)
        }
        jobSeekerFilter.findViewById<Button>(R.id.job_seeker_filter_apply).setOnClickListener {
            closeFilter(jobSeekerFilter)
        }
    }

    override fun friendsFilterClicked() { openFilter(friendsFilter) }

    override fun jobPostFilterClicked() { openFilter(jobPosterFilter) }

    override fun jobSeekersFilterClicked() { openFilter(jobSeekerFilter) }

    private fun closeFilter(view: View) {
        val slideDown = AnimationUtils.loadAnimation(this@MainActivity, R.anim.filter_close)
        view.startAnimation(slideDown)
        slideDown.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {}

            override fun onAnimationEnd(animation: Animation?) {
                view.isVisible = false

            }

            override fun onAnimationRepeat(animation: Animation?) {}
        })
    }

    private fun openFilter(view: View) {
        val slideUp = AnimationUtils.loadAnimation(this@MainActivity, R.anim.filter_open)
        view.startAnimation(slideUp)
        slideUp.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {}

            override fun onAnimationEnd(animation: Animation?) {
                view.isVisible = true
            }

            override fun onAnimationRepeat(animation: Animation?) {}
        })
    }
}