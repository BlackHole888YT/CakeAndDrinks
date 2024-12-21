package com.example.cakeanddrinks.drinks

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.cakeanddrinks.Key
import com.example.cakeanddrinks.databinding.FragmentDetailDrinkBinding

class DetailDrinkFragment : Fragment() {

    private lateinit var binding: FragmentDetailDrinkBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailDrinkBinding.inflate(layoutInflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.callButton.setOnClickListener(View.OnClickListener {
            val phoneNumber = "tel:0555194109"
            val phoneIntent = Intent(Intent.ACTION_CALL)
            phoneIntent.data = Uri.parse(phoneNumber)
            startActivity(phoneIntent)
        })
        binding.orderButton.setOnClickListener(View.OnClickListener {
            val url = "https://api.whatsapp.com/send?phone=+996555194109"
            val i = Intent(Intent.ACTION_VIEW)
            i.setData(Uri.parse(url))
            startActivity(i)
        })


        if (arguments != null){
            val args = requireArguments().getSerializable(Key.DRINK.toString()) as Drinks
            binding.drinkName.text = args.name
            binding.drinkDesc.text = args.description
            binding.drinkPrice.text = args.price
            Glide.with(requireContext()).load(args.image).into(binding.drinkImage)
        }

    }
}