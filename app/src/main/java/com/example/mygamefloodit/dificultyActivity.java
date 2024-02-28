package com.example.mygamefloodit;

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

public class dificultyActivity extends AppCompatActivity {
    private MyBase myBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dificulty);

        myBase = new MyBase(this);

        if (myBase.getMode()){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }


        Button easyButton = findViewById(R.id.button_easy);
        Button normalButton = findViewById(R.id.button_normal);
        Button hardButton = findViewById(R.id.button_hard);
        Button customButton = findViewById(R.id.button_custom);

        easyButton.setOnClickListener(v -> {
            Intent intent = new Intent(dificultyActivity.this, Easy.class);
            startActivity(intent);
        });
        normalButton.setOnClickListener(v -> {
            Intent intent = new Intent(dificultyActivity.this, Normal.class);
            startActivity(intent);
        });
        hardButton.setOnClickListener(v -> {
            Intent intent = new Intent(dificultyActivity.this, Hard.class);
            startActivity(intent);
        });
        customButton.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            LayoutInflater inflater = this.getLayoutInflater();
            View dialogView = inflater.inflate(R.layout.custom_dialog, null);
            builder.setView(dialogView);

            EditText editNumColors = dialogView.findViewById(R.id.edit_num_colors);
            EditText editMaxTurns = dialogView.findViewById(R.id.edit_max_turns);
            EditText editBoardSize = dialogView.findViewById(R.id.edit_board_size);

            builder.setPositiveButton("OK", null);
            builder.setNegativeButton("Закрыть", (dialog, id) -> {});

            AlertDialog dialog = builder.create();
            dialog.setOnShowListener(dialogInterface -> {
                Button button = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
                button.setOnClickListener(view -> {
                    boolean isValid = true;

                    int numColors = 0;
                    int maxTurns = 0;
                    int boardSize = 0;
                    try {
                        numColors = Integer.parseInt(editNumColors.getText().toString());
                        if (numColors < 2 || numColors > 10) {
                            editNumColors.setError("Введите число от 2 до 10");
                            isValid = false;
                        }
                    } catch (NumberFormatException e) {
                        editNumColors.setError("Введите число");
                        isValid = false;
                    }
                    try {
                        maxTurns = Integer.parseInt(editMaxTurns.getText().toString());
                    } catch (NumberFormatException e) {
                        editMaxTurns.setError("Введите число");
                        isValid = false;
                    }
                    try {
                        boardSize = Integer.parseInt(editBoardSize.getText().toString());
                    } catch (NumberFormatException e) {
                        editBoardSize.setError("Введите число");
                        isValid = false;
                    }
                    if (isValid) {
                        Intent intent = new Intent(dificultyActivity.this, MainActivity.class);
                        intent.putExtra("numColors", numColors);
                        intent.putExtra("maxTurns", maxTurns);
                        intent.putExtra("boardSize", boardSize);
                        startActivity(intent);
                        dialog.dismiss();
                    }
                });
            });

            dialog.show();
        });


    }
}