package com.netlify.joblink.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.netlify.joblink.R
import com.netlify.joblink.api.SessionManager
import com.netlify.joblink.databinding.ActivityHomeBinding
import com.netlify.joblink.fragments.HomeFragment
import com.netlify.joblink.fragments.ProfileFragment
import com.netlify.joblink.fragments.SearchFragment

class HomeActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var homeFragment: HomeFragment
    private lateinit var searchFragment: SearchFragment
    private lateinit var sessionManager: SessionManager
    private lateinit var profileFragment: ProfileFragment
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sessionManager = SessionManager(this)

        Log.i("XXXXXXXXXXXXXX FICAR SALVO TESTEE", sessionManager.fetchAuthToken().toString())

        //verifyAuthentication()
        loadData()
        insertToolbar()
        setFragment(homeFragment)
    }

    private fun loadData() {
        homeFragment = HomeFragment()
        searchFragment = SearchFragment()
        profileFragment = ProfileFragment()

        bottomNavigationView = binding.bottomNavigation
        bottomNavigationView.setOnNavigationItemSelectedListener(this)
    }

    private fun verifyAuthentication() {
        val token = sessionManager.fetchAuthToken()

        if (token == null) {
            logout()
        }
//        else {
//            val jwt = JWT(token)
//
//            if (jwt.isExpired(0)) {
//                notifyUser("Sua sessão expirou")
//                logout()
//            }
//        }
    }

    private fun logout() {
        val intent = Intent(this, SplashScreenActivity::class.java)
        startActivity(intent)
        sessionManager.logout()
        finish()
    }

    private fun notifyUser(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun insertToolbar() {
        setSupportActionBar(binding.include.toolbar)
       //supportActionBar?.title = "JOBLINK"
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_config_logout, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.logout -> {
                logout()
                verifyAuthentication()
                notifyUser("Você fez Logout")
            }
            R.id.publish -> {
                val intent = Intent(this, PublishActivity::class.java)
                startActivity(intent)
            }
        }
        return true
    }


    private fun setFragment(fragment: Fragment) {
        val fragmentTransition = supportFragmentManager.beginTransaction()
        fragmentTransition.replace(binding.frameFragments.id, fragment)
        fragmentTransition.commit()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_home -> {
                setFragment(homeFragment)
            }
            R.id.menu_search -> {
                setFragment(searchFragment)
            }
            R.id.menu_message -> {
                val intent = Intent(this, ChatActivity::class.java)
                startActivity(intent)
            }
            R.id.menu_profile -> {
                setFragment(profileFragment)
            }
        }
        return true
    }
}