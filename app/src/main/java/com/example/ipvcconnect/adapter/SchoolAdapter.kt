package com.example.ipvcconnect.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ipvcconnect.R
import com.example.ipvcconnect.models.School

class SchoolAdapter(private val schoolList: List<School>) : RecyclerView.Adapter<SchoolAdapter.SchoolViewHolder>() {

    // Define o ViewHolder para a RecyclerView
    class SchoolViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val schoolLogo: ImageView = itemView.findViewById(R.id.schoolLogo)
        val schoolName: TextView = itemView.findViewById(R.id.schoolName)
        val schoolDescription: TextView = itemView.findViewById(R.id.schoolDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SchoolViewHolder {
        // Inflando o layout do item para o ViewHolder
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item_escolas, parent, false)
        return SchoolViewHolder(view)
    }

    override fun onBindViewHolder(holder: SchoolViewHolder, position: Int) {
        // Vincula os dados do usuário aos elementos da UI no ViewHolder
        val school = schoolList[position]
        //holder.schoolLogo
        holder.schoolName.text = school.name
        holder.schoolDescription.text = school.description
    }

    override fun getItemCount(): Int {
        return schoolList.size
    }
}