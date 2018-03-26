package com.akaita.android.morphview.example.java;

/**
 * Created by mikel on 27/03/2018.
 */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();

        final FavoriteToSendMorphView morphView = findViewById(R.id.morphView);

        Button favorite = findViewById(R.id.favoriteButton);
        Button toggle = findViewById(R.id.toggleButton);
        Button send = findViewById(R.id.sendButton);

        favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                morphView.showFavorite();
            }
        });
        toggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                morphView.morph();
            }
        });
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                morphView.showSend();
            }
        });
    }
}
