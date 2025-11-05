package com.example.srednia

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class CalculatorActivity : AppCompatActivity() {

    private lateinit var gradesContainer: LinearLayout
    private lateinit var addButton: Button
    private lateinit var calcButton: Button
    private lateinit var resultText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        gradesContainer = findViewById(R.id.gradesContainer)
        addButton = findViewById(R.id.addButton)
        calcButton = findViewById(R.id.calcButton)
        resultText = findViewById(R.id.resultText)

        // Na start dodaj 1 parę pól
        addGradeField()

        addButton.setOnClickListener {
            addGradeField()
        }

        calcButton.setOnClickListener {
            calculateAverage()
        }
    }

    private fun addGradeField() {
        val row = LinearLayout(this)
        row.orientation = LinearLayout.HORIZONTAL
        row.setPadding(0, 8, 0, 8)

        val gradeInput = EditText(this)
        gradeInput.hint = "Ocena"
        gradeInput.inputType = android.text.InputType.TYPE_CLASS_NUMBER or android.text.InputType.TYPE_NUMBER_FLAG_DECIMAL
        gradeInput.layoutParams = LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f)

        val weightInput = EditText(this)
        weightInput.hint = "Waga"
        weightInput.inputType = android.text.InputType.TYPE_CLASS_NUMBER or android.text.InputType.TYPE_NUMBER_FLAG_DECIMAL
        weightInput.layoutParams = LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f)

        row.addView(gradeInput)
        row.addView(weightInput)
        gradesContainer.addView(row)
    }

    private fun calculateAverage() {
        var sumWeighted = 0.0
        var sumWeights = 0.0

        for (i in 0 until gradesContainer.childCount) {
            val row = gradesContainer.getChildAt(i) as LinearLayout
            val gradeInput = row.getChildAt(0) as EditText
            val weightInput = row.getChildAt(1) as EditText

            val grade = gradeInput.text.toString().toDoubleOrNull()
            val weight = weightInput.text.toString().toDoubleOrNull()

            if (grade != null && weight != null && weight > 0) {
                sumWeighted += grade * weight
                sumWeights += weight
            }
        }

        if (sumWeights == 0.0) {
            resultText.text = "Podaj oceny i wagi!"
        } else {
            val avg = sumWeighted / sumWeights
            resultText.text = "Średnia ważona: %.2f".format(avg)
        }
    }
}
