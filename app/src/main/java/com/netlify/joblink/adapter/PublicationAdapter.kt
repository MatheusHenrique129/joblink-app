package com.netlify.joblink.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.github.rtoshiro.util.format.SimpleMaskFormatter
import com.github.rtoshiro.util.format.text.MaskTextWatcher
import com.netlify.joblink.R
import com.netlify.joblink.model.PublicationModel
import com.netlify.joblink.ui.birthDateRegister

class PublicationAdapter(val context: FragmentActivity?) :
    RecyclerView.Adapter<PublicationAdapter.PublicationViewHolder>() {

    private var ListPublication: List<PublicationModel> = emptyList()

    fun updateListPublication(list: List<PublicationModel>) {
        ListPublication = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PublicationViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.layout_list_publications, parent, false)

        return PublicationViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return ListPublication.size
    }

    override fun onBindViewHolder(holder: PublicationViewHolder, position: Int) {
        val publication = ListPublication[position]
        Glide.with(context!!).load(publication.image).into(holder.ivImage)

        holder.tvNameUser.text = publication.userModel.name


        val maskDate: SimpleMaskFormatter = SimpleMaskFormatter("NN/NN/YYYY")
        val mtwDate: MaskTextWatcher = MaskTextWatcher(holder.tvDatePublication, maskDate)
        holder.tvDatePublication.addTextChangedListener(mtwDate)

        holder.tvDatePublication.text = publication.datePublication
        holder.tvProfission.text = publication.profission
        holder.tvDescription.text = publication.description

    }

    class PublicationViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val tvNameUser = view.findViewById<TextView>(R.id.textNameUser)
        val tvDatePublication = view.findViewById<TextView>(R.id.textDatePublication)
        val tvProfission = view.findViewById<TextView>(R.id.textProfission)
        val tvDescription = view.findViewById<TextView>(R.id.textDescription)
        val ivImage = view.findViewById<ImageView>(R.id.ivPublication)
    }
}