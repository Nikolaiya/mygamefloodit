package com.example.mygamefloodit;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GameBoardView extends View {
    private int numOfSquares = 14;
    private int squareSize;
    private final Paint paint = new Paint();
    private int[][] colorBoard;
    private final List<Integer> colors = new ArrayList<>();
    private final Random random = new Random();
    private int currentColorIndex;

    public int getNumColors() {
        return colors.size();
    }



    public GameBoardView(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    public void setDifficulty(int numColors, int maxTurns, int boardSize) {
        this.numOfSquares = boardSize;
        colors.clear();
        setupColors(numColors);
        setupBoard();
        invalidate();
    }
    public boolean isColorActive(int colorIndex) {
        if (colorIndex < 0 || colorIndex >= colors.size()) {
            return false;
        }
        for (int i = 0; i < numOfSquares; i++) {
            for (int j = 0; j < numOfSquares; j++) {
                if (colorBoard[i][j] == colorIndex) {
                    return true;
                }
            }
        }
        return false;
    }

    void setupColors(int numColors) {
        List<Integer> allColors = Arrays.asList(
                Color.parseColor("#FF0000"), // Красный
                Color.parseColor("#00FF00"), // Зелёный
                Color.parseColor("#0000FF"), // Синий
                Color.parseColor("#FFFF00"), // Жёлтый
                Color.parseColor("#800080"), // Фиолетовый
                Color.parseColor("#00FFFF"), // Голубой
                Color.parseColor("#FFA500"), // Оранжевый
                Color.parseColor("#F3AFD4"), // Розовый
                Color.parseColor("#808080"), // Серый
                Color.parseColor("#262627")  // Чёрный
        );
        Collections.shuffle(allColors, random);
        colors.clear();
        colors.addAll(allColors.subList(0, numColors));
    }



    void setupBoard() {
        colorBoard = new int[numOfSquares][numOfSquares];
        for (int i = 0; i < numOfSquares; i++) {
            for (int j = 0; j < numOfSquares; j++) {
                colorBoard[i][j] = random.nextInt(colors.size());
            }
        }
    }


    public void setCurrentColorIndex(int colorIndex) {
        this.currentColorIndex = colorIndex;
        invalidate();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int size;
        if (widthMode == MeasureSpec.EXACTLY && heightMode != MeasureSpec.EXACTLY) {
            size = widthSize;
        } else if (heightMode == MeasureSpec.EXACTLY && widthMode != MeasureSpec.EXACTLY) {
            size = heightSize;
        } else {
            size = Math.min(widthSize, heightSize);
        }


        squareSize = size / numOfSquares;


        setMeasuredDimension(size, size);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float borderWidth = 2;


        for (int i = 0; i < numOfSquares; i++) {
            for (int j = 0; j < numOfSquares; j++) {
                int colorIndex = colorBoard[i][j];

                paint.setColor(colors.get(colorIndex));
                paint.setStyle(Paint.Style.FILL);

                float left = i * squareSize;
                float top = j * squareSize;
                float right = (i + 1) * squareSize;
                float bottom = (j + 1) * squareSize;

                canvas.drawRect(left, top, right, bottom, paint);

                paint.setColor(Color.BLACK);
                paint.setStyle(Paint.Style.STROKE);
                paint.setStrokeWidth(borderWidth);

                canvas.drawRect(left + borderWidth/2, top + borderWidth/2, right - borderWidth/2, bottom - borderWidth/2, paint);
            }
        }
    }

    public int getColorIndex(int color) {
        return colors.indexOf(color);
    }

    public void floodFill(int xIndex, int yIndex, int targetColorIndex, int replacementColorIndex) {
        if (xIndex < 0 || xIndex >= numOfSquares || yIndex < 0 || yIndex >= numOfSquares) {
            return;
        }

        if (colorBoard[xIndex][yIndex] != targetColorIndex) {
            return;
        }

        colorBoard[xIndex][yIndex] = replacementColorIndex;

        floodFill(xIndex + 1, yIndex, targetColorIndex, replacementColorIndex);
        floodFill(xIndex - 1, yIndex, targetColorIndex, replacementColorIndex);
        floodFill(xIndex, yIndex + 1, targetColorIndex, replacementColorIndex);
        floodFill(xIndex, yIndex - 1, targetColorIndex, replacementColorIndex);

    }

    public void floodFillFromTopLeft() {
        int targetColorIndex = colorBoard[0][0];
        if (targetColorIndex != currentColorIndex) {
            floodFill(0, 0, targetColorIndex, currentColorIndex);
        }
    }

    public boolean checkForWin() {
        int firstColor = colorBoard[0][0];

        for (int i = 0; i < numOfSquares; i++) {
            for (int j = 0; j < numOfSquares; j++) {
                if (colorBoard[i][j] != firstColor) {
                    return false;
                }
            }
        }

        return true;
    }


    public int getColorAt(int x, int y) {
        return colorBoard[x][y];
    }

    public int getSquareSize() {
        return squareSize;
    }

    public int getInitialColor() {
        return colorBoard[0][0];
    }

}