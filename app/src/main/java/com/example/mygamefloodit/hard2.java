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
public class hard2 extends AppCompatActivity {
    private MyBase myBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hard2);

        myBase = new MyBase(this);

        if (myBase.getMode()){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }


        Button easyButton = findViewById(R.id.button_hard7);
        Button normalButton = findViewById(R.id.button_hard8);
        Button hardButton = findViewById(R.id.button_hard9);

        easyButton.setOnClickListener(v -> {
            Intent intent = new Intent(hard2.this, MainActivity.class);
            intent.putExtra("numColors", 6);
            intent.putExtra("maxTurns", 57);
            intent.putExtra("boardSize", 25);
            startActivity(intent);
        });

        normalButton.setOnClickListener(v -> {
            Intent intent = new Intent(hard2.this, MainActivity.class);
            intent.putExtra("numColors", 7);
            intent.putExtra("maxTurns", 57);
            intent.putExtra("boardSize", 25);
            startActivity(intent);
        });

        hardButton.setOnClickListener(v -> {
            Intent intent = new Intent(hard2.this, MainActivity.class);
            intent.putExtra("numColors", 8);
            intent.putExtra("maxTurns", 57);
            intent.putExtra("boardSize", 25);
            startActivity(intent);
        });



    }
}

