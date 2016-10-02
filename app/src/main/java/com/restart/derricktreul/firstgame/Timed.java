package com.restart.derricktreul.firstgame;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Random;


public class Timed extends Game {

    //    TextView command;
//    Random rand;
//    String current;
//    boolean playing;
    int counter;
    //    CountDownTimer c;
//    TextView score;
    int highScore;
    //    SharedPreferences pref;
//    Button leftButton;
//    Button rightButton;
//    Chronometer timer;
    TextView timer;
    ProgressBar progressBar;
    long startTime;
    int max;
    //    long endTime;
//    GameTimer countup;
    CountDownTimer countdown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        countdown = new CountDownTimer(20000,100) {
            @Override
            public void onTick(long millisUntilFinished) {
                updateTime(millisUntilFinished);
            }

            @Override
            public void onFinish() {
                gameOver();
            }
        };

        LinearLayout main = (LinearLayout) findViewById(R.id.llCommands);
//        main.addView(progressBar);
        timer = (TextView) findViewById(R.id.tvTimer);
        pref = getSharedPreferences(MainActivity.PREFS_NAME, 0);
        highScore = pref.getInt("HighScore", 1);
//        countup = new GameTimer(this);
        StartCountdown start = new StartCountdown(3100, 1000, this);
        start.start();
//        startTime = System.currentTimeMillis();

    }

    public void left(View button) {

        if (current.equals("Left")) {
            counter++;
            newCommand();
        } else {
            if (counter <= 4) { counter = 0; }
            else {counter -= 5;}
            newCommand();
        }

    }

    public void right(View button) {

        if (current.equals("Right")) {
            counter++;
            newCommand();
        } else {
            if (counter <= 4) { counter = 0; }
            else {counter -= 5;}
            newCommand();
        }

    }
    void setStartTime(long time) {
        startTime = time;
    }

    void startGame() {

        super.startGame();
        countdown.start();
        newCommand();

    }

    void updateTime(long time){
        double otime = ((double)time)/1000.0;
        String out = String.format("%.2f", otime);
        timer.setText(out);
    }


//    private String getCommand() {
//        int r;
//        r = rand.nextInt(2);
//        if (r == 0) {
//            return "Left";
//        } else if (r == 1) {
//            return "Right";
//        } else {
//            return "uh oh";
//        }
//    }

    void newCommand() {
        super.newCommand();
//        progressBar.setProgress(counter);
        score.setText(String.valueOf(counter));

    }

    void gameOver() {
//        long time = countup.stop();

        boolean changed = false;
        if (counter > highScore) {
            highScore = counter;
            changed = true;
        }
        if (changed) {
            SharedPreferences.Editor scoreChanger = pref.edit();
            scoreChanger.putInt("HighScore", counter);
            scoreChanger.apply();
        }

//        timer.stop();
//        timer.

        Intent intent = new Intent(this, GameOver.class);
        intent.putExtra("score", counter);
        intent.putExtra("mode", 2);
        startActivity(intent);
        finish();
    }

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
