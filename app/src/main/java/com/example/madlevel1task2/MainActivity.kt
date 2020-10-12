package com.example.madlevel1task2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.madlevel1task2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.buttonSubmit.setOnClickListener {
            checkAnswer()
        }
    }

    /**
     * Parse string to bool
     */
    private fun parseAnswer(text: String): Boolean {
        return when (text) {
            "T" -> {
                true
            }
            "F" -> {
                false
            }
            else -> false
            }
    }

    /**
     * Check inputs with according to AND conjunction
     */
    private fun checkAnswer() {

        var answers: BooleanArray = BooleanArray(4)
        answers[0] = parseAnswer(binding.row1Input.text.toString())
        answers[1] = parseAnswer(binding.row2Input.text.toString())
        answers[2] = parseAnswer(binding.row3Input.text.toString())
        answers[3] = parseAnswer(binding.row4Input.text.toString())

        if (answers[0] && !answers[1] && !answers[2] && !answers[3]) {
            Toast.makeText(this, getString(R.string.toast_correct), Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, getString(R.string.toast_incorrect), Toast.LENGTH_SHORT).show()
        }
    }
}