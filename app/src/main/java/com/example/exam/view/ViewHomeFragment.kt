package com.example.exam.view

import android.content.Context
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.exam.adapters.categoryAdapter.RecyclerCategoryAdapter
import com.example.exam.adapters.productAdapter.RecyclerProductAdapter
import com.example.exam.adapters.recylerModel.CategoryModel
import com.example.exam.adapters.recylerModel.ProductModel
import com.example.exam.databinding.HomeFragmentBinding
import com.example.exam.ext.ActivityUtils

class ViewHomeFragment(contextInstance: Context,private val activityUtils: ActivityUtils)
    : FrameLayout(contextInstance) {
    val binding = HomeFragmentBinding.inflate(LayoutInflater.from(context))
    private lateinit var adapter: RecyclerProductAdapter

    fun initRecycler(data: ArrayList<CategoryModel>) {
        binding.recyclerView.layoutManager =
            LinearLayoutManager(context, RecyclerView.HORIZONTAL, true)

        val adapter = RecyclerCategoryAdapter(data,activityUtils,context)
        binding.recyclerView.adapter = adapter
    }

    fun initRecyclerProduct(data: ArrayList<ProductModel>) {
        binding.recyclerProduct.layoutManager =
            LinearLayoutManager(context, RecyclerView.HORIZONTAL, true)
        adapter = RecyclerProductAdapter(data,activityUtils,context)
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filter.filter(newText)
                return true
            }
        })
        binding.recyclerProduct.adapter = adapter
    }




}