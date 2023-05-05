package com.ravankhidirov.gamenumbers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.TextView
import com.ravankhidirov.gamenumbers.databinding.ActivitySubtractionBinding
import kotlin.random.Random

class SubtractionActivity : AppCompatActivity() {

    private val totalDuration = 60 // seconds
    private var remainingTime = totalDuration
    private lateinit var countdownTimer: CountDownTimer

    lateinit var binding:ActivitySubtractionBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubtractionBinding.inflate(layoutInflater)
        setContentView(binding.root)


        countdownTimer = object : CountDownTimer((totalDuration * 1000).toLong(), 1000) {

            override fun onTick(millisUntilFinished: Long) {
                remainingTime = (millisUntilFinished / 1000).toInt()
                val seconds = remainingTime % 60
                val timeString = String.format("%02d", seconds)
                binding.tvCountdown.text = timeString
            }

            override fun onFinish() {
                binding.tvCountdown.text = "00"

                val scoreText = binding.score.text


                val intent = Intent(this@SubtractionActivity,ResultActivity::class.java)
                intent.putExtra("scoreText",scoreText)
                startActivity(intent)
            }
        }
    }


    fun startTimer(view: View) {
        countdownTimer.start()
        setNumbers()
        setChoices()
    }



    private fun setNumbers()
    {
        var fN = Random.nextInt(100,200)
        var sN = Random.nextInt(1,100)
        binding.firstNumber.text = fN.toString()
        binding.secondNumber.text = sN.toString()
    }


    private fun setChoices()
    {

        var fNum:Int = binding.firstNumber.text.toString().toInt()
        var sNum:Int = binding.secondNumber.text.toString().toInt()
        val choiceArray = arrayOf(binding.firstChoice,binding.secondChoice,binding.thirdChoice)
        val correctIndex = Random.nextInt(0,3)
        choiceArray[correctIndex].text = (fNum - sNum).toString()
        for (i in 0 until 3){
            if (i!=correctIndex){
                val randomVariant = Random.nextInt(50,200)
                choiceArray[i].text = randomVariant.toString()
            }
        }

    }

    private fun addOneToScore()
    {
        var s:Int = binding.score.text.toString().toInt()
        s += 1
        binding.score.text = s.toString()
    }



    // Checkers for choices

    //first choice

    fun checkFirst(view:View)
    {
        val firstChoiceNumber = binding.firstChoice.text.toString().toInt()
        var fNum:Int = binding.firstNumber.text.toString().toInt()
        var sNum:Int = binding.secondNumber.text.toString().toInt()
        if (firstChoiceNumber == fNum - sNum)
        {
            addOneToScore()
        }
        setNumbers()
        setChoices()
    }

    fun checkSecond(view:View)
    {
        val secondChoiceNumber = binding.secondChoice.text.toString().toInt()
        var fNum:Int = binding.firstNumber.text.toString().toInt()
        var sNum:Int = binding.secondNumber.text.toString().toInt()
        if (secondChoiceNumber == fNum - sNum)
        {
            addOneToScore()
        }
        setNumbers()
        setChoices()
    }

    fun checkThird(view:View)
    {
        val thirdChoiceNumber = binding.thirdChoice.text.toString().toInt()
        var fNum:Int = binding.firstNumber.text.toString().toInt()
        var sNum:Int = binding.secondNumber.text.toString().toInt()
        if (thirdChoiceNumber == fNum - sNum)
        {
            addOneToScore()
        }
        setNumbers()
        setChoices()
    }

}