package com.ravankhidirov.gamenumbers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ravankhidirov.gamenumbers.databinding.ActivityPlayBinding

class PlayActivity : AppCompatActivity() {

    lateinit var binding:ActivityPlayBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setOnClickListeners()
    }

    private fun setOnClickListeners()
    {
        binding.buttonProduct.setOnClickListener {
            val intent = Intent(this,ProductActivity::class.java)
            startActivity(intent)
        }
        binding.buttonSubtraction.setOnClickListener {
            val intent = Intent(this,SubtractionActivity::class.java)
            startActivity(intent)
        }
    }
}