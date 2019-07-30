package com.example.kepotekno

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.example.kepotekno.feature.about.AboutFragment
import com.example.kepotekno.feature.dslr.DslrFragment
import com.example.kepotekno.feature.home.HomeFragment
import com.example.kepotekno.feature.laptop.LaptopFragment
import com.example.kepotekno.feature.smartphone.SmartphoneFragment
import com.example.kepotekno.feature.tablet.TabletFragment
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.app_bar_home.*

class HomeActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        if (savedInstanceState == null) {
            var fragment: Fragment = HomeFragment ()
            supportFragmentManager.beginTransaction().replace(R.id.content_main, fragment).commit()
        }
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.home, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        var fragment: Fragment? = null
        var actionBarTitle: String? = null
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_home -> {
                // Handle the camera action
                fragment = HomeFragment()
                actionBarTitle = "Home"
            }
            R.id.nav_smartphone -> {
                fragment = SmartphoneFragment()
                actionBarTitle = "Smartphone"
            }
            R.id.nav_tablet -> {
                fragment = TabletFragment()
                actionBarTitle = "Tablet"
            }
            R.id.nav_laptop -> {
                fragment = LaptopFragment()
                actionBarTitle = "Laptop"
            }
            R.id.nav_dslr -> {
                fragment = DslrFragment()
                actionBarTitle = "Kamera"
            }
            R.id.nav_about -> {
                fragment = AboutFragment()
                actionBarTitle = "About"
            }
        }

        if (fragment != null) {
            supportFragmentManager.beginTransaction().replace(R.id.content_main, fragment).commit()
        }

        supportActionBar?.title = actionBarTitle

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
