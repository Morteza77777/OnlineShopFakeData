package com.example.exam.view

import android.content.Context
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import com.example.exam.adapters.productAdapter.RecyclerProductAdapter
import com.example.exam.adapters.recylerModel.ProductModel
import com.example.exam.databinding.CategoryMenFragmentBinding
import com.example.exam.ext.ActivityUtils

class ViewCategoryMenFragment(contextInstance: Context,val activityUtils: ActivityUtils)
    : FrameLayout(contextInstance) {

    val binding = CategoryMenFragmentBinding.inflate(LayoutInflater.from(context))

    fun initRecycler(data : ArrayList<ProductModel> ){
        val adapter = RecyclerProductAdapter(data,activityUtils,context)
        binding.recyclerView.layoutManager = GridLayoutManager(context,2)
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

}