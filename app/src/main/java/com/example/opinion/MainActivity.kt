package com.example.opinion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.opinion.Constants.ECONOMIST
import com.example.opinion.Constants.LIVEMINT
import com.example.opinion.Constants.THE_HINDU
import com.example.opinion.Constants.THE_INDIAN_EXPRESS
import com.example.opinion.Constants.THE_TIMES_OF_INDIA
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    lateinit var toolbar: Toolbar
    lateinit var drawerLayout: DrawerLayout
    lateinit var navView: NavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        drawerLayout = findViewById(R.id.drawer_layout)
        navView = findViewById(R.id.nav_view)
        navView.setNavigationItemSelectedListener(this)

        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, 0, 0
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_root, RSSFragment(THE_HINDU))
                .commit()
            navView.setCheckedItem(R.id.theHindu)
        }

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_profile -> {
                Toast.makeText(this, "Profile clicked", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_messages -> {
                Toast.makeText(this, "Messages clicked", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_friends -> {
                Toast.makeText(this, "Friends clicked", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_update -> {
                Toast.makeText(this, "Update clicked", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_logout -> {
                Toast.makeText(this, "Sign out clicked", Toast.LENGTH_SHORT).show()
            }
            R.id.theHindu -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_root, RSSFragment(THE_HINDU))
                    .commit()
            }
            R.id.theIndianExpress -> {
                supportFragmentManager.beginTransaction().replace(
                    R.id.fragment_root, RSSFragment(THE_INDIAN_EXPRESS)
                ).commit()
            }
            R.id.theTimesOfIndia -> {
                supportFragmentManager.beginTransaction().replace(
                    R.id.fragment_root, RSSFragment(THE_TIMES_OF_INDIA)
                ).commit()
            }
            R.id.economist -> {
                supportFragmentManager.beginTransaction().replace(
                    R.id.fragment_root, RSSFragment(ECONOMIST)
                ).commit()
            }
            R.id.livemint -> {
                supportFragmentManager.beginTransaction().replace(
                    R.id.fragment_root, RSSFragment(LIVEMINT)
                ).commit()
            }
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}