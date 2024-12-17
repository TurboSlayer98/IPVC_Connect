package com.example.ipvcconnect.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ipvcconnect.CompaniesActivity
import com.example.ipvcconnect.R
import com.example.ipvcconnect.models.Course

class CourseAdapter(private val courseList: List<Course>) : RecyclerView.Adapter<CourseAdapter.CourseViewHolder>() {

    // Define o ViewHolder para a RecyclerView
    class CourseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val courseName: TextView = itemView.findViewById(R.id.textView_name)
        val courseDescription: TextView = itemView.findViewById(R.id.textView_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        // Inflando o layout do item para o ViewHolder
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item_courses, parent, false)
        return CourseViewHolder(view)
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        // Vincula os dados do usuário aos elementos da UI no ViewHolder
        val course = courseList[position]
        //holder.schoolLogo
        holder.courseName.text = course.name
        holder.courseDescription.text = course.description

        // Set click listener for the entire item
        holder.itemView.setOnClickListener {
            // Handle school click
            val intent = Intent(holder.itemView.context, CompaniesActivity::class.java)
            intent.putExtra("COURSE_ID", course.id)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return courseList.size
    }
}