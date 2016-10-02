package com.restart.derricktreul.firstgame;

import android.os.CountDownTimer;

/**
 * Created by Derrick Treul on 6/27/2015.
 */
public class StartCountdown extends CountDownTimer {
    /**
     * @param millisInFuture    The number of millis in the future from the call
     *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
     *                          is called.
     * @param countDownInterval The interval along the way to receive
     *                          {@link #onTick(long)} callbacks.
     */

    Game fun;

    public StartCountdown(long millisInFuture, long countDownInterval, Game game) {
        super(millisInFuture, countDownInterval);
        fun = game;
    }

    public void onTick(long millisUntilFinished) {
        fun.setText(String.valueOf((millisUntilFinished / 1000)));
    }

    public void onFinish() {
//        fun.setStartTime(System.currentTimeMillis());
        fun.startGame();
    }
}
