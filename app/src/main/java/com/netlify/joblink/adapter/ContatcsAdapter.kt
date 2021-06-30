package com.netlify.joblink.adapter

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