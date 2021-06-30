package com.netlify.joblink.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import com.netlify.joblink.R
import com.netlify.joblink.model.PublicationModel

class ProfileFragment : Fragment() {

    lateinit var btnSelected: Button
    lateinit var ivPhoto: ImageView
    lateinit var user: PublicationModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }


//        btnSelected = bt_selected_photo
//        ivPhoto = iv_photo




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

}