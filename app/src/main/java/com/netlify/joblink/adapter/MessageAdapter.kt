package com.netlify.joblink.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.netlify.joblink.R
import com.netlify.joblink.model.UserModel
import com.netlify.joblink.ui.ChatActivity

class MessageAdapter(val context: Context) :
    RecyclerView.Adapter<MessageAdapter.Holder>() {

    private var listMessage: List<UserModel> = emptyList()

    private var isLeft: Boolean = false

    private fun MessageItem(isLeft: Boolean) {
        this.isLeft = isLeft
    }

    fun updateListContact(list: List<UserModel>) {
        listMessage = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater
            .from(context)
            .inflate(R.layout.layout_item_user, parent, false)

        return Holder(view)
    }

    override fun getItemCount(): Int {
        return listMessage.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val message = listMessage[position]

        if (message.image?.trim()?.isNotEmpty() == true) {
            Glide.with(context)
                .load(message.image)
                .into(holder.imageContact)
        }

        holder.nameContact.text = message.name

        holder.containerLinear.setOnClickListener {
            val intent = Intent(context, ChatActivity::class.java)
            //intent.putExtra("destino", contact)
            context.startActivity(intent)
        }
    }

    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        val imageContact = view.findViewById<ImageView>(R.id.iv_iamge_contact)
        val nameContact = view.findViewById<TextView>(R.id.tv_name_contact)
        val containerLinear = view.findViewById<LinearLayout>(R.id.ll_container)
    }
}