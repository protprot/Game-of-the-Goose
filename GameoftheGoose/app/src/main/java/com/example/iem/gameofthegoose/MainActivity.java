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
    NumberPicker pickerNbDice;
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

        pickerNbDice = (NumberPicker) findViewById(R.id.pickerNbDice);
        pickerNbDice.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
        pickerNbDice.setMinValue(1);
        pickerNbDice.setMaxValue(2);
        pickerNbDice.setDisplayedValues(new String[]{"1 dé", "2 dés"});

        pickerGameTime = (NumberPicker) findViewById(R.id.pickerGameTime);
        pickerGameTime.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
        pickerGameTime.setMinValue(1);
        pickerGameTime.setMaxValue(4);
        pickerGameTime.setDisplayedValues(new String[]{"5 minutes", "10 minutes", "15 minutes", "20 minutes"});
    }


    public void initButton() {

        bNext = (Button) findViewById(R.id.bNext);

        bNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Settings s = new Settings(pickerPlayer.getValue(), pickerDifficulty.getValue(), pickerNbDice.getValue(), pickerGameTime.getValue());

                Intent i = new Intent(MainActivity.this, PlayersActivity.class);
                i.putExtra("settings", s);
                startActivity(i);

            }
        });
    }
}
