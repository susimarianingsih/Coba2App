package com.example.coba2app

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.coba2app.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContentView(R.layout.activity_login)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvGoToRegister.setOnClickListener {
            val intentregister = Intent(this, RegisterActivity::class.java)
            startActivity(intentregister)
        }

        binding.tvForgotPassword.setOnClickListener {
            val intentforgotpsw = Intent(this, ForgetPswActivity::class.java)
            startActivity(intentforgotpsw)
        }

        binding.btnLogin.setOnClickListener {
            val intentlogin = Intent(this, MainActivity::class.java)
            startActivity(intentlogin)
        }
    }
}