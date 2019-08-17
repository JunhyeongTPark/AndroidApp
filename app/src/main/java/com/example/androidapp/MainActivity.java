package com.example.androidapp;

import android.graphics.Color;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    LinearLayout scrollViewLayout = null;
    Button startButton = null;
    TextView textScore = null;

    int currentScore = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scrollViewLayout = (LinearLayout)findViewById(R.id.scrollViewLayout);
        textScore = (TextView) findViewById(R.id.textScore);

        textScore.setText(getString(R.string.score) + currentScore);



        startButton = (Button)findViewById(R.id.buttonSubmit);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                generateNewButton();
                startButton.setEnabled(false);
            }
        });
    }

    private void generateNewButton() {

        final Button newButton = new Button(MainActivity.this);

        int width = LinearLayout.LayoutParams.MATCH_PARENT;
        int length = LinearLayout.LayoutParams.MATCH_PARENT;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(width, length);

        newButton.setLayoutParams(layoutParams);

        newButton.setText(getString(R.string.press));
        newButton.setTextColor(getRandomColor());

        scrollViewLayout.addView(newButton);

        textScore.setText(getString(R.string.score) + currentScore++);

        newButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                generateNewButton();
                newButton.setEnabled(false);
            }
        });

    }

    private int getRandomColor() {
        Random rnd = new Random();
        return Color.argb(255, rnd.nextInt(256),
                rnd.nextInt(256), rnd.nextInt(256));
    }
}