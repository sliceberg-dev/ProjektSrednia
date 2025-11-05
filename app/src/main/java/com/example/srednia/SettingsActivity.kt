package com.example.srednia

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate

class SettingsActivity : AppCompatActivity() {

    private lateinit var themeSwitch: Switch
    private lateinit var backButton: Button
    private lateinit var prefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        prefs = getSharedPreferences("app_settings", MODE_PRIVATE)

        themeSwitch = findViewById(R.id.switchTheme)
        backButton = findViewById(R.id.buttonBack)

        // Ustaw stan przełącznika zgodnie z zapisanym motywem
        val darkModeEnabled = prefs.getBoolean("dark_mode", false)
        themeSwitch.isChecked = darkModeEnabled
        applyTheme(darkModeEnabled)

        // Zmiana motywu po kliknięciu
        themeSwitch.setOnCheckedChangeListener { _, isChecked ->
            applyTheme(isChecked)
            prefs.edit().putBoolean("dark_mode", isChecked).apply()
        }

        backButton.setOnClickListener {
            finish() // wraca do poprzedniego ekranu
        }
    }

    private fun applyTheme(dark: Boolean) {
        if (dark) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }
}
