package com.example.iem.gameofthegoose;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.NumberPicker;

public class MainActivity extends AppCompatActivity {

    NumberPicker pickerPlayer;
    NumberPicker pickerDifficulty;
    NumberPicker pickerAnswerTime;
    NumberPicker pickerGameTime;
    Button bNext;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        initPicker();

        initButton();
    }


    public void initPicker() {

        pickerPlayer = (NumberPicker) findViewById(R.id.pickerPlayer);
        pickerPlayer.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
        pickerPlayer.setMinValue(1);
        pickerPlayer.setMaxValue(4);
        pickerPlayer.setDisplayedValues(new String[]{"1 joueur", "2 joueurs", "3 joueurs", "4 joueurs"});

        pickerDifficulty = (NumberPicker) findViewById(R.id.pickerDifficulty);
        pickerDifficulty.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
        pickerDifficulty.setMinValue(1);
        pickerDifficulty.setMaxValue(4);
        pickerDifficulty.setDisplayedValues(new String[]{"1", "2", "3", "4"});

        pickerAnswerTime = (NumberPicker) findViewById(R.id.pickerAnswerTime);
        pickerAnswerTime.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
        pickerAnswerTime.setMinValue(1);
        pickerAnswerTime.setMaxValue(4);
        pickerAnswerTime.setDisplayedValues(new String[]{"30 secondes", "1 minute", "2 minutes", "3 minutes"});

        pickerGameTime = (NumberPicker) findViewById(R.id.pickerGameTime);
        pickerGameTime.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
        pickerGameTime.setMinValue(1);
        pickerGameTime.setMaxValue(4);
        pickerGameTime.setDisplayedValues(new String[]{"30 minutes", "45 minutes", "1 heure", "2 heures"});
    }


    public void initButton() {

        bNext = (Button) findViewById(R.id.bNext);

        bNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Settings s = new Settings(pickerPlayer.getValue(), pickerDifficulty.getValue(), pickerAnswerTime.getValue(), pickerGameTime.getValue());

                Intent i = new Intent(MainActivity.this, PlayersActivity.class);
                i.putExtra("settings", s);
                startActivity(i);

            }
        });
    }
}
