package com.eunji.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadData()

        button.setOnClickListener {
            textView.text ="버튼 눌렀어용"
        }

        button2.setOnClickListener {
            saveData(height.text.toString().toInt(),
                    weight.text.toString().toInt())

            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("weight",weight.text.toString())
            intent.putExtra("height",height.text.toString())
            startActivity(intent)
        }
    }

    private fun saveData(height: Int, weight: Int) {
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        val editor = pref.edit()

        editor.putInt("KEY_HEIGHT", height)
            .putInt("KEY_WEIGHT", weight)
            .apply()

    }

    private fun loadData() {
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        val height_val = pref.getInt("KEY_HEIGHT", 0)
        val weight_val = pref.getInt("KEY_WEIGHT",0)

        if(height_val != 0 && weight_val != 0) {
            height.setText(height_val.toString())
            weight.setText(weight_val.toString())
        }
    }
}
