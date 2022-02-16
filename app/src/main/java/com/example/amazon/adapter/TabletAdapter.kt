package com.example.amazonui.adapter

import android.content.Context
import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TableLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.amazon.R
import com.example.amazonui.model.Tablets

class TabletAdapter(var context: Context, var items: ArrayList<Tablets>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val viewLL = LayoutInflater.from(context).inflate(R.layout.item_tablet, parent, false)

        viewLL.viewTreeObserver.addOnGlobalLayoutListener {
            val side = viewLL.measuredWidth // get Item`s fixWidth

            val params = viewLL.layoutParams
            params.height = side
            params.width = side
            viewLL.layoutParams = params
        }

        val viewConstraint =
            LayoutInflater.from(context).inflate(R.layout.item_tablet_two_square_ll, parent, false)

        return TabletViewHolder(viewConstraint)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is TabletViewHolder) {
            holder.bind(items[position])
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }


    inner class TabletViewHolder(var view: View) : RecyclerView.ViewHolder(view) {

        fun bind(item: Tablets) {
            val image: ImageView = view.findViewById(R.id.iv_image)

            image.setImageResource(item.image)

        }
    }

}