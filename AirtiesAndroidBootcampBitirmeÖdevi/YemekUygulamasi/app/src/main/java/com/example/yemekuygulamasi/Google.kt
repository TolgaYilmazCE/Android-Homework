package com.example.yemekuygulamasi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.yemekuygulamasi.GoogleSignInActivity.Companion.EXTRA_NAME
import com.example.yemekuygulamasi.databinding.ActivityGoogleBinding
import com.example.yemekuygulamasi.databinding.ActivityGoogleSignInBinding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Google : AppCompatActivity() {
    private lateinit var binding:ActivityGoogleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityGoogleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.displayNameTextview.text=intent.getStringExtra(EXTRA_NAME)
        binding.logOutGoogletButton.setOnClickListener {
            Firebase.auth.signOut()

            val intent = Intent(applicationContext,GoogleSignInActivity::class.java)
            startActivity(intent)
        }
    }
}