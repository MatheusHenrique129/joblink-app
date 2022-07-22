package com.netlify.joblink.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.cardview.widget.CardView
import com.netlify.joblink.R

class ClientOrFreelancerRegisterActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var cvRegisterClient: CardView
    private lateinit var cvRegisterFreelancer: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_client_or_freelancer_register)

        loadData()
    }

    private fun loadData() {
        cvRegisterClient = findViewById(R.id.cv_register_client)
        cvRegisterFreelancer = findViewById(R.id.cv_register_freelancer)

        cvRegisterClient.setOnClickListener(this)
        cvRegisterFreelancer.setOnClickListener(this)
    }

    override fun onClick(view: View) {

        when (view.id) {
            R.id.cv_register_client -> {
                val intent = Intent(this, ClientRegisterActivity::class.java)
                startActivity(intent)
            }
            R.id.cv_register_freelancer -> {
                val intent = Intent(this, RegisterFreelancerActivity::class.java)
                startActivity(intent)
            }
        }
    }
}