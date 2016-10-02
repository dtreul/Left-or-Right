package com.restart.derricktreul.firstgame;

import android.os.CountDownTimer;

/**
 * Created by Derrick Treul on 6/27/2015.
 */
public class GameCountdown extends CountDownTimer{

    Quick fun;

    public GameCountdown(long millisInFuture, long countDownInterval, Quick game){
        super(millisInFuture, countDownInterval);
        fun = game;
    };

    @Override
    public void onTick(long millisUntilFinished) {
        fun.newCommand();
    }

    @Override
    public void onFinish() {

    }


}
