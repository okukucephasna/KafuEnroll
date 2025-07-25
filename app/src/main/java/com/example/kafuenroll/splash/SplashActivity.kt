package com.example.kafuenroll.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.kafuenroll.R
import com.example.kafuenroll.auth.LoginActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Get views
        val logo = findViewById<ImageView>(R.id.logo)
        val appName = findViewById<TextView>(R.id.appName)

        // Set initial alpha to 0 (invisible)
        logo.alpha = 0f
        appName.alpha = 0f

        // Animate fade-in
        logo.animate().alpha(1f).setDuration(1000).start()
        appName.animate().alpha(1f).setDuration(1500).start()

        // Delay then move to LoginActivity
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }, 2500)
    }
}
