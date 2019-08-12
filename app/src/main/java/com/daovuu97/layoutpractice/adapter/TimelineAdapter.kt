package com.daovuu97.layoutpractice.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.Group
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.daovuu97.layoutpractice.R
import com.daovuu97.layoutpractice.model.Status
import de.hdodenhof.circleimageview.CircleImageView
import java.text.DateFormat
import java.util.*

class TimelineAdapter(
    private val context: Context,
    private val listStatus: List<Status>
) : RecyclerView.Adapter<TimelineAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.timeline_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listStatus.size
    }

    public fun getStatusAt(position: Int): Status {
        return listStatus[position]
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentStatus: Status = listStatus[position]
        updateView(holder, currentStatus)
    }

    @SuppressLint("SetTextI18n")
    private fun updateView(holder: ViewHolder, status: Status) {
        Glide.with(context)
            .load(status.userImage)
            .override(200, 200)
            .centerCrop()
            .into(holder.userImage)
        holder.userName.text = status.userName
        val time = Date(System.currentTimeMillis() - status.time)
        holder.time.text = DateFormat.getTimeInstance(DateFormat.SHORT).format(time).toString()
        if (status.listConnecttion == null) {
            if (status.text.equals("")) {
                holder.text.visibility = View.GONE
            } else {
                holder.text.visibility = View.VISIBLE
                holder.text.text = status.text
                holder.connection.visibility = View.GONE
                holder.likeCount.text = status.like
                holder.commectCount.text = status.comment
            }

            if (status.image.isEmpty() || status.image.isBlank()) {
                holder.image.visibility = View.GONE
            } else {
                holder.image.visibility = View.VISIBLE
                Glide.with(context)
                    .load(status.image)
                    .centerCrop()
                    .into(holder.image)
                holder.connection.visibility = View.GONE
                holder.likeCount.text = status.like
                holder.commectCount.text = status.comment
            }
        } else {
            holder.text.visibility = View.VISIBLE
            holder.image.visibility = View.GONE
            holder.group.visibility = View.GONE
            holder.text.text = status.text
            val mAdapter: ListUserAdapter = ListUserAdapter(context, status.listConnecttion)
            holder.connection.apply {
                visibility = View.VISIBLE
                adapter = mAdapter
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            }
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val userImage: CircleImageView = itemView.findViewById(R.id.profile_image)
        val userName: TextView = itemView.findViewById(R.id.profile_name)
        val text: TextView = itemView.findViewById(R.id.text_timeline)
        val image: ImageView = itemView.findViewById(R.id.image)
        val likeCount: TextView = itemView.findViewById(R.id.like_count)
        val commectCount: TextView = itemView.findViewById(R.id.comment_count)
        val connection: RecyclerView = itemView.findViewById(R.id.list_connection)
        val group: Group = itemView.findViewById(R.id.group)
        val time: TextView = itemView.findViewById(R.id.time_timeline)
    }
}