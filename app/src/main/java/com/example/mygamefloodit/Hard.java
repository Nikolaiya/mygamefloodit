package com.example.mygamefloodit;

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

public class Hard extends AppCompatActivity {
    private MyBase myBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hard);

        myBase = new MyBase(this);

        if (myBase.getMode()){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }


        Button easyButton = findViewById(R.id.button_hard1);
        Button normalButton = findViewById(R.id.button_hard2);
        Button hardButton = findViewById(R.id.button_hard3);

        easyButton.setOnClickListener(v -> {
            Intent intent = new Intent(Hard.this, hard1.class);
            startActivity(intent);
        });
        normalButton.setOnClickListener(v -> {
            Intent intent = new Intent(Hard.this, hard2.class);
            startActivity(intent);
        });
        hardButton.setOnClickListener(v -> {
            Intent intent = new Intent(Hard.this, hard3.class);
            startActivity(intent);
        });



    }
}