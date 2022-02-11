package com.example.amazon.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.amazon.R
import com.example.amazon.adapter.EssentialAdapter
import com.example.amazon.model.Essentail
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    lateinit var rv_essentials: RecyclerView
    lateinit var ll_fashion: LinearLayout
    lateinit var ll_popular: LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews() {
        rv_essentials = findViewById(R.id.rv_essential)
        ll_fashion = findViewById(R.id.ll_fashion)
        ll_popular = findViewById(R.id.ll_popular)

        val manager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rv_essentials.setLayoutManager(manager)

        refreshAdapter(getEssentials())

        setLinearHeight(ll_fashion)
        setLinearHeight(ll_popular)
    }

    private fun setLinearHeight(layout: LinearLayout) {
        //Get screen width programmatically
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        var widthPixels = displayMetrics.widthPixels

        //Set layout width programmatically
        val params: ViewGroup.LayoutParams = layout.layoutParams
        params.height = widthPixels
        layout.layoutParams = params

    }

    private fun refreshAdapter(items: ArrayList<Essentail>) {
        val adapter = EssentialAdapter(this, items)
        rv_essentials!!.adapter = adapter
    }

    private fun getEssentials(): ArrayList<Essentail> {

        val items:ArrayList<Essentail> = ArrayList<Essentail>()
        items.add(Essentail("Oculus", R.drawable.im_oculus))
        items.add(Essentail("Gaming", R.drawable.im_gamer))
        items.add(Essentail("Oculus", R.drawable.im_oculus))
        items.add(Essentail("Gaming", R.drawable.im_gamer))

        return items
    }
}