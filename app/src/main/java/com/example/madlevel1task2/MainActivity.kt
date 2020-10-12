package com.example.madlevel1task2

import android.content.Context
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
     * Check inputs according to AND conjunction
     */
    private fun checkAnswer() {

        var answers: BooleanArray = BooleanArray(4)
        answers[0] = parseAnswer(binding.row1Input.text.toString())
        answers[1] = parseAnswer(binding.row2Input.text.toString())
        answers[2] = parseAnswer(binding.row3Input.text.toString())
        answers[3] = parseAnswer(binding.row4Input.text.toString())

        // Count correct answers
        var correctAnswers: Int = 0
        if (answers[0]) {
            correctAnswers++
        }
        if (!answers[1]) {
            correctAnswers++
        }
        if (!answers[2]) {
            correctAnswers++
        }
        if (!answers[3]) {
            correctAnswers++
        }

        // Assert and create toast
        if (answers[0] && !answers[1] && !answers[2] && !answers[3]) {
            Toast.makeText(this, getString(R.string.toast_correct, correctAnswers), Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, getString(R.string.toast_incorrect, correctAnswers), Toast.LENGTH_SHORT).show()
        }
    }
}