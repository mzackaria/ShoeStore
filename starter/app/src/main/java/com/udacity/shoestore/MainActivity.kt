package com.udacity.shoestore

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.udacity.shoestore.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val toolbar: Toolbar = binding.toolbar
        setSupportActionBar(toolbar)

        val navHostFragment = supportFragmentManager.findFragmentById(
            R.id.nav_fragment
        ) as NavHostFragment
        val navController = navHostFragment.navController

        val appBarConfiguration = AppBarConfiguration(
            topLevelDestinationIds = setOf(R.id.login_nav, R.id.shoeListFragment)
        )
        toolbar.setupWithNavController(navController, appBarConfiguration)

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_fragment)
        return navController.navigateUp()
    }
}


