package com.netlify.joblink.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.auth0.android.jwt.JWT
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.netlify.joblink.R
import com.netlify.joblink.api.SessionManager
import com.netlify.joblink.fragments.HomeFragment
import com.netlify.joblink.fragments.ProfileFragment
import com.netlify.joblink.fragments.PublishFragment
import com.netlify.joblink.fragments.SearchFragment
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var homeFragment: HomeFragment
    private lateinit var searchFragment: SearchFragment
    private lateinit var publishFragment: PublishFragment
    private lateinit var profileFragment: ProfileFragment
    lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        sessionManager = SessionManager(this)

        Log.i("XXXXXXXXXXXXXX FICAR SALVO TESTEE", sessionManager.fethAuthToken().toString())

        verifyAuthentication()
        loadData()
        insertToolbar()

        setFragment(homeFragment)
    }

    private fun loadData() {
        homeFragment = HomeFragment()
        searchFragment = SearchFragment()
        publishFragment = PublishFragment()
        profileFragment = ProfileFragment()

        bottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener(this)
    }

    private fun verifyAuthentication() {
        val token = sessionManager.fethAuthToken()

        if (token == null) {
            logout() }
//        } else {
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
        setSupportActionBar(include as Toolbar?)
        supportActionBar?.title = "JOBLINK"
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
            }
        }

        return true
    }


    private fun setFragment(fragment: Fragment) {
        val fragmentTransition = supportFragmentManager.beginTransaction()
        fragmentTransition.replace(R.id.frame_fragments, fragment)
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
                val intent = Intent(this, MessageActivity::class.java)
                startActivity(intent)
            }
            R.id.menu_profile -> {
                setFragment(profileFragment)
            }
        }

        return true
    }
}