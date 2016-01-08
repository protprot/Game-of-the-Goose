package com.example.iem.gameofthegoose;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class BoardActivity extends AppCompatActivity {

    int windowwidth;
    int windowheight;

    ImageView pion1;
    ImageView pion2;
    ImageView pion3;
    ImageView pion4;

    LinearLayout layoutTrouver;

    Settings sets;

    int nbPlayers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);

        windowwidth = getWindowManager().getDefaultDisplay().getWidth();
        windowheight = getWindowManager().getDefaultDisplay().getHeight();

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);


        //get Settings from MainActivity
        sets = (Settings) getIntent().getSerializableExtra("settings");

        //show board
        RelativeLayout background = (RelativeLayout) findViewById(R.id.layoutBackground);
        background.setBackgroundResource(R.drawable.plateau_max);

        nbPlayers = sets.getNbPlayer();

        initPion();

        listenerPion();

        initPopup();
    }

    @Override
    public void onBackPressed() {

    }

    public void initPion() {

        float depPion1X = (float) (0.03 * windowwidth);
        float depPion1Y = (float) (0.75 * windowheight);


        pion1 = (ImageView) findViewById(R.id.pion1);
        pion2 = (ImageView) findViewById(R.id.pion2);
        pion3 = (ImageView) findViewById(R.id.pion3);
        pion4 = (ImageView) findViewById(R.id.pion4);


        pion1.setImageResource(sets.listPlayer.get(0).getImage());
        pion1.setX(depPion1X);
        pion1.setY(depPion1Y);

        if (nbPlayers > 1) {
            pion2.setImageResource(sets.listPlayer.get(1).getImage());
            pion2.setX(depPion1X + 100);
            pion2.setY(depPion1Y);
        }

        if (nbPlayers > 2) {
            pion3.setImageResource(sets.listPlayer.get(2).getImage());
            pion3.setX(depPion1X);
            pion3.setY(depPion1Y + 70);
        }

        if (nbPlayers > 3) {
            pion4.setImageResource(sets.listPlayer.get(3).getImage());
            pion4.setX(depPion1X + 100);
            pion4.setY(depPion1Y + 70);
        }
    }

    public void listenerPion() {

        pion1.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        break;
                    case MotionEvent.ACTION_MOVE:
                        int x_cord = (int) event.getRawX();
                        int y_cord = (int) event.getRawY();

                        //Center image on finger
                        pion1.setX(x_cord - (pion1.getWidth() / 2));
                        pion1.setY(y_cord - (pion1.getHeight() / 2));

                        break;
                    case MotionEvent.ACTION_UP:
                        /*
                        if (verifCase())
                            lauchQuestion();
                         */
                        break;
                    default:
                        break;
                }
                return true;
            }
        });

        pion2.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        break;
                    case MotionEvent.ACTION_MOVE:
                        int x_cord = (int) event.getRawX();
                        int y_cord = (int) event.getRawY();

                        //Center image on finger
                        pion2.setX(x_cord - (pion2.getWidth() / 2));
                        pion2.setY(y_cord - (pion2.getHeight() / 2));

                        break;
                    default:
                        break;
                }
                return true;
            }
        });

        pion3.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        break;
                    case MotionEvent.ACTION_MOVE:
                        int x_cord = (int) event.getRawX();
                        int y_cord = (int) event.getRawY();

                        //Center image on finger
                        pion3.setX(x_cord - (pion3.getWidth()/2));
                        pion3.setY(y_cord - (pion3.getHeight()/2));

                        break;
                    default:
                        break;
                }
                return true;
            }
        });

        pion4.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        break;
                    case MotionEvent.ACTION_MOVE:
                        int x_cord = (int) event.getRawX();
                        int y_cord = (int) event.getRawY();

                        //Center image on finger
                        pion4.setX(x_cord - (pion4.getWidth()/2));
                        pion4.setY(y_cord - (pion4.getHeight()/2));

                        break;
                    default:
                        break;
                }
                return true;
            }
        });
    }

    public void initPopup() {

        layoutTrouver = (LinearLayout) findViewById(R.id.layoutTrouver);
        //+
        // ,layoutTrouver.setVisibility(View.VISIBLE);
    }
}
