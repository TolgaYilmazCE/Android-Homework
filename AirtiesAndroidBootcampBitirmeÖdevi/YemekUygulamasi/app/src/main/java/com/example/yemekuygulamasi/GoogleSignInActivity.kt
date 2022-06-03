package com.example.yemekuygulamasi

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.NavDeepLinkBuilder
import androidx.navigation.findNavController
import com.example.yemekuygulamasi.databinding.ActivityGoogleSignInBinding
import com.example.yemekuygulamasi.fragment.AnasayfaFragment
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class GoogleSignInActivity : AppCompatActivity() {
    private lateinit var googleSignInClient: GoogleSignInClient
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityGoogleSignInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityGoogleSignInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        auth= Firebase.auth

        //Configure Google SignIn
        val gso= GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken("769098486258-6i7873gv4br7cegs4i665ietbiqpbmq7.apps.googleusercontent.com")
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(this,gso)

        binding.continueGoogletButton.setOnClickListener {
            signIn()

        }
        binding.createAccountButton.setOnClickListener {
            val pendingIntent =NavDeepLinkBuilder(this.applicationContext)
                .setGraph(R.navigation.nav)
                .setDestination(R.id.anasayfaFragment).createPendingIntent()
            pendingIntent.send()
        }
    }


    private fun signIn() {
        val signInIntent =googleSignInClient.signInIntent
        startActivityForResult(signInIntent,RC_SIGN_IN)


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == RC_SIGN_IN){
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                val account= task.getResult(ApiException::class.java)!!
                Log.d(ContentValues.TAG,"firebaseAuthWithGoogle"+account.id)
                firebaseAuthWithGoogle(account.idToken!!)

            }catch (e: ApiException){
                Log.w(ContentValues.TAG,"Google Sign in failed",e)
            }
        }
    }

    private fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken,null)
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this) {task ->
                if (task.isSuccessful){
                    Log.d(ContentValues.TAG,"signinwithcredential:Success")
                    val user =auth.currentUser
                    updateUI(user)
                }else{
                    Log.w(ContentValues.TAG,"signinwithcredential:Fail",task.exception)
                    updateUI(null)
                }

            }

    }

    private fun updateUI(user:FirebaseUser?) {
        if (user != null){
            val intent= Intent(applicationContext,AnasayfaFragment::class.java)
            intent.putExtra(EXTRA_NAME,user.displayName)
            val pendingIntent =NavDeepLinkBuilder(this.applicationContext)
                .setGraph(R.navigation.nav)
                .setDestination(R.id.anasayfaFragment).createPendingIntent()
            pendingIntent.send()
            //startActivity(intent)
        }
    }



    companion object{
        const val RC_SIGN_IN = 1001
        const val EXTRA_NAME ="EXTRA_NAME"
    }
}