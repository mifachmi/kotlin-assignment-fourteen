package com.example.kotlin_assignment_eleven

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.kotlin_assignment_eleven.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.mbRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        binding.mbLogin.setOnClickListener{
            Toast.makeText(applicationContext, "Selamat datang, ${binding.itUsername.text}", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
        }
    }
}