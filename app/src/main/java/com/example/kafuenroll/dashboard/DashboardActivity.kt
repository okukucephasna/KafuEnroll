package com.example.kafuenroll.dashboard

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.kafuenroll.auth.LoginActivity
import com.example.kafuenroll.R
import com.google.firebase.auth.FirebaseAuth

class DashboardActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var txtUserEmail: TextView
    private lateinit var txtLogout: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        auth = FirebaseAuth.getInstance()
        val currentUser = auth.currentUser
        txtUserEmail = findViewById(R.id.txtUserEmail)
        txtUserEmail.text = "Welcome, ${currentUser?.email}"

        // Course Buttons
        findViewById<Button>(R.id.btnIT).setOnClickListener {
            // TODO: Navigate to IT course activity
        }

        findViewById<Button>(R.id.btnCriminology).setOnClickListener {
            // TODO: Navigate to Criminology course activity
        }

        findViewById<Button>(R.id.btnBusiness).setOnClickListener {
            // TODO: Navigate to Business course activity
        }

        // Logout link
        txtLogout = findViewById(R.id.txtLogout)
        txtLogout.setOnClickListener {
            auth.signOut()
            val intent = Intent(this, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        }
    }
}
