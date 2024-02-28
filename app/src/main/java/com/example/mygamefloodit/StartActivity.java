package com.example.mygamefloodit;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class StartActivity extends AppCompatActivity {
    private MyBase myBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);


        myBase = new MyBase(this);

        if (myBase.getMode()){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }


        Button buttonPlay = findViewById(R.id.buttonplay);
        Button buttonSet = findViewById(R.id.buttonset);
        Button buttonExit = findViewById(R.id.buttonexit);
        buttonPlay.setOnClickListener(v -> {
            Intent intent = new Intent(StartActivity.this, dificultyActivity.class);
            startActivity(intent);
        });
        buttonSet.setOnClickListener(v -> {
            Intent intent = new Intent(StartActivity.this, SettingsActivity.class);
            startActivity(intent);
        });
        buttonExit.setOnClickListener(v -> {
            finishAffinity();
        });
    }
}
