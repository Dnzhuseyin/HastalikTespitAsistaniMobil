package com.example.healthscanner.auth

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.healthscanner.MainActivity
import com.example.healthscanner.R

class LoginActivity : AppCompatActivity() {
    
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button
    private lateinit var registerTextView: TextView
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        
        // UI bileşenlerini tanımla
        emailEditText = findViewById(R.id.email_edit_text)
        passwordEditText = findViewById(R.id.password_edit_text)
        loginButton = findViewById(R.id.login_button)
        registerTextView = findViewById(R.id.register_text_view)
        
        // Giriş butonu tıklama olayı
        loginButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()
            
            if (email.isNotEmpty() && password.isNotEmpty()) {
                // Normalde burada auth kontrolü yapılır
                // Şimdilik direkt ana sayfaya yönlendirelim
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish() // Login activity'i kapat
            } else {
                Toast.makeText(this, "Lütfen tüm alanları doldurun", Toast.LENGTH_SHORT).show()
            }
        }
        
        // Kayıt ol metnine tıklama
        registerTextView.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
} 