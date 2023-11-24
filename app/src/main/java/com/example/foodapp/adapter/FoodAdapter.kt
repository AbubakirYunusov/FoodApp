package com.example.foodapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.animeapp.R
import com.example.animeapp.databinding.FoodItemBinding
import com.example.foodapp.interfaces.FoodInterface
import com.example.foodapp.model.FoodModel

class FoodAdapter(
    private val FoodItem: FoodInterface
) : RecyclerView.Adapter <FoodAdapter.FoodeViewHolder> ()  {

    private var foodList = mutableListOf<FoodModel>()

    fun updeteList(movielist: List<FoodModel>){
        foodList.clear()
        foodList.addAll(movielist)
        notifyDataSetChanged()
    }

    inner class FoodeViewHolder(
        private val binding: FoodItemBinding

    ): RecyclerView.ViewHolder(binding.root) {

        fun bind(food: FoodModel) {
            binding.cardView2.setOnClickListener {
                FoodItem.foodInterface()
            }
            binding.tvFoodItem.text = food.name
            binding.tvFooditemtext.text = food.name2

            Glide
                .with(binding.root)
                .load(food.img)
                .into(binding.ivFoodIten)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodeViewHolder {
        val binding = FoodItemBinding.bind(
            LayoutInflater.from(parent.context).inflate(
                R.layout.food_item,
                parent,
                false,
            )
        )
        return FoodeViewHolder(binding)
    }

    override fun getItemCount() = foodList.size

    override fun onBindViewHolder(
        holder: FoodeViewHolder, position: Int,
    ) {
        holder.bind(foodList[position])
    }
}