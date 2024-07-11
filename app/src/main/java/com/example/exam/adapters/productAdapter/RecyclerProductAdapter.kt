package com.example.exam.adapters.productAdapter

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.Filter
import android.widget.Filterable
import android.widget.Toast
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.exam.adapters.recylerModel.ProductModel
import com.example.exam.databinding.DialogueOrderBinding
import com.example.exam.databinding.RecyclerProductItemBinding
import com.example.exam.db.dao.BasketEntityRepository
import com.example.exam.db.entity.BasketEntity
import com.example.exam.ext.ActivityUtils
import com.example.exam.fragments.BasketFragment
import com.example.exam.fragments.ProductFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RecyclerProductAdapter(
    private val dataProduct: ArrayList<ProductModel>,
    val activityUtils: ActivityUtils,
    val context: Context,
) : RecyclerView.Adapter<RecyclerProductAdapter.ProductViewHolder>(), Filterable {

    private val allProducts = ArrayList<ProductModel>()
    private val repository = BasketEntityRepository(context)

    init {
        allProducts.addAll(dataProduct)
    }

    inner class ProductViewHolder(
        private val binding: RecyclerProductItemBinding
    ) : ViewHolder(binding.root) {
        fun setData(data: ProductModel) {
            binding.imageView15.setImageResource(data.image)
            binding.textView12.text = data.title
            binding.txtPrice.text = data.price
            binding.imageView15.setOnClickListener {
                val bundle = Bundle()
                bundle.putString("title", data.title)
                bundle.putInt("img", data.image)
                val fragment = ProductFragment()
                fragment.arguments = bundle
                activityUtils.setFragment(fragment)
            }

            val binding1 = DialogueOrderBinding.inflate(LayoutInflater.from(context))
            binding1.textView34.text = data.price
            var count = 0
            binding1.Add.setOnClickListener {
                binding1.txtNumber.text = count++.toString()
            }
            binding1.Minus.setOnClickListener {
                if (count > 0)
                    binding1.txtNumber.text = count--.toString()
            }

            val alert = Dialog(context)
            alert.setContentView(binding1.root)
            alert.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            val window = alert.window
            val layoutParams = window?.attributes
            layoutParams?.y = 100
            layoutParams?.gravity = Gravity.BOTTOM

            binding.button.setOnClickListener {
                alert.show()
            }

            binding1.button3.setOnClickListener {
                CoroutineScope(Dispatchers.IO).launch {
                    if (!repository.exists(data.title)) {
                        repository.add(
                            BasketEntity(data.image, data.title, data.price)
                        )
                    } else {
                        withContext(Dispatchers.Main) {
                            Toast.makeText(context, "Item already exists in the basket", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
                alert.dismiss()
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ProductViewHolder(
            RecyclerProductItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount() = dataProduct.size

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.setData(dataProduct[position])
    }

    override fun getFilter() =
        object : Filter() {
            override fun performFiltering(text: CharSequence?): FilterResults {
                val filters = ArrayList<ProductModel>()
                if (text.isNullOrEmpty())
                    filters.addAll(allProducts)
                else {
                    val filterPattern = text.toString().trim()
                    for (item in allProducts) {
                        if (item.title.contains(filterPattern))
                            filters.add(item)
                    }
                }

                val result = FilterResults()
                result.values = filters
                return result
            }

            @SuppressLint("NotifyDataSetChanged")
            @Suppress("UNCHECKED_CAST")
            override fun publishResults(p0: CharSequence?, p1: FilterResults?) {
                dataProduct.clear()
                if (p1 != null) {
                    val filteredProducts = p1.values as ArrayList<ProductModel>
                    dataProduct.addAll(filteredProducts)
                }
                notifyDataSetChanged()


            }
        }


}



