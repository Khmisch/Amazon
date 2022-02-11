package com.example.amazon.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.amazon.R
import com.example.amazon.model.Essentail

class EssentialAdapter(var context: Context, var items:ArrayList<Essentail>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_feed_essentials, parent, false)
        return EssentailViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]

        if (holder is EssentailViewHolder){
            var tv_title = holder.tv_title
            var iv_image = holder.iv_image

            iv_image.setImageResource(item.image)
            tv_title.setText(item.title)
        }
    }

    class EssentailViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var iv_image : ImageView = view.findViewById(R.id.iv_image)
        var tv_title : TextView = view.findViewById(R.id.tv_title)

    }


}