package com.example.amazon.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.amazon.R
import com.example.amazon.adapter.DepartmentAdapter
import com.example.amazon.adapter.EssentialAdapter
import com.example.amazon.model.Department
import com.example.amazon.model.Essentail
import com.example.amazonui.adapter.SellerBookAdapter
import com.example.amazonui.adapter.TabletAdapter
import com.example.amazonui.model.SellerBook
import com.example.amazonui.model.Tablets
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    lateinit var rv_essentials: RecyclerView
    lateinit var ll_fashion: LinearLayout
    lateinit var ll_popular: LinearLayout
    lateinit var rvSellerBook: RecyclerView
    lateinit var rvDepartment: RecyclerView
    lateinit var rvTablets: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews() {
        rv_essentials = findViewById(R.id.rv_essential)
        ll_fashion = findViewById(R.id.ll_fashion)
        ll_popular = findViewById(R.id.ll_popular)
        rvSellerBook = findViewById(R.id.rv_sellersBook)
        rvDepartment = findViewById(R.id.rv_department)
        rvTablets = findViewById(R.id.rv_tablets)

        rv_essentials.setLayoutManager(LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false))
        rvSellerBook.layoutManager = LinearLayoutManager(this)
        rvDepartment.layoutManager = GridLayoutManager(this, 2)
        rvTablets.layoutManager = GridLayoutManager(this, 2)



        refreshAdapter(getEssentials())
        refreshSellerBookAdapter(getSellerBookList())
        refreshDepartmentAdapter(getDepartmentList())
        refreshTabletsAdapter(getTabletList())

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

    private fun refreshSellerBookAdapter(items: ArrayList<SellerBook>) {
        val adapter = SellerBookAdapter(this, items)
        rvSellerBook.adapter = adapter
    }

    private fun refreshDepartmentAdapter(items: ArrayList<Department>) {
        val adapter = DepartmentAdapter(this, items)
        rvDepartment.adapter = adapter
    }

    private fun refreshTabletsAdapter(items: ArrayList<Tablets>) {
        val adapter = TabletAdapter(this, items)
        rvTablets.adapter = adapter
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

    private fun getSellerBookList(): ArrayList<SellerBook> {
        val items: ArrayList<SellerBook> = ArrayList()

        items.add(SellerBook(R.drawable.book1, "The Very Hungry Caterpillar", 5.06, 0.00))
        items.add(SellerBook(R.drawable.book2, "If Animals Kissed Good Night", 3.55, 7.99))
        items.add(SellerBook(R.drawable.book3, "Chicka Chicka Boom Boom (Board Book)", 4.59, 7.99))

        return items
    }

    private fun getDepartmentList(): ArrayList<Department> {
        val items: ArrayList<Department> = ArrayList()

        items.add(Department("Beauty", R.drawable.department1))
        items.add(Department("Home and Kitchen", R.drawable.department2))
        items.add(Department("Sports and Outdoors", R.drawable.department3))
        items.add(Department("Electronics", R.drawable.department4))
        items.add(Department("Outdoor Clothing", R.drawable.department5))
        items.add(Department("Pet Supplies", R.drawable.department6))

        return items
    }

    private fun getTabletList(): ArrayList<Tablets> {
        var tablets: ArrayList<Tablets> = ArrayList()

        for (i in 1..4) {
            tablets.add(Tablets(R.drawable.tablet))
        }
        return tablets
    }
}