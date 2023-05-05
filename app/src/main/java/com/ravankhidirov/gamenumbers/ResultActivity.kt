package com.ravankhidirov.gamenumbers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val resultScore = findViewById<TextView>(R.id.resultScore)
        val res:String = intent.getStringExtra("scoreText").toString()
        resultScore.text = res
    }

    fun playAgain(view: View)
    {
        val intent = Intent(this,PlayActivity::class.java)
        startActivity(intent)
    }
}