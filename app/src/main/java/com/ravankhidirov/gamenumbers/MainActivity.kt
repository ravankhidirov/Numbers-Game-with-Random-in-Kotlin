package com.ravankhidirov.gamenumbers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ravankhidirov.gamenumbers.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setOnClickListeners()
    }

    private fun setOnClickListeners()
    {
        binding.playButton.setOnClickListener {
            val intent = Intent(this,PlayActivity::class.java)
            startActivity(intent)
        }
    }
}