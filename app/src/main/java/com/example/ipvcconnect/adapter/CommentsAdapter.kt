package com.example.ipvcconnect.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.ipvcconnect.R
import com.example.ipvcconnect.models.Comment

class CommentsAdapter: ListAdapter<Comment, CommentsAdapter.CommentViewHolder>(CommentsDiffCallback()) {

    class CommentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val user: TextView = itemView.findViewById(R.id.textView_user)
        val text: TextView = itemView.findViewById(R.id.textView_text)
        val date: TextView = itemView.findViewById(R.id.textView_date)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item_comments, parent, false)
        return CommentViewHolder(view)
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        val comment = getItem(position)
        holder.user.text = comment.user
        holder.text.text = comment.text
        holder.date.text = comment.date
    }

    class CommentsDiffCallback : DiffUtil.ItemCallback<Comment>() {
        override fun areItemsTheSame(oldItem: Comment, newItem: Comment): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Comment, newItem: Comment): Boolean {
            return oldItem == newItem
        }
    }
}