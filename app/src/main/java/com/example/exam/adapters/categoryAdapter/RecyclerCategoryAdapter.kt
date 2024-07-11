package com.example.exam.adapters.categoryAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.exam.adapters.recylerModel.CategoryModel
import com.example.exam.databinding.RecyclerCategoryItemBinding
import com.example.exam.ext.ActivityUtils
import com.example.exam.fragments.CategoryProductFragment

class RecyclerCategoryAdapter(
    private val dataCategory: ArrayList<CategoryModel>,
    val activityUtils: ActivityUtils,
    val context: Context
) : RecyclerView.Adapter<RecyclerCategoryAdapter.CategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CategoryViewHolder(
            RecyclerCategoryItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount() = dataCategory.size

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.setData(dataCategory[position])
    }

    inner class CategoryViewHolder(
        private val binding: RecyclerCategoryItemBinding
    ) : ViewHolder(binding.root) {

        fun setData(data: CategoryModel) {
            binding.root.setOnClickListener {
                activityUtils.setFragment(CategoryProductFragment())

            }
            binding.txtTitle.text = data.title
            binding.img.setImageResource(data.image)
        }

    }
}