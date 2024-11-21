package com.example.ipvcconnect

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ComentariosAdapter(private val comentarios: List<Comentario>) : 
    RecyclerView.Adapter<ComentariosAdapter.ComentarioViewHolder>() {

    class ComentarioViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val usuario: TextView = itemView.findViewById(R.id.comentarioUsuario)
        val texto: TextView = itemView.findViewById(R.id.comentarioTexto)
        val data: TextView = itemView.findViewById(R.id.comentarioData)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComentarioViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_comentario, parent, false)
        return ComentarioViewHolder(view)
    }

    override fun onBindViewHolder(holder: ComentarioViewHolder, position: Int) {
        val comentario = comentarios[position]
        holder.usuario.text = comentario.usuario
        holder.texto.text = comentario.texto
        holder.data.text = comentario.data
    }

    override fun getItemCount() = comentarios.size
} 