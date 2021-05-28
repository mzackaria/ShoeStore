package com.udacity.shoestore

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.udacity.shoestore.databinding.ActivityMainBinding
import com.udacity.shoestore.fragments.ShoeListFragmentDirections
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.i("Flow onCreate")

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val navHostFragment = supportFragmentManager.findFragmentById(
            R.id.nav_fragment
        ) as NavHostFragment
        val navController = navHostFragment.navController
        val appBarConfiguration = AppBarConfiguration(
            setOf(R.id.login_nav, R.id.shoeListFragment)
        )
        val toolbar: Toolbar = binding.toolbar
        toolbar.setupWithNavController(navController, appBarConfiguration)
        Timber.plant(Timber.DebugTree())
    }

    override fun onSupportNavigateUp(): Boolean {

        val navController = findNavController(R.id.nav_fragment)
        return navController.navigateUp()
    }
}


