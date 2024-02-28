package com.example.mygamefloodit;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import java.util.Locale;


public class MainActivity extends AppCompatActivity {
    private GameBoardView gameBoardView;
    private TextView turnsLabel;
    private int numOfTurns;
    private int currentColor;
    private int maxTurns;
    private MyBase myBase;
    private static final int NUM_OF_SQUARES = 14;
    private boolean isPaused = false;
    private Button buttonpause;
    private void incrementTurnsAndCheckForWin() {
        if (isPaused) return;

        numOfTurns--;
        updateTurnsLabel();

        if (numOfTurns <= 0 || gameBoardView.checkForWin()) {
            if (gameBoardView.checkForWin()) {
                Toast.makeText(this, "Ты победил!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Ты проиграл!", Toast.LENGTH_SHORT).show();
            }
            resetGame();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        gameBoardView = findViewById(R.id.gameBoard);
        turnsLabel = findViewById(R.id.turnsLabel);
        TextView red = findViewById(R.id.red);
        TextView gre = findViewById(R.id.gre);
        TextView blu = findViewById(R.id.blu);
        TextView yel = findViewById(R.id.ylo);
        TextView pur = findViewById(R.id.pur);
        TextView aqu = findViewById(R.id.aqu);
        TextView ora = findViewById(R.id.ora);
        TextView pin = findViewById(R.id.pin);
        TextView gra = findViewById(R.id.gra);
        TextView dblu = findViewById(R.id.dblu);
        buttonpause = findViewById(R.id.buttonpause);

        Intent intent = getIntent();
        int numColors = intent.getIntExtra("numColors", 6);
        int maxTurns = intent.getIntExtra("maxTurns", 0);
        int boardSize = intent.getIntExtra("boardSize", 14);
        gameBoardView.setDifficulty(numColors, maxTurns, boardSize);


        startGameWithDifficulty(numColors, maxTurns, boardSize);


        red.setOnClickListener(v -> {
            if (isPaused) return;
            int newColorIndex = gameBoardView.getColorIndex(Color.parseColor("#FF0000"));
            if (gameBoardView.isColorActive(newColorIndex)) {
                gameBoardView.setCurrentColorIndex(newColorIndex);
                gameBoardView.floodFillFromTopLeft();
                incrementTurnsAndCheckForWin();
            }
        });
        gre.setOnClickListener(v -> {
            if (isPaused) return;
            int newColorIndex = gameBoardView.getColorIndex(Color.parseColor("#00FF00"));
            if (gameBoardView.isColorActive(newColorIndex)) {
                gameBoardView.setCurrentColorIndex(newColorIndex);
                gameBoardView.floodFillFromTopLeft();
                incrementTurnsAndCheckForWin();
            }
        });
        blu.setOnClickListener(v -> {
            if (isPaused) return;
            int newColorIndex = gameBoardView.getColorIndex(Color.parseColor("#0000FF"));
            if (gameBoardView.isColorActive(newColorIndex)) {
                gameBoardView.setCurrentColorIndex(newColorIndex);
                gameBoardView.floodFillFromTopLeft();
                incrementTurnsAndCheckForWin();
            }
        });
        yel.setOnClickListener(v -> {
            if (isPaused) return;
            int newColorIndex = gameBoardView.getColorIndex(Color.parseColor("#FFFF00"));
            if (gameBoardView.isColorActive(newColorIndex)) {
                gameBoardView.setCurrentColorIndex(newColorIndex);
                gameBoardView.floodFillFromTopLeft();
                incrementTurnsAndCheckForWin();
            }
        });
        pur.setOnClickListener(v -> {
            if (isPaused) return;
            int newColorIndex = gameBoardView.getColorIndex(Color.parseColor("#800080"));
            if (gameBoardView.isColorActive(newColorIndex)) {
                gameBoardView.setCurrentColorIndex(newColorIndex);
                gameBoardView.floodFillFromTopLeft();
                incrementTurnsAndCheckForWin();
            }
        });
        aqu.setOnClickListener(v -> {
            if (isPaused) return;
            int newColorIndex = gameBoardView.getColorIndex(Color.parseColor("#00FFFF"));
            if (gameBoardView.isColorActive(newColorIndex)) {
                gameBoardView.setCurrentColorIndex(newColorIndex);
                gameBoardView.floodFillFromTopLeft();
                incrementTurnsAndCheckForWin();
            }
        });
        ora.setOnClickListener(v -> {
            if (isPaused) return;
            int newColorIndex = gameBoardView.getColorIndex(Color.parseColor("#FFA500"));
            if (gameBoardView.isColorActive(newColorIndex)) {
                gameBoardView.setCurrentColorIndex(newColorIndex);
                gameBoardView.floodFillFromTopLeft();
                incrementTurnsAndCheckForWin();
            }
        });
        pin.setOnClickListener(v -> {
            if (isPaused) return;
            int newColorIndex = gameBoardView.getColorIndex(Color.parseColor("#F3AFD4"));
            if (gameBoardView.isColorActive(newColorIndex)) {
                gameBoardView.setCurrentColorIndex(newColorIndex);
                gameBoardView.floodFillFromTopLeft();
                incrementTurnsAndCheckForWin();
            }
        });
        gra.setOnClickListener(v -> {
            if (isPaused) return;
            int newColorIndex = gameBoardView.getColorIndex(Color.parseColor("#808080"));
            if (gameBoardView.isColorActive(newColorIndex)) {
                gameBoardView.setCurrentColorIndex(newColorIndex);
                gameBoardView.floodFillFromTopLeft();
                incrementTurnsAndCheckForWin();
            }
        });
        dblu.setOnClickListener(v -> {
            if (isPaused) return;
            int newColorIndex = gameBoardView.getColorIndex(Color.parseColor("#262627"));
            if (gameBoardView.isColorActive(newColorIndex)) {
                gameBoardView.setCurrentColorIndex(newColorIndex);
                gameBoardView.floodFillFromTopLeft();
                incrementTurnsAndCheckForWin();
            }
        });
        Button butres = findViewById(R.id.button_restart);
        butres.setOnClickListener(v -> resetGame());

        buttonpause.setOnClickListener(v -> {
            isPaused = !isPaused;
            if (isPaused) {
                buttonpause.setText("Продолжить");
            } else {
                buttonpause.setText("Пауза");
            }
        });


        myBase = new MyBase(this);
        if (myBase.getMode()){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }



        if (gameBoardView == null) {
            Log.e("MainActivity", "GameBoardView is not found. Check your layout.");
        }

        if (turnsLabel == null) {
            Log.e("MainActivity", "TurnsLabel is not found. Check your layout.");
        }

        currentColor = 0;

        resetGame();
    }

    private void resetGame() {
        numOfTurns = maxTurns;
        updateTurnsLabel();
        gameBoardView.setupColors(gameBoardView.getNumColors());
        gameBoardView.setupBoard();
        gameBoardView.invalidate();
        currentColor = gameBoardView.getInitialColor();
    }


    public void startGameWithDifficulty(int numColors, int maxTurns, int boardSize) {
        this.maxTurns = maxTurns;
        gameBoardView.setDifficulty(numColors, maxTurns, boardSize);
        this.numOfTurns = maxTurns;
        updateTurnsLabel();
    }





    private void updateTurnsLabel() {
        turnsLabel.setText(String.format(Locale.getDefault(), "%02d/%02d", numOfTurns, maxTurns));
    }



    private void checkForWin() {
        if (gameBoardView.checkForWin()) {
            Toast.makeText(this, "Ты победил!", Toast.LENGTH_SHORT).show();
            resetGame();
        } else if (numOfTurns >= 25) {
            Toast.makeText(this, "Ты проиграл!", Toast.LENGTH_SHORT).show();
            resetGame();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        if (isTouchInsideView(x, y, gameBoardView)) {
            handleGameBoardTouch(event);
        }

        return true;
    }

    private boolean isTouchInsideView(float x, float y, View view) {
        int[] location = new int[2];
        view.getLocationOnScreen(location);
        float viewX = location[0];
        float viewY = location[1];

        return (x > viewX && x < viewX + view.getWidth() &&
                y > viewY && y < viewY + view.getHeight());
    }

    private void handleGameBoardTouch(MotionEvent event) {
        int squareSize = gameBoardView.getSquareSize();
        int xIndex = (int) (event.getX() / squareSize);
        int yIndex = (int) (event.getY() / squareSize);
        if (isPaused) return;

        if (xIndex >= 0 && xIndex < NUM_OF_SQUARES && yIndex >= 0 && yIndex < NUM_OF_SQUARES) {
            int selectedColorIndex = gameBoardView.getColorAt(xIndex, yIndex);
            if (selectedColorIndex != currentColor) {
                gameBoardView.setCurrentColorIndex(selectedColorIndex);
                incrementTurnsAndCheckForWin();
            }
        }
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, StartActivity.class);
        startActivity(intent);
        finish();
    }


}
