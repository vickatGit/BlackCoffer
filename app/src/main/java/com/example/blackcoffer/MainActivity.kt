package com.example.blackcoffer

import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.example.blackcoffer.Fragment.ExploreFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var toolbar: Toolbar
    private lateinit var appDrawer: DrawerLayout
    private lateinit var menuNav: NavigationView
    private lateinit var bottomNav: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initialiseViews()
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
            when(it.itemId){
                R.id.explore -> {
                    supportFragmentManager.beginTransaction().replace(R.id.fragment_container,ExploreFragment()).commit()
                    true
                }
                else -> {
                    false
                }
            }
        }


    }

    private fun initialiseViews() {
        toolbar = findViewById(R.id.toolbar)
        appDrawer = findViewById(R.id.app_drawer)
        menuNav = findViewById(R.id.nav_menu)
        bottomNav = findViewById(R.id.bottom_nav)
    }
}