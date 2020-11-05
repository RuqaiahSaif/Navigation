package com.example1.navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import android.widget.Toast.makeText
import android.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.app_bar_main.*

lateinit var drawerLayout: DrawerLayout
lateinit var nav:NavigationView
lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
class MainActivity : AppCompatActivity() , NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?)   {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
      //  val toolbar1: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        nav = findViewById(R.id.nav)

        drawerLayout = findViewById(R.id.drawer_layout)
        actionBarDrawerToggle = object : ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        ) {
            override fun onDrawerClosed(drawerView: View) {
                super.onDrawerClosed(drawerView)
                setTitle(R.string.app_name)
            }

            override fun onDrawerOpened(drawerView: View) {
                super.onDrawerOpened(drawerView)
                setTitle(R.string.app_name)
            }
        }
        actionBarDrawerToggle.isDrawerIndicatorEnabled = true
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        nav.setNavigationItemSelectedListener {
            when (it .itemId){
                R.id.profile -> {

                    movetoFragment( Fragment1.newInstance("profile"))

                    true
                }
                R.id.people -> {
                    movetoFragment( Fragment1.newInstance("people"))
                    true
                }
                R.id.setting -> {
                    movetoFragment( Fragment1.newInstance("setting"))
                    true
                }
                else ->
                {
                    false
                }
            }
        }


    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        TODO("Not yet implemented")
    }
    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START))
            drawerLayout.closeDrawer(GravityCompat.START)
        else
            super.onBackPressed()
    }
    private fun movetoFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frameContainer, fragment)
            .addToBackStack(null)
            .commit()

        drawerLayout.closeDrawer(GravityCompat.START)
    }
}