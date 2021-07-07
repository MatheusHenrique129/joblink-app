//package com.netlify.joblink.adapter
//
//import android.content.Context
//import android.view.View
//import android.view.ViewGroup
//import android.widget.ImageView
//import android.widget.TextView
//import androidx.recyclerview.widget.RecyclerView
//import com.bumptech.glide.Glide
//import com.netlify.joblink.R
//
//class ContatcsAdapter(var context: Context) : RecyclerView.Adapter<ContatcsAdapter.ViewHolder>() {
//
//    private var listContact: List<User> = emptyList()
//
//    fun updateListContact(list: List<User>) {
//        listContact = list
//        notifyDataSetChanged()
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        TODO("Not yet implemented")
//    }
//
//    override fun getItemCount(): Int {
//        TODO("Not yet implemented")
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        val contact = listContact[position]
//        Glide.with(context).load(contact).into(holder.imageContact)
//    }
//
//    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//        val imageContact = view.findViewById<ImageView>(R.id.iv_iamge_contact)
//        val nameContact = view.findViewById<TextView>(R.id.tv_name_contact)
//    }
//}