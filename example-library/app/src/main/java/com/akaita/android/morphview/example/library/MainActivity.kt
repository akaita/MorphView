package com.akaita.android.morphview.example.library

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

        favoriteButton.setOnClickListener { morphView.showAvdFirst() }
        toggleButton.setOnClickListener { morphView.morph() }
        sendButton.setOnClickListener { morphView.showAvdSecond() }
    }
}
