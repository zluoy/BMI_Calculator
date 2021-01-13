package com.eunji.myapplication

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val height = intent.getStringExtra("height").toInt()
        val weight = intent.getStringExtra("weight").toInt()

        val bmi = weight / Math.pow(height/100.0, 2.0)

        when {
            bmi >= 35 -> {
                resultText.text = "고도 비만"
                resultImage.setImageResource(R.drawable.ic_sentiment_very_dissatisfied_black_24dp)
                resultImage.setColorFilter(Color.parseColor("#ff0000"))
            }
            bmi >= 23 -> {
                resultText.text = "과체중"
                resultImage.setImageResource(R.drawable.ic_mood_bad_black_24dp)
                resultImage.setColorFilter(Color.parseColor("#33ff0000"))
            }
            else -> {
                resultText.text = "정상"
                resultImage.setImageResource(R.drawable.ic_mood_black_24dp)
                resultImage.setColorFilter(Color.parseColor("#00ff00"))
            }
        }


        Toast.makeText(this,"BMI :: $bmi",Toast.LENGTH_SHORT).show()


    }
}
