package com.daovuu97.layoutpractice.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.graphics.drawable.LayerDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.Group
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.daovuu97.layoutpractice.model.Status
import de.hdodenhof.circleimageview.CircleImageView
import java.text.DateFormat
import java.text.SimpleDateFormat


class TimelineAdapter(
    private val context: Context,
    private val listStatus: List<Status>
) : RecyclerView.Adapter<TimelineAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(com.daovuu97.layoutpractice.R.layout.timeline_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listStatus.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentStatus: Status = listStatus[position]
        updateView(holder, currentStatus)

        if (position == 0) {
            holder.beforeDot.visibility = View.GONE

        } else {
            holder.beforeDot.visibility = View.VISIBLE
            holder.beforeDot.setBackgroundResource(listStatus[position - 1].color)
        }
        val color = ColorDrawable(context.resources.getColor(currentStatus.color))
        val image = context.resources.getDrawable(com.daovuu97.layoutpractice.R.drawable.dot_background)
        val ld = LayerDrawable(arrayOf<Drawable>(color, image))

        holder.dot.setImageDrawable(ld)
        holder.afterDot.setBackgroundResource(currentStatus.color)
    }

    @SuppressLint("SetTextI18n", "SimpleDateFormat")
    private fun updateView(holder: ViewHolder, status: Status) {
        Glide.with(context)
            .load(status.userImage)
            .override(200, 200)
            .centerCrop()
            .into(holder.userImage)
        holder.userName.text = status.userName
        val format: DateFormat = SimpleDateFormat("H:mm")
        val time = format.format(System.currentTimeMillis() - status.time)
        holder.time.text = "$time ago"
        if (status.listConnecttion == null) {
            if (status.text == "") holder.text.visibility = View.GONE
            else {
                holder.text.visibility = View.VISIBLE
                holder.text.text = status.text
                holder.connection.visibility = View.GONE
                holder.likeCount.text = status.like
                holder.commentCount.text = status.comment
            }

            if (status.image.isEmpty() || status.image.isBlank()) holder.image.visibility = View.GONE
            else {
                holder.image.visibility = View.VISIBLE
                Glide.with(context)
                    .load(status.image)
                    .centerCrop()
                    .into(holder.image)
                holder.connection.visibility = View.GONE
                holder.likeCount.text = status.like
                holder.commentCount.text = status.comment
            }
        } else {
            holder.text.visibility = View.VISIBLE
            holder.image.visibility = View.GONE
            holder.group.visibility = View.GONE
            holder.text.text = status.text
            val mAdapter = ListUserAdapter(context, status.listConnecttion)
            holder.connection.apply {
                visibility = View.VISIBLE
                adapter = mAdapter
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            }
        }

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val userImage: CircleImageView = itemView.findViewById(com.daovuu97.layoutpractice.R.id.profile_image)
        val userName: TextView = itemView.findViewById(com.daovuu97.layoutpractice.R.id.profile_name)
        val text: TextView = itemView.findViewById(com.daovuu97.layoutpractice.R.id.text_timeline)
        val image: ImageView = itemView.findViewById(com.daovuu97.layoutpractice.R.id.image)
        val likeCount: TextView = itemView.findViewById(com.daovuu97.layoutpractice.R.id.like_count)
        val commentCount: TextView = itemView.findViewById(com.daovuu97.layoutpractice.R.id.comment_count)
        val connection: RecyclerView = itemView.findViewById(com.daovuu97.layoutpractice.R.id.list_connection)
        val group: Group = itemView.findViewById(com.daovuu97.layoutpractice.R.id.group)
        val time: TextView = itemView.findViewById(com.daovuu97.layoutpractice.R.id.time_timeline)
        val beforeDot: View = itemView.findViewById(com.daovuu97.layoutpractice.R.id.before_dot)
        val afterDot: View = itemView.findViewById(com.daovuu97.layoutpractice.R.id.after_dot)
        val dot: CircleImageView = itemView.findViewById(com.daovuu97.layoutpractice.R.id.dot)
    }
}