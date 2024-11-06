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

        // Define the id of each items in the menu
        val homeId = R.id.home
        val settingId = R.id.setting
        val profileId = R.id.profile

        // Define the id of each fragment
        val fragmentHomeId = R.id.homeFragment
        val fragmentSettingId = R.id.settingFragment
        val fragmentProfileId = R.id.profileFragment

        // Define the id of the fragment container
        val fragmentContainer = R.id.fragmentContainer

        // Binding bottom navigation view
        val bottomNav = binding.bottomNav

        // Set the listener for the bottom navigation view
        /** The ID defined above is used to compare with the item ID in the bottom navigation.
         *  If they match, it triggers navigation to the corresponding screen.
         * */
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