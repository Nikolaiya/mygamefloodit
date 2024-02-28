package com.example.mygamefloodit;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.Button;
import androidx.appcompat.app.AppCompatDelegate;

public class Normal extends AppCompatActivity {
    private MyBase myBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);

        myBase = new MyBase(this);

        if (myBase.getMode()){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }


        Button easyButton = findViewById(R.id.button_normal1);
        Button normalButton = findViewById(R.id.button_normal2);
        Button hardButton = findViewById(R.id.button_normal3);

        easyButton.setOnClickListener(v -> {
            Intent intent = new Intent(Normal.this, normal1.class);
            startActivity(intent);
        });
        normalButton.setOnClickListener(v -> {
            Intent intent = new Intent(Normal.this, normal2.class);
            startActivity(intent);
        });
        hardButton.setOnClickListener(v -> {
            Intent intent = new Intent(Normal.this, normal3.class);
            startActivity(intent);
        });



    }
}