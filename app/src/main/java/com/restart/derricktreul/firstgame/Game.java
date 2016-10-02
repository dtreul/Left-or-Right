package com.restart.derricktreul.firstgame;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Random;


public  abstract class Game extends ActionBarActivity{

    TextView command;
    Random rand;
    String current;
    boolean playing;
    int counter;
//    CountDownTimer c;
    TextView score;
//    int high;
    SharedPreferences pref;
    Button leftButton;
    Button rightButton;
//    Chronometer timer;
//    ProgressBar progressBar;
//    int max;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        rand = new Random();
//        high = pref.getInt("HighScore", 0);
//        c = new GameCountdown(60000, 1000, this);
        command = (TextView) findViewById(R.id.tvCommand);
        command.setTextSize(40);
        counter = 0;
        score = (TextView) findViewById(R.id.tvScore);
        current = "";
        playing = true;
        leftButton = (Button) findViewById(R.id.btnLeft);
        rightButton = (Button) findViewById(R.id.btnRight);
//        timer = (Chronometer) findViewById(R.id.timer);

//        max = 20;
//        progressBar = (ProgressBar) findViewById(R.id.progressBar);
//        progressBar.setMax(max);
//        progressBar.setProgress(0);
//        StartCountdown start = new StartCountdown(3100, 1000, this);
//        start.start();



    }

    public abstract void left(View button);

    public abstract void right(View button);

    void  startGame() {

        leftButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                left(v);
            }
        });

        rightButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                right(v);
            }
        });
//        timer.setBase(SystemClock.elapsedRealtime());
//        timer.start();
//        newCommand();

    }

    void setText(String s) {
        command.setText(s);
    }


    public String getCommand() {
        int r;
        r = rand.nextInt(2);
        if (r == 0) {
            return "Left";
        } else if (r == 1) {
            return "Right";
        } else {
            return "uh oh";
        }
    }

    void newCommand() {
//        progressBar.setProgress(counter);
        current = getCommand();
        command.setText(current);
//        score.setText(String.valueOf(counter));

    }

//    void gameOver() {
//        boolean changed = false;
//        if (counter > high) {
//            high = counter;
//            changed = true;
//        }
//        if (changed) {
//            SharedPreferences.Editor scoreChanger = pref.edit();
//            scoreChanger.putInt("HighScore", high);
//            scoreChanger.apply();
//        }
//
//        timer.stop();
////        timer.
//
//        Intent intent = new Intent(this, GameOver.class);
//        startActivity(intent);
//        finish();
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_play, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
