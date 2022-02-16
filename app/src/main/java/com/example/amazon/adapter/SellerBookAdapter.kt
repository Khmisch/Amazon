package com.example.amazonui.adapter

import android.content.Context
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.amazon.R
import com.example.amazonui.model.SellerBook

class SellerBookAdapter(var context: Context, var items: ArrayList<SellerBook>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_seller_book, parent, false)
        return BookViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is BookViewHolder) {
            holder.bind(items[position])
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class BookViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
        fun bind(item: SellerBook) {
            val image: ImageView = view.findViewById(R.id.iv_image)
            val title: TextView = view.findViewById(R.id.tv_title)
            val price: TextView = view.findViewById(R.id.tv_price)
            val lastPrice: TextView = view.findViewById(R.id.tv_lastPrice)

            image.setImageResource(item.image)
            title.text = item.title
            val aaa = "$${item.price}"
            price.text = aaa

            if (item.lastPrice > 0) {
                val bbb = "$${item.lastPrice.toString()}"
                lastPrice.text = bbb
                lastPrice.paintFlags = (Paint.STRIKE_THRU_TEXT_FLAG)
                lastPrice.visibility = View.VISIBLE
            } else {
                lastPrice.visibility = View.GONE
            }
        }
    }

}