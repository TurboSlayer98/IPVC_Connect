package com.example.ipvcconnect.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ipvcconnect.CoursesActivity
import com.example.ipvcconnect.R
import com.example.ipvcconnect.models.School

class SchoolAdapter(
    private val schoolList: List<School>) : RecyclerView.Adapter<SchoolAdapter.SchoolViewHolder>() {

    // Define o ViewHolder para a RecyclerView
    class SchoolViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val schoolName: TextView = itemView.findViewById(R.id.textView_name)
        val schoolDescription: TextView = itemView.findViewById(R.id.textView_description)
        val schoolLogo: ImageView = itemView.findViewById(R.id.imageView_logo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SchoolViewHolder {
        // Inflando o layout do item para o ViewHolder
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item_schools, parent, false)
        return SchoolViewHolder(view)
    }

    override fun onBindViewHolder(holder: SchoolViewHolder, position: Int) {
        // Vincula os dados da escola aos elementos da UI no ViewHolder
        val school = schoolList[position]
        holder.schoolName.text = school.name
        holder.schoolDescription.text = school.description
        
        // Load the logo using Glide
        Glide.with(holder.itemView.context)
            .load(school.logoUrl)
            .into(holder.schoolLogo)
        
        // Set click listener for the entire item
        holder.itemView.setOnClickListener {
            // Handle school click
            val intent = Intent(holder.itemView.context, CoursesActivity::class.java)
            intent.putExtra("SCHOOL_ID", school.id)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return schoolList.size
    }
}