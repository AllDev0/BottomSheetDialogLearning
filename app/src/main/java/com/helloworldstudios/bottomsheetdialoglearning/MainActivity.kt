package com.helloworldstudios.bottomsheetdialoglearning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.helloworldstudios.bottomsheetdialoglearning.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fab.setOnClickListener {
            val bottomSheetFragment = ExpandableBottomSheetDialogFragment()
            bottomSheetFragment.show(supportFragmentManager, bottomSheetFragment.tag)
        }
    }
}