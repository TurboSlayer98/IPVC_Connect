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
        val companiesName: TextView = itemView.findViewById(R.id.textView_name)
        val companiesDescription: TextView = itemView.findViewById(R.id.textView_description)
        val companiesAddress: TextView = itemView.findViewById(R.id.textView_address)
        val companiesPlacements: TextView = itemView.findViewById(R.id.textView_placements)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompaniesViewHolder {
        // Inflando o layout do item para o ViewHolder
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item_companies, parent, false)
        return CompaniesViewHolder(view)
    }

    override fun onBindViewHolder(holder: CompaniesViewHolder, position: Int) {
        if (companiesList.isEmpty()) {
            // Handle empty list case
            holder.itemView.visibility = View.GONE
        } else {
            // Existing binding logic
            val company = companiesList[position]
            holder.companiesName.text = company.name
            holder.companiesDescription.text = company.description
            holder.companiesAddress.text = company.address
            holder.companiesPlacements.text = "Available: ${company.placements_available} | Ocupied: ${company.placements_ocupied}"
            holder.itemView.visibility = View.VISIBLE
        }

        // Set click listener for the entire item
        holder.itemView.setOnClickListener {
            // Handle company click
            val intent = Intent(holder.itemView.context, CompaniesInfoActivity::class.java)
            intent.putExtra("COMPANY_ID", companiesList[position].id)
            intent.putExtra("COMPANY_NAME", companiesList[position].name)
            intent.putExtra("COMPANY_ADDRESS", companiesList[position].address)
            intent.putExtra("COMPANY_DESCRIPTION", companiesList[position].description)
            intent.putExtra("COMPANY_AVAILABLE", companiesList[position].placements_available)
            intent.putExtra("COMPANY_OCUPIED", companiesList[position].placements_ocupied)
            intent.putExtra("COMPANY_PHONE", companiesList[position].phone)
            intent.putExtra("COMPANY_EMAIL", companiesList[position].email)
            intent.putExtra("COMPANY_WEB", companiesList[position].website)
            intent.putExtra("COMPANY_LAT", companiesList[position].latitude)
            intent.putExtra("COMPANY_LNG", companiesList[position].longitude)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return companiesList.size
    }
}