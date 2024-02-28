package com.example.mygamefloodit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
public class easy3 extends AppCompatActivity {
    private MyBase myBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy3);

        myBase = new MyBase(this);

        if (myBase.getMode()){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }


        Button easyButton = findViewById(R.id.button_easy11);
        Button normalButton = findViewById(R.id.button_easy12);
        Button hardButton = findViewById(R.id.button_easy13);

        easyButton.setOnClickListener(v -> {
            Intent intent = new Intent(easy3.this, MainActivity.class);
            intent.putExtra("numColors", 4);
            intent.putExtra("maxTurns", 14);
            intent.putExtra("boardSize", 7);
            startActivity(intent);
        });

        normalButton.setOnClickListener(v -> {
            Intent intent = new Intent(easy3.this, MainActivity.class);
            intent.putExtra("numColors", 5);
            intent.putExtra("maxTurns", 14);
            intent.putExtra("boardSize", 7);
            startActivity(intent);
        });

        hardButton.setOnClickListener(v -> {
            Intent intent = new Intent(easy3.this, MainActivity.class);
            intent.putExtra("numColors", 6);
            intent.putExtra("maxTurns", 14);
            intent.putExtra("boardSize", 7);
            startActivity(intent);
        });



    }
}

