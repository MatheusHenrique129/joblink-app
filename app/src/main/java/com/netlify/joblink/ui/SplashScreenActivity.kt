package com.netlify.joblink.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.netlify.joblink.R
import com.netlify.joblink.databinding.ActivitySplashScreenBinding

class SplashScreenActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        changeToLogin()
    }

    private fun changeToLogin() {
        val intent = Intent(this, MainActivity::class.java)
        Handler().postDelayed({
            intent.change()
        }, 2000)
    }

    private fun Intent.change() {
        startActivity(this)
        finish()
    }
}