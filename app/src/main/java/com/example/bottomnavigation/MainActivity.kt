package com.example.bottomnavigation

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.example.bottomnavigation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // binding view
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        // id of each items
        val homeId = R.id.home
        val settingId = R.id.setting
        val profileId = R.id.profile

        // id of each fragment
        val fragmentHomeId = R.id.homeFragment
        val fragmentSettingId = R.id.settingFragment
        val fragmentProfileId = R.id.profileFragment

        // id of fragment container
        val fragmentContainer = R.id.fragmentContainer

        // binding bottom navigation
        val bottomNav = binding.bottomNav

        // bottom navigation listener
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                homeId -> {
                    // Respond to navigation item 1 click
                    findNavController(fragmentContainer).navigate(fragmentHomeId)
                    true
                }

                settingId -> {
                    findNavController(fragmentContainer).navigate(fragmentSettingId)
                    true
                }

                profileId -> {
                    findNavController(fragmentContainer).navigate(fragmentProfileId)
                    true
                }

                else -> false
            }
        }
    }
}