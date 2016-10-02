package com.restart.derricktreul.firstgame;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;


public class MainActivity extends ActionBarActivity {

    private int highScore;
    TextView scoreVal;
    SharedPreferences pref;
    public static final String PREFS_NAME = "HIGH SCORE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pref = getSharedPreferences(PREFS_NAME, 0);
        highScore = 0;
        highScore = pref.getInt("HighScore", 0);
        double timeScore = (double)highScore/1000.0;
        String showScore = String.format("%.2f",timeScore);
        scoreVal = (TextView) findViewById(R.id.tvHighScore);
        scoreVal.setText(showScore + " seconds");

    }


    public void playGame(View view) {
        Intent intent = new Intent(this, Mode.class);
        startActivity(intent);
        finish();
    }

    public void exit(View view) {
        finish();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
