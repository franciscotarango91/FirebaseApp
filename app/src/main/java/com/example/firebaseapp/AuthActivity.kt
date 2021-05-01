package com.example.firebaseapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_auth.*

class AuthActivity : AppCompatActivity() {

    //private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        //Setup
        setup()
    }

    private fun setup(){

        title = "Autenticacion"

        btnSignUp.setOnClickListener{
            if (editEmail.text.isNotEmpty() && editContraseña.text.isNotEmpty()) {
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(editEmail.text.toString(), editContraseña.text.toString()).addOnCompleteListener(){
                    if (it.isSuccessful){
                        showHome(it.result?.user?.email ?: "",ProviderType.BASIC)
                    } else {
                        showAlert()
                    }
                }
            }
        }

        btnAcceder.setOnClickListener{
            if (editEmail.text.isNotEmpty() && editContraseña.text.isNotEmpty()) {
                FirebaseAuth.getInstance().signInWithEmailAndPassword(editEmail.text.toString(), editContraseña.text.toString()).addOnCompleteListener(){
                    if (it.isSuccessful){
                        showHome(it.result?.user?.email ?: "",ProviderType.BASIC)
                    } else {
                        showAlert()
                    }
                }
            }
        }

        }
    private fun showAlert(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error de autenticacion")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
    private fun showHome(email: String, provider: ProviderType){
       val homeIntent = Intent(this, HomeActivity::class.java).apply {
           putExtra("email", email)
           putExtra("provider", provider.name)
           //db.collection("users").document(email).set(hashMapOf("provider" to provider))
       }
    startActivity(homeIntent)
}
}