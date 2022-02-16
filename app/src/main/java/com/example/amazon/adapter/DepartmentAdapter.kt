package com.example.amazon.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.amazon.R
import com.example.amazon.model.Department

class DepartmentAdapter(var context: Context, var items: ArrayList<Department>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_department, parent, false)
        return DepartmentViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is DepartmentViewHolder) {
            holder.bind(items[position])
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class DepartmentViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
        fun bind(item: Department) {
            val image: ImageView = view.findViewById(R.id.iv_image)
            val title: TextView = view.findViewById(R.id.tv_title)

            image.setImageResource(item.image)
            title.text = item.title
        }
    }

}