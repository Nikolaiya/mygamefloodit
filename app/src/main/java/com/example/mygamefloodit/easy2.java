package com.example.mygamefloodit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;



import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
public class easy2 extends AppCompatActivity {
    private MyBase myBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy2);

        myBase = new MyBase(this);

        if (myBase.getMode()){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }


        Button easyButton = findViewById(R.id.button_easy7);
        Button normalButton = findViewById(R.id.button_easy8);
        Button hardButton = findViewById(R.id.button_easy9);

        easyButton.setOnClickListener(v -> {
            Intent intent = new Intent(easy2.this, MainActivity.class);
            intent.putExtra("numColors", 4);
            intent.putExtra("maxTurns", 18);
            intent.putExtra("boardSize", 7);
            startActivity(intent);
        });

        normalButton.setOnClickListener(v -> {
            Intent intent = new Intent(easy2.this, MainActivity.class);
            intent.putExtra("numColors", 5);
            intent.putExtra("maxTurns", 18);
            intent.putExtra("boardSize", 7);
            startActivity(intent);
        });

        hardButton.setOnClickListener(v -> {
            Intent intent = new Intent(easy2.this, MainActivity.class);
            intent.putExtra("numColors", 6);
            intent.putExtra("maxTurns", 18);
            intent.putExtra("boardSize", 7);
            startActivity(intent);
        });



    }
}

