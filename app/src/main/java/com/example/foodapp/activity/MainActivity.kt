package com.example.foodapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.animeapp.R
import com.example.animeapp.databinding.ActivityMainBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private lateinit var navigationController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        navigationController = findNavController(R.id.main_nav_fragment)
        binding.bottomNavigationView.setupWithNavController(findNavController(R.id.main_nav_fragment))
    }

    private fun showConfirmDeleteFoodDialog() {
        val alertDialog = MaterialAlertDialogBuilder(this)
        alertDialog.setMessage(resources.getString(R.string.text_do_all))
        alertDialog.setPositiveButton(resources.getString(R.string.text_yes)) { dialog, _ ->
            dialog.dismiss()
        }
        alertDialog.setNegativeButton(resources.getString(R.string.text_cancel)) { dialog, _ ->
            dialog.dismiss()
        }
        alertDialog.create().show()
    }

    private fun showToastManager(massage: String) {
        Snackbar.make(
            binding.root,
            massage,
            Snackbar.LENGTH_SHORT,
        ).show()
    }

}