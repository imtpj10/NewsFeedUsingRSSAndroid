package com.example.opinion

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.webkit.WebView
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.opinion.Constants.ECONOMIST
import com.example.opinion.Constants.LIVEMINT
import com.example.opinion.Constants.THE_HINDU
import com.example.opinion.Constants.THE_HINDU_EDITORIAL
import com.example.opinion.Constants.THE_INDIAN_EXPRESS
import com.example.opinion.Constants.THE_INDIAN_EXPRESS_EDITORIAL
import com.example.opinion.Constants.THE_TIMES_OF_INDIA
import com.example.opinion.Constants.THE_TIMES_OF_INDIA_EDITORIAL
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
            R.id.theHinduEditorial -> {
                fragmentLoad(THE_HINDU_EDITORIAL)
            }
            R.id.theIndianExpressEditorial -> {
                fragmentLoad(THE_INDIAN_EXPRESS_EDITORIAL)
            }
            R.id.theTimesOfIndiaEditorial -> {
                fragmentLoad(THE_TIMES_OF_INDIA_EDITORIAL)
            }
            R.id.nav_update -> {
                Toast.makeText(this, "Update clicked", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_logout -> {
                Toast.makeText(this, "Sign out clicked", Toast.LENGTH_SHORT).show()
            }
            R.id.theHindu -> {
                fragmentLoad(THE_HINDU)
            }
            R.id.theIndianExpress -> {
                fragmentLoad(THE_INDIAN_EXPRESS)
            }
//            R.id.theTimesOfIndia -> {
//                fragmentLoad(THE_TIMES_OF_INDIA)
//            }
            R.id.economist -> {
                fragmentLoad(ECONOMIST)
            }
            R.id.livemint -> {
                fragmentLoad(LIVEMINT)
            }
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun fragmentLoad(link: String) {
        supportFragmentManager.beginTransaction().replace(
            R.id.fragment_root, RSSFragment(link)
        ).commit()
    }
}