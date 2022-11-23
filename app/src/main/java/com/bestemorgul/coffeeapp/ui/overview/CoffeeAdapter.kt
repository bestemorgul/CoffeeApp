package com.bestemorgul.coffeeapp.ui.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bestemorgul.coffeeapp.data.model.CoffeeTypes
import com.bestemorgul.coffeeapp.databinding.CoffeeItemDesignBinding

class CoffeeAdapter (private val clickListener: (CoffeeTypes) -> Unit
) : ListAdapter<CoffeeTypes, CoffeeAdapter.CoffeeViewHolder>(DiffCallback) {

    class CoffeeViewHolder(
        private var binding: CoffeeItemDesignBinding
    ): RecyclerView.ViewHolder(binding.root) {

        fun bind(coffee: CoffeeTypes) {
            binding.coffee = coffee
            binding.executePendingBindings()

        }
    }

    companion object DiffCallback: DiffUtil.ItemCallback<CoffeeTypes>() {
        override fun areItemsTheSame(oldItem: CoffeeTypes, newItem: CoffeeTypes): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: CoffeeTypes, newItem: CoffeeTypes): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoffeeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CoffeeViewHolder(
            CoffeeItemDesignBinding.inflate(layoutInflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CoffeeViewHolder, position: Int) {
        val coffee = getItem(position)
        holder.itemView.setOnClickListener{
            clickListener(coffee)
        }
        holder.bind(coffee)
    }
}
