package com.example.cakeanddrinks.drinks

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cakeanddrinks.databinding.ItemCakeBinding
import com.example.cakeanddrinks.databinding.ItemDrinkBinding

class DrinksAdapter(val drinkList: ArrayList<Drinks>, val listener: (position: Int) -> Unit) :
    RecyclerView.Adapter<DrinksAdapter.CakesViewHolder>() {
    inner class CakesViewHolder(val binding: ItemDrinkBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(drinks: Drinks){
            binding.apply {
                drinkDesc.text =  drinks.description
                Glide.with(drinkImage).load(drinks.image).into(drinkImage)
                drinkPrice.text = drinks.price
                drinkName.text = drinks.name
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CakesViewHolder {
        val binding =  CakesViewHolder(ItemDrinkBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        return binding
    }

    override fun getItemCount(): Int {
        return drinkList.size
    }

    override fun onBindViewHolder(holder: CakesViewHolder, position: Int) {
        holder.bind(drinkList[position])
        holder.itemView.setOnClickListener{
            listener(position)
        }
    }
}