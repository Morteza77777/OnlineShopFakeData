package com.example.exam.view

import android.content.Context
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.exam.adapters.productAdapter.RecyclerProductAdapter
import com.example.exam.adapters.recylerModel.ProductModel
import com.example.exam.databinding.CategoryProductFragmentBinding
import com.example.exam.ext.ActivityUtils
import com.example.exam.fragments.CategoryMenFragment

class ViewCategoryProductFragment(val contextInstance: Context,val activityUtils: ActivityUtils)
    : FrameLayout(contextInstance)
 {

    val binding = CategoryProductFragmentBinding.inflate(LayoutInflater.from(context))


    fun initRecycler(data: ArrayList<ProductModel>) {
        binding.recyclerView.layoutManager = LinearLayoutManager(
            context,
            RecyclerView.HORIZONTAL,
            true
        )
        val adapter = RecyclerProductAdapter(data,activityUtils,context)

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filter.filter(newText)
                return true
            }
        })
        binding.recyclerView.adapter = adapter
    }


    fun setMenFragment() {
        binding.viewProduct1.setOnClickListener {
            activityUtils.setFragment(CategoryMenFragment())
        }


    }

}