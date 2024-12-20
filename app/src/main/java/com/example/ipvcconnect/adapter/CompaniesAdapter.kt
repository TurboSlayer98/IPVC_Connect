package com.example.ipvcconnect.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
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
        val buttonFav: ImageButton = itemView.findViewById(R.id.buttonFav)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompaniesViewHolder {
        // Inflando o layout do item para o ViewHolder
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item_companies, parent, false)
        return CompaniesViewHolder(view)
    }

    override fun onBindViewHolder(holder: CompaniesViewHolder, position: Int) {
        // Vincula os dados do usuário aos elementos da UI no ViewHolder
        val company = companiesList[position]
        holder.companiesName.text = company.name
        holder.companiesDescription.text = company.description
        holder.companiesAddress.text = company.address
        holder.companiesPlacements.text = "Available: " + company.placements_available.toString() + " | " + "Ocupied: " + company.placements_ocupied.toString()

        // Set click listener for the entire item
        holder.itemView.setOnClickListener {
            // Handle school click
            val intent = Intent(holder.itemView.context, CompaniesInfoActivity::class.java)
            intent.putExtra("COMPANY_ID", company.id)
            intent.putExtra("COMPANY_NAME", company.name)
            intent.putExtra("COMPANY_ADDRESS", company.address)
            intent.putExtra("COMPANY_DESCRIPTION", company.description)
            intent.putExtra("COMPANY_AVAILABLE", company.placements_available)
            intent.putExtra("COMPANY_OCUPIED", company.placements_ocupied)
            intent.putExtra("COMPANY_PHONE", company.phone)
            intent.putExtra("COMPANY_EMAIL", company.email)
            intent.putExtra("COMPANY_WEB", company.website)
            intent.putExtra("COMPANY_LAT", company.latitude)
            intent.putExtra("COMPANY_LNG", company.longitude)
            holder.itemView.context.startActivity(intent)
        }

        holder.buttonFav.setOnClickListener{

        }
    }

    override fun getItemCount(): Int {
        return companiesList.size
    }
}