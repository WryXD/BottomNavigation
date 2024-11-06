package com.example.bottomnavigation

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.example.bottomnavigation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bottomNav = binding.bottomNav

        val fragmentContainer = R.id.fragmentContainer

        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    // Respond to navigation item 1 click
                    findNavController(fragmentContainer).navigate(R.id.homeFragment)
                    Log.d("TAG", "onCreate: home")
                    true
                }

                R.id.setting -> {
                    Log.d("TAG", "onCreate: setting")
                    findNavController(fragmentContainer).navigate(R.id.settingFragment)
                    true
                }

                R.id.profile -> {
                    Log.d("TAG", "onCreate: profile")
                    findNavController(fragmentContainer).navigate(R.id.profileFragment)
                    true
                }

                else -> false
            }
        }
    }
}