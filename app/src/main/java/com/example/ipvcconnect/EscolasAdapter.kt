package com.example.ipvcconnect

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EscolasAdapter(private val escolas: List<Escola>) : 
    RecyclerView.Adapter<EscolasAdapter.EscolaViewHolder>() {

    class EscolaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nome: TextView = itemView.findViewById(R.id.schoolName)
        val descricao: TextView = itemView.findViewById(R.id.escolaDescricao)
        val logo: ImageView = itemView.findViewById(R.id.escolaLogo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EscolaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_item_escolas, parent, false)
        return EscolaViewHolder(view)
    }

    override fun onBindViewHolder(holder: EscolaViewHolder, position: Int) {
        val escola = escolas[position]
        holder.nome.text = escola.nome
        holder.descricao.text = escola.descricao
        holder.logo.setImageResource(escola.imageResource)
        
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, CursosActivity::class.java)
            intent.putExtra("ESCOLA_NOME", escola.nome)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount() = escolas.size
} 