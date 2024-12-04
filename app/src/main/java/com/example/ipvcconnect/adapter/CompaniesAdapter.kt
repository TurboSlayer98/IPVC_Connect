package com.example.ipvcconnect.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ipvcconnect.CompaniesInfoActivity
import com.example.ipvcconnect.R
import com.example.ipvcconnect.models.Company

class CompaniesAdapter(private val companiesList: List<Company>) : RecyclerView.Adapter<CompaniesAdapter.CompaniesViewHolder>() {

    // Define o ViewHolder para a RecyclerView
    class CompaniesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val companiesName: TextView = itemView.findViewById(R.id.empresaNome)
        val companiesDescription: TextView = itemView.findViewById(R.id.empresaDescricao)
        val companiesAddress: TextView = itemView.findViewById(R.id.empresaLocalizacao)
        val caompaniesPlacements: TextView = itemView.findViewById(R.id.empresaVagas)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompaniesViewHolder {
        // Inflando o layout do item para o ViewHolder
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item_empresas, parent, false)
        return CompaniesViewHolder(view)
    }

    override fun onBindViewHolder(holder: CompaniesViewHolder, position: Int) {
        // Vincula os dados do usuário aos elementos da UI no ViewHolder
        val companies = companiesList[position]
        holder.companiesName.text = companies.name
        holder.companiesDescription.text = companies.description
        holder.companiesAddress.text = companies.address
        holder.caompaniesPlacements.text = "Vagas disponíveis: ${companies.placements_available} | Ocupadas: ${companies.placements_ocupied}"

        // Set click listener for the entire item
        holder.itemView.setOnClickListener {
            // Handle school click
            val intent = Intent(holder.itemView.context, CompaniesInfoActivity::class.java)
            intent.putExtra("COMPANY_ID", companies.id)
            intent.putExtra("EMPRESA_LAT", companies.latitude)
            intent.putExtra("EMPRESA_LNG", companies.longitude)
            intent.putExtra("COMPANY_PHONE", companies.phone)
            intent.putExtra("COMPANY_EMAIL", companies.email)
            intent.putExtra("COMPANY_WEB", companies.website)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return companiesList.size
    }
}