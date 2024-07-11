package com.example.exam.adapters.basketAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.exam.databinding.RecyclerBasketItemBinding
import com.example.exam.db.entity.BasketEntity

class RecyclerBasketAdapter(
    private val data: List<BasketEntity>
) : RecyclerView.Adapter<RecyclerBasketAdapter.BasketViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        BasketViewHolder(
            RecyclerBasketItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )




    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: BasketViewHolder, position: Int) {
        holder.setData(data[position])
    }

    inner class BasketViewHolder(
        private val binding: RecyclerBasketItemBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun setData(data: BasketEntity) {
            binding.imageView27.setImageResource(data.image)
            binding.txtPrice.text = data.price
            binding.txtName.text = data.name

        }

    }
}