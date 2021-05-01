package com.example.firebaseapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class PalmaresActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_palmares)

        //Setuo
        setup()
    }

    private fun setup(){
        title = "Palmares"

    }
}