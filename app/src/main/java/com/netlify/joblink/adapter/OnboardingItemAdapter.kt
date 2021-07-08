package com.netlify.joblink.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.netlify.joblink.R

class OnboardingItemAdapter(val context: Context) :
    RecyclerView.Adapter<MessageAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageAdapter.Holder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: MessageAdapter.Holder, position: Int) {
        TODO("Not yet implemented")
    }

    class ProfessionViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val nameProfession = view.findViewById<TextView>(R.id.title_profession)
        val imageProfession = view.findViewById<ImageView>(R.id.image_profission)

    }
}