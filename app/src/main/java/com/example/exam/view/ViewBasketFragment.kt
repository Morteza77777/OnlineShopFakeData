package com.example.exam.view

import android.content.Context
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.exam.adapters.basketAdapter.RecyclerBasketAdapter
import com.example.exam.adapters.categoryAdapter.RecyclerCategoryAdapter
import com.example.exam.adapters.recylerModel.CategoryModel
import com.example.exam.databinding.BasketFragmentBinding
import com.example.exam.db.entity.BasketEntity

class ViewBasketFragment(contextInstance: Context)
    : FrameLayout(contextInstance) {
    val binding = BasketFragmentBinding.inflate(LayoutInflater.from(context))

    fun initRecycler(data: List<BasketEntity>) {
        binding.recyclerView.layoutManager =
            LinearLayoutManager(context, RecyclerView.VERTICAL, true)

        val adapter = RecyclerBasketAdapter(data)
        binding.recyclerView.adapter = adapter
    }
}