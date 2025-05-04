package com.example.healthscanner.auth

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.healthscanner.R

class RegisterActivity : AppCompatActivity() {
    
    private lateinit var nameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var confirmPasswordEditText: EditText
    private lateinit var registerButton: Button
    private lateinit var loginTextView: TextView
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        
        // UI bileşenlerini tanımla
        nameEditText = findViewById(R.id.name_edit_text)
        emailEditText = findViewById(R.id.email_edit_text)
        passwordEditText = findViewById(R.id.password_edit_text)
        confirmPasswordEditText = findViewById(R.id.confirm_password_edit_text)
        registerButton = findViewById(R.id.register_button)
        loginTextView = findViewById(R.id.login_text_view)
        
        // Kayıt ol butonu tıklama olayı
        registerButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()
            val confirmPassword = confirmPasswordEditText.text.toString()
            
            if (name.isNotEmpty() && email.isNotEmpty() && 
                password.isNotEmpty() && confirmPassword.isNotEmpty()) {
                
                if (password == confirmPassword) {
                    // Normalde burada kayıt işlemi yapılır
                    Toast.makeText(this, "Kayıt başarılı!", Toast.LENGTH_SHORT).show()
                    finish() // Register activity'i kapat, login'e dön
                } else {
                    Toast.makeText(this, "Şifreler eşleşmiyor", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Lütfen tüm alanları doldurun", Toast.LENGTH_SHORT).show()
            }
        }
        
        // Giriş yap metnine tıklama
        loginTextView.setOnClickListener {
            finish() // Bu activity'i kapat, zaten altında login var
        }
    }
} 