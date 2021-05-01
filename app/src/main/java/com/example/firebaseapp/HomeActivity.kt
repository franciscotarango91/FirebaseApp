package com.example.firebaseapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_home.*

enum class ProviderType{
    BASIC
}

class HomeActivity : AppCompatActivity() {

    //private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Setup
        val bundle = intent.extras
        val email= bundle?.getString("email")
        val provider= bundle?.getString("provider")
        setup(email?: "", provider ?: "")

    }


    private fun setup(email: String, provider: String){
        title = "Inicio"
        //db.collection("users").document(email).set(hashMapOf("provider" to provider))
        //textViewProfile.text = email
        emailTextView.text = email
        providerTextView.text = provider

        btnTorneo.setOnClickListener() {
            val torneoIntent = Intent(this, TorneoActivity::class.java)
            startActivity(torneoIntent)}


            btnPalmares.setOnClickListener() {
                val palmaresIntent = Intent(this, PalmaresActivity::class.java)
                startActivity(palmaresIntent)}


                btnInicio.setOnClickListener() {
                    val inicioIntent = Intent(this, InicioActivity::class.java)
                    startActivity(inicioIntent)}

                btnRegistrar.setOnClickListener {
                    val registrarIntent = Intent(this, RegistrarActivity::class.java)
                    startActivity(registrarIntent)
                }

                    btnSignOut.setOnClickListener {
                        FirebaseAuth.getInstance().signOut()
                        onBackPressed()}
                }
            }


