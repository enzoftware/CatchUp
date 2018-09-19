package com.upc.projects.enzoftware.catchup.ui.activities

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.upc.projects.enzoftware.catchup.R
import com.upc.projects.enzoftware.catchup.ui.fragments.FavoritesFragment
import com.upc.projects.enzoftware.catchup.ui.fragments.HomeFragment
import com.upc.projects.enzoftware.catchup.ui.fragments.SettingsFragment
import com.upc.projects.enzoftware.catchup.ui.fragments.SourcesFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        return@OnNavigationItemSelectedListener navigateTo(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        navigation.selectedItemId = R.id.navigation_home
    }

    private fun fragmentFor(item: MenuItem) : Fragment {

        when(item.itemId){
            R.id.navigation_home -> {
                return HomeFragment()
            }
            R.id.navigation_favorites ->{
                return FavoritesFragment()
            }
            R.id.navigation_settings ->{
                return SettingsFragment()
            }
            R.id.navigation_sources ->{
                return SourcesFragment()
            }
        }
        return HomeFragment()
    }


    private fun navigateTo(item : MenuItem) : Boolean{
        item.isChecked = true
        return supportFragmentManager
                .beginTransaction()
                .replace(R.id.contentMain,fragmentFor(item))
                .commit() > 0

    }
}
