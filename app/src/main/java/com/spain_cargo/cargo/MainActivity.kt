package com.spain_cargo.cargo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.afollestad.vvalidator.util.hide
import com.afollestad.vvalidator.util.show
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.spain_cargo.cargo.util.setupWithNavController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var currentNavController: LiveData<NavController>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        if (savedInstanceState == null) {
            setupBottomNavigationBar()
            val toolbar = findViewById<Toolbar>(R.id.toolbar)
            setSupportActionBar(toolbar)
        }

        fab.setOnClickListener {
            currentNavController?.value?.navigate(R.id.createOrderFragment)
        }


    }


    private fun setupBottomNavigationBar() {
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_nav)

        val navGraphIds = listOf(
            R.navigation.home,
            R.navigation.orders,
            R.navigation.profile
        )

        val controller = bottomNavigationView.setupWithNavController(
            navGraphIds = navGraphIds,
            fragmentManager = supportFragmentManager,
            containerId = R.id.nav_host_container,
            intent = intent
        )

        controller.observe(this, Observer { navController ->

            navController.addOnDestinationChangedListener { controller, destination, arguments ->

                setupActionBarWithNavController(controller)

                when (destination.id) {
                    R.id.homeFragment -> {
                        fab.show()
                        bottom_nav.show()
                    }
                    R.id.createOrderFragment, R.id.addItemFragment -> {
                        bottom_nav.hide()
                        fab.hide()
                    }
                    else -> {
                        bottom_nav.show()
                        fab.hide()
                    }
                }

            }

        })
        currentNavController = controller
    }

    override fun onSupportNavigateUp(): Boolean {
        return currentNavController?.value?.navigateUp() ?: false
    }


}


