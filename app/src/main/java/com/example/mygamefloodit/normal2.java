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
public class normal2 extends AppCompatActivity {
    private MyBase myBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal2);

        myBase = new MyBase(this);

        if (myBase.getMode()){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }


        Button easyButton = findViewById(R.id.button_normal7);
        Button normalButton = findViewById(R.id.button_normal8);
        Button hardButton = findViewById(R.id.button_normal9);

        easyButton.setOnClickListener(v -> {
            Intent intent = new Intent(normal2.this, MainActivity.class);
            intent.putExtra("numColors", 5);
            intent.putExtra("maxTurns", 30);
            intent.putExtra("boardSize", 14);
            startActivity(intent);
        });

        normalButton.setOnClickListener(v -> {
            Intent intent = new Intent(normal2.this, MainActivity.class);
            intent.putExtra("numColors", 6);
            intent.putExtra("maxTurns", 30);
            intent.putExtra("boardSize", 14);
            startActivity(intent);
        });

        hardButton.setOnClickListener(v -> {
            Intent intent = new Intent(normal2.this, MainActivity.class);
            intent.putExtra("numColors", 7);
            intent.putExtra("maxTurns", 30);
            intent.putExtra("boardSize", 14);
            startActivity(intent);
        });



    }
}

