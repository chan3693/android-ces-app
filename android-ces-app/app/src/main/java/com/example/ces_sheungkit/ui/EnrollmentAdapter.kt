package com.example.ces_sheungkit.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ces_sheungkit.R
import com.example.ces_sheungkit.models.EnrollmentItem

class EnrollmentAdapter(
    var yourListData:List<EnrollmentItem>
) : RecyclerView.Adapter<EnrollmentAdapter.EnrollmentViewHolder>() {

    inner class EnrollmentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EnrollmentViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_layout, parent, false)

        return EnrollmentViewHolder(view)
    }

    override fun getItemCount(): Int {
        return yourListData.size
    }

    override fun onBindViewHolder(holder: EnrollmentViewHolder, position: Int) {
        val currItem: EnrollmentItem = yourListData.get(position)

        val tvStudentName = holder.itemView.findViewById<TextView>(R.id.tvStudentName)
        tvStudentName.text = currItem.studentName

        val tvClassName = holder.itemView.findViewById<TextView>(R.id.tvClassName)
        tvClassName.text = currItem.className
    }
}