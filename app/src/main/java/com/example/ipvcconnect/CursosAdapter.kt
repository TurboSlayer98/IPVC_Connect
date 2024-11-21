package com.example.ipvcconnect

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CursosAdapter(private val cursos: List<Curso>) : 
    RecyclerView.Adapter<CursosAdapter.CursoViewHolder>() {

    class CursoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nome: TextView = itemView.findViewById(R.id.cursoNome)
        val descricao: TextView = itemView.findViewById(R.id.cursoDescricao)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CursoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_item_cursos, parent, false)
        return CursoViewHolder(view)
    }

    override fun onBindViewHolder(holder: CursoViewHolder, position: Int) {
        val curso = cursos[position]
        holder.nome.text = curso.nome
        holder.descricao.text = curso.descricao

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, EmpresasActivity::class.java)
            intent.putExtra("CURSO_NOME", curso.nome)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount() = cursos.size
} 