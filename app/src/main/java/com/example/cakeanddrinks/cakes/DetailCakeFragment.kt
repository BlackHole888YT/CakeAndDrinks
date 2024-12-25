package com.example.cakeanddrinks.cakes

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.cakeanddrinks.Key
import com.example.cakeanddrinks.databinding.FragmentDetailCakeBinding
import com.example.cakeanddrinks.drinks.DetailDrinkFragmentArgs


class DetailCakeFragment : Fragment() {

    private lateinit var binding: FragmentDetailCakeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailCakeBinding.inflate(layoutInflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.callButton.setOnClickListener(View.OnClickListener {
            val phoneNumber = "tel:555000000"
            val phoneIntent = Intent(Intent.ACTION_CALL)
            phoneIntent.data = Uri.parse(phoneNumber)
            startActivity(phoneIntent)
        })

        binding.orderButton.setOnClickListener(View.OnClickListener {
            val url = "https://api.whatsapp.com/send?phone=+996555000000"
            val i = Intent(Intent.ACTION_VIEW)
            i.setData(Uri.parse(url))
            startActivity(i)

        })

        if (arguments != null){
            binding.backCakeBtn.setOnClickListener(){
                findNavController().navigateUp()
            }
            val args = DetailCakeFragmentArgs.fromBundle(requireArguments())
            binding.cakeName.text = args.name
            binding.cakeDesc.text = args.description
            binding.cakePrice.text = args.price
            Glide.with(requireContext()).load(args.image).into(binding.cakeImage)
        }
    }
}