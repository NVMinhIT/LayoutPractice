package com.daovuu97.layoutpractice.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.daovuu97.layoutpractice.R
import com.daovuu97.layoutpractice.model.User
import de.hdodenhof.circleimageview.CircleImageView

class ListUserAdapter(
    private val context: Context,
    private val listUser: List<User>
) : RecyclerView.Adapter<ListUserAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.user_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listUser.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentUser:User = listUser[position]
        Glide.with(context)
            .load(currentUser.userImage)
            .override(200,200)
            .centerCrop()
            .into(holder.userImage)
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val userImage: CircleImageView = itemView.findViewById(R.id.profile_image)
    }
}