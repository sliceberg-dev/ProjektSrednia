package com.example.srednia

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView

class ResultsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results)

        findViewById<TextView>(R.id.resultsText).text = "Tu pojawią się zapisane wyniki."
    }
}
