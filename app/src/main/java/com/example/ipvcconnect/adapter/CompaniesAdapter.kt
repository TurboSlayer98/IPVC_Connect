package com.example.ipvcconnect.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ipvcconnect.R
import com.example.ipvcconnect.models.Company

class CompaniesAdapter(private val companiesList: List<Company>) : RecyclerView.Adapter<CompaniesAdapter.CompaniesViewHolder>() {

    // Define o ViewHolder para a RecyclerView
    class CompaniesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //val companiesName: TextView = itemView.findViewById(R.id.schoolName)
        //val companiesDescription: TextView = itemView.findViewById(R.id.schoolDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompaniesViewHolder {
        // Inflando o layout do item para o ViewHolder
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item_empresas, parent, false)
        return CompaniesViewHolder(view)
    }

    override fun onBindViewHolder(holder: CompaniesViewHolder, position: Int) {
        // Vincula os dados do usuário aos elementos da UI no ViewHolder
        val companies = companiesList[position]
        //holder.companiesLogo
        //holder.companiesName.text = companies.name
        //holder.companiesDescription.text = companies.description
    }

    override fun getItemCount(): Int {
        return companiesList.size
    }
}