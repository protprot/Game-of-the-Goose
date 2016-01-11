package com.example.iem.gameofthegoose;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PlayersActivity extends AppCompatActivity {

    LinearLayout layoutPlayer2;
    LinearLayout layoutPlayer3;
    LinearLayout layoutPlayer4;

    ImageButton ibPlayer1;
    ImageButton ibPlayer2;
    ImageButton ibPlayer3;
    ImageButton ibPlayer4;

    EditText etPlayer1;
    EditText etPlayer2;
    EditText etPlayer3;
    EditText etPlayer4;

    NumberPicker pickerAnswerTime1;
    NumberPicker pickerAnswerTime2;
    NumberPicker pickerAnswerTime3;
    NumberPicker pickerAnswerTime4;

    Button bPlay;

    int[] pionAvailable = new int[] {
            2,
            0,
            0,
            4,
            0,
            0,
            0,
            1,
            3,
            0};

    int[] pionImage = new int[] {
            R.mipmap.pion_bleu,
            R.mipmap.pion_bleu_clair,
            R.mipmap.pion_gris,
            R.mipmap.pion_jaune,
            R.mipmap.pion_noir,
            R.mipmap.pion_orange,
            R.mipmap.pion_rose,
            R.mipmap.pion_rouge,
            R.mipmap.pion_vert,
            R.mipmap.pion_violet};

    Settings sets;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players);

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        //get Settings from MainActivity
        sets = (Settings) getIntent().getSerializableExtra("settings");

        setNumberPlayer(sets.getNbPlayer());

        initImageButton();
        initPickerAnswerTime();

        initButton();
    }


    public void setNumberPlayer(int nbPlayer) {

        layoutPlayer2 = (LinearLayout) findViewById(R.id.layoutPlayer2);
        layoutPlayer3 = (LinearLayout) findViewById(R.id.layoutPlayer3);
        layoutPlayer4 = (LinearLayout) findViewById(R.id.layoutPlayer4);

        if (nbPlayer < 4) {
            layoutPlayer4.setVisibility(View.INVISIBLE);
        }

        if (nbPlayer < 3) {
            layoutPlayer3.setVisibility(View.INVISIBLE);
        }

        if (nbPlayer < 2) {
            layoutPlayer2.setVisibility(View.INVISIBLE);
        }
    }


    public void initImageButton() {

        ibPlayer1 = (ImageButton) findViewById(R.id.ibPlayer1);
        ibPlayer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ibPlayer1.setImageResource(pionImage[getImageId(1)]);
            }
        });

        ibPlayer2 = (ImageButton) findViewById(R.id.ibPlayer2);
        ibPlayer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ibPlayer2.setImageResource(pionImage[getImageId(2)]);
            }
        });

        ibPlayer3 = (ImageButton) findViewById(R.id.ibPlayer3);
        ibPlayer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ibPlayer3.setImageResource(pionImage[getImageId(3)]);
            }
        });

        ibPlayer4 = (ImageButton) findViewById(R.id.ibPlayer4);
        ibPlayer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ibPlayer4.setImageResource(pionImage[getImageId(4)]);
            }
        });
    }

    public void initPickerAnswerTime() {

        String[] displayedValues = new String[] {"15 secondes", "30 secondes", "45 secondes"};

        pickerAnswerTime1 = (NumberPicker) findViewById(R.id.pickerAnswerTime1);
        pickerAnswerTime1.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
        pickerAnswerTime1.setMinValue(0);
        pickerAnswerTime1.setMaxValue(2);
        pickerAnswerTime1.setDisplayedValues(displayedValues);

        pickerAnswerTime2 = (NumberPicker) findViewById(R.id.pickerAnswerTime2);
        pickerAnswerTime2.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
        pickerAnswerTime2.setMinValue(0);
        pickerAnswerTime2.setMaxValue(2);
        pickerAnswerTime2.setDisplayedValues(displayedValues);

        pickerAnswerTime3 = (NumberPicker) findViewById(R.id.pickerAnswerTime3);
        pickerAnswerTime3.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
        pickerAnswerTime3.setMinValue(0);
        pickerAnswerTime3.setMaxValue(2);
        pickerAnswerTime3.setDisplayedValues(displayedValues);

        pickerAnswerTime4 = (NumberPicker) findViewById(R.id.pickerAnswerTime4);
        pickerAnswerTime4.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
        pickerAnswerTime4.setMinValue(0);
        pickerAnswerTime4.setMaxValue(2);
        pickerAnswerTime4.setDisplayedValues(displayedValues);


    }

    public int getImageId(int numPion) {

        int position = getCurrentPosition(numPion);

        int nextPosition;
        if (position < 9)
            nextPosition = position + 1;
        else
        nextPosition = 0;


        while (pionAvailable[nextPosition] != 0) {

            if (nextPosition < 9)
                nextPosition++;
            else
                nextPosition = 0;
        }

        pionAvailable[position] = 0;
        pionAvailable[nextPosition] = numPion;

        return nextPosition;
    }

    public int getCurrentPosition(int numPion) {

        int position = 0;

        while (pionAvailable[position] != numPion)
            position++;

        return position;
    }

    public void initButton() {

        etPlayer1 = (EditText) findViewById(R.id.etPlayer1);
        etPlayer2 = (EditText) findViewById(R.id.etPlayer2);
        etPlayer3 = (EditText) findViewById(R.id.etPlayer3);
        etPlayer4 = (EditText) findViewById(R.id.etPlayer4);


        bPlay = (Button) findViewById(R.id.bPlay);

        bPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addPlayersToSettings();

                Intent i = new Intent(PlayersActivity.this, BoardActivity.class);
                i.putExtra("settings", sets);
                startActivity(i);
            }
        });
    }

    private void addPlayersToSettings() {

        Player p;

        if (etPlayer1.getText().length() == 0)
            p = new Player("Joueur 1", pionImage[getCurrentPosition(1)], getAnswerTime(pickerAnswerTime1.getValue()));
        else
            p = new Player(etPlayer1.getText().toString(), pionImage[getCurrentPosition(1)], getAnswerTime(pickerAnswerTime1.getValue()));
        sets.addPlayer(p);

        if (sets.getNbPlayer() > 1) {
            if (etPlayer2.getText().length() == 0)
                p = new Player("Joueur 2", pionImage[getCurrentPosition(2)], getAnswerTime(pickerAnswerTime1.getValue()));
            else
                p = new Player(etPlayer2.getText().toString(), pionImage[getCurrentPosition(2)], getAnswerTime(pickerAnswerTime2.getValue()));
            sets.addPlayer(p);
        }

        if (sets.getNbPlayer() > 2) {
            if (etPlayer3.getText().length() == 0)
                p = new Player("Joueur 3", pionImage[getCurrentPosition(3)], getAnswerTime(pickerAnswerTime1.getValue()));
            else
                p = new Player(etPlayer3.getText().toString(), pionImage[getCurrentPosition(3)], getAnswerTime(pickerAnswerTime3.getValue()));
            sets.addPlayer(p);
        }

        if (sets.getNbPlayer() > 3) {
            if (etPlayer4.getText().length() == 0)
                p = new Player("Joueur 4", pionImage[getCurrentPosition(4)], getAnswerTime(pickerAnswerTime1.getValue()));
            else
                p = new Player(etPlayer4.getText().toString(), pionImage[getCurrentPosition(4)], getAnswerTime(pickerAnswerTime4.getValue()));
            sets.addPlayer(p);
        }
    }

    private int getAnswerTime(int pickerValue) {

        switch (pickerValue) {
            case 0:
                return 15;
            case 1:
                return 30;
            case 2:
                return 45;
            default:
                return 30;
        }
    }
}
