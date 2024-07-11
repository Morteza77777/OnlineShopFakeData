package com.example.exam.view

import android.content.Context
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.recyclerview.widget.GridLayoutManager
import com.example.exam.adapters.categoryAdapter.RecyclerCategoryAdapter
import com.example.exam.adapters.recylerModel.CategoryModel
import com.example.exam.databinding.CategoryFragmentBinding
import com.example.exam.ext.ActivityUtils

class ViewCategoryFragment(contextInstance: Context,val activityUtils: ActivityUtils)
    : FrameLayout(contextInstance) {

    val binding = CategoryFragmentBinding.inflate(LayoutInflater.from(context))

    fun initRecycler(data : ArrayList<CategoryModel>){
        binding.recyclerView.layoutManager = GridLayoutManager(context,3)
        val adapter = RecyclerCategoryAdapter(data,activityUtils,context)
        binding.recyclerView.adapter = adapter

    }

}