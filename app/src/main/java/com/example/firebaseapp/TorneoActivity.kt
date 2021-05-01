package com.example.firebaseapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class TorneoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_torneo)

        //Setup
        setup()
    }
    private fun setup(){
        title = "Torneo"

    }
}