package com.example.cakeanddrinks

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cakeanddrinks.cakes.CakesActivity
import com.example.cakeanddrinks.databinding.ActivityMainBinding
import com.example.cakeanddrinks.drinks.DrinksActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            cakes.setOnClickListener {
                startActivity(Intent(this@MainActivity, CakesActivity::class.java))
            }
            drinks.setOnClickListener {
                startActivity(Intent(this@MainActivity, DrinksActivity::class.java))
            }
        }
    }
}