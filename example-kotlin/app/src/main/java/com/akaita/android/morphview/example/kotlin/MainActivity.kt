package com.akaita.android.morphview.example.kotlin

/**
 * Created by mikel on 26/03/2018.
 */

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()

        favoriteButton.setOnClickListener { morphView.showFavorite() }
        toggleButton.setOnClickListener { morphView.morph() }
        sendButton.setOnClickListener { morphView.showSend() }
    }
}
