package com.example.ipvcconnect

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EmpresasAdapter(private val empresas: List<Empresa>) : 
    RecyclerView.Adapter<EmpresasAdapter.EmpresaViewHolder>() {

    class EmpresaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nome: TextView = itemView.findViewById(R.id.empresaNome)
        val descricao: TextView = itemView.findViewById(R.id.empresaDescricao)
        val localizacao: TextView = itemView.findViewById(R.id.empresaLocalizacao)
        val vagas: TextView = itemView.findViewById(R.id.empresaVagas)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmpresaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_item_empresas, parent, false)
        return EmpresaViewHolder(view)
    }

    override fun onBindViewHolder(holder: EmpresaViewHolder, position: Int) {
        val empresa = empresas[position]
        holder.nome.text = empresa.nome
        holder.descricao.text = empresa.descricao
        holder.localizacao.text = empresa.localizacao
        holder.vagas.text = "Vagas disponíveis: ${empresa.vagasDisponiveis} | Ocupadas: ${empresa.vagasOcupadas}"

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, InfoEmpresaActivity::class.java)
            intent.putExtra("EMPRESA_NOME", empresa.nome)
            intent.putExtra("EMPRESA_MORADA", empresa.morada)
            intent.putExtra("EMPRESA_TELEFONE", empresa.telefone)
            intent.putExtra("EMPRESA_EMAIL", empresa.email)
            intent.putExtra("EMPRESA_LAT", empresa.latitude)
            intent.putExtra("EMPRESA_LNG", empresa.longitude)
            intent.putExtra("VAGAS_DISPONIVEIS", empresa.vagasDisponiveis)
            intent.putExtra("VAGAS_OCUPADAS", empresa.vagasOcupadas)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount() = empresas.size
} 