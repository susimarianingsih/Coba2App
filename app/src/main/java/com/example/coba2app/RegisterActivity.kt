package com.example.coba2app

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.credentials.PasswordCredential
import com.example.coba2app.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import org.intellij.lang.annotations.Pattern

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.tvGoToLogin.setOnClickListener {
            val intentlogin = Intent(this, LoginActivity::class.java)
            startActivity(intentlogin)
        }



        binding.btnRegister.setOnClickListener {

        }

    }




}