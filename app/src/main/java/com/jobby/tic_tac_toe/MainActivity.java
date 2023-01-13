package com.jobby.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    boolean gameactive = true;
    int activeplayer = 0;
    int[] gamestate = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int[][] winpos = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8},
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
            {0, 4, 8}, {2, 4, 6}};
    String winnerstr;

    public void gamereset(View view) {
        gameactive = true;
        activeplayer = 0;
        for (int i = 0; i < gamestate.length; i++) {
            gamestate[i] = 2;
        }
        ((ImageView) findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView8)).setImageResource(0);

        TextView status = findViewById(R.id.status);
        status.setText("X's Turn To Play");
    }

    public void playertap(View view) {
        ImageView img = (ImageView) view;
        int tappedimage = Integer.parseInt(img.getTag().toString());
        if (!gameactive) {
            gamereset(view);
        }
            if (gamestate[tappedimage] == 2) {
                gamestate[tappedimage] = activeplayer;
                img.setTranslationY(-1000f);
                if (activeplayer == 0) {
                    img.setImageResource(R.drawable.x);
                    activeplayer = 1;
                    TextView status = findViewById(R.id.status);
                    status.setText("O's Turn To Play");
                }
                else {
                    img.setImageResource(R.drawable.o);
                    activeplayer = 0;
                    TextView status = findViewById(R.id.status);
                    status.setText("X's Turn To Play");
                }
                img.animate().translationYBy(1000f).setDuration(300);
            }
//    Winning Function
            for (int[] wins : winpos) {
                if (gamestate[wins[0]] == gamestate[wins[1]] &&
                        gamestate[wins[1]] == gamestate[wins[2]] &&
                        gamestate[wins[0]] != 2) {
                    gameactive = false;
                    if (gamestate[wins[0]] == 0) {
                        winnerstr = "X Has Won";
                    } else {
                        winnerstr = "O Has Won";
                    }

                    TextView status = findViewById(R.id.status);
                    status.setText(winnerstr);
                }
                }
        }


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
        }
    }

