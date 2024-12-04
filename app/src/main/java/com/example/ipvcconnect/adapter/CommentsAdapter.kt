package com.example.ipvcconnect.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ipvcconnect.R
import com.example.ipvcconnect.models.Comment

class CommentsAdapter(private val comentarios: List<Comment>) :
    RecyclerView.Adapter<CommentsAdapter.ComentarioViewHolder>() {

    class ComentarioViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val user: TextView = itemView.findViewById(R.id.comentarioUsuario)
        val text: TextView = itemView.findViewById(R.id.comentarioTexto)
        val date: TextView = itemView.findViewById(R.id.comentarioData)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComentarioViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_comentario, parent, false)
        return ComentarioViewHolder(view)
    }

    override fun onBindViewHolder(holder: ComentarioViewHolder, position: Int) {
        val comentario = comentarios[position]
        holder.user.text = comentario.user
        holder.text.text = comentario.text
        holder.date.text = comentario.date
    }

    override fun getItemCount() = comentarios.size
} 