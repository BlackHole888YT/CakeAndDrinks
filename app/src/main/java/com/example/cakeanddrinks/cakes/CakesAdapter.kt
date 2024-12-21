package com.example.cakeanddrinks.cakes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cakeanddrinks.databinding.ItemCakeBinding

class CakesAdapter(val cakesList: ArrayList<Cakes>, val listener: (position: Int) -> Unit ) :
    RecyclerView.Adapter<CakesAdapter.CakesViewHolder>() {
    inner class CakesViewHolder(val binding: ItemCakeBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(cakes: Cakes){
            binding.apply {
                cakeDesc.text =  cakes.description
                Glide.with(cakeImage).load(cakes.image).into(cakeImage)
                cakePrice.text = cakes.price
                cakeName.text = cakes.name
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CakesViewHolder {
        val binding =  CakesViewHolder(ItemCakeBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        return binding
    }

    override fun getItemCount(): Int {
        return cakesList.size
    }

    override fun onBindViewHolder(holder: CakesViewHolder, position: Int) {
        holder.bind(cakesList[position])
        holder.itemView.setOnClickListener{
            listener(position)
        }
    }
}