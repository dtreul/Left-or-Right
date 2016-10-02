package com.restart.derricktreul.firstgame;

import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;

/**
 * Created by Derrick on 11/3/2015.
 */
public class GameTimer{
    private long base;
    Quick fun;
    private long interval;
    public GameTimer(Quick game) {
        fun = game;
        interval = 10;
    }

    public void start() {
        base = SystemClock.elapsedRealtime();
        handler.sendMessage(handler.obtainMessage(MSG));
    }
    private static final int MSG = 1;

    public void onTick(long elapsedTime) {
        fun.updateTime(elapsedTime);
    }

    public long stop() {
        return SystemClock.elapsedRealtime()-base;
    }
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            synchronized (GameTimer.this) {
                long elapsedTime = SystemClock.elapsedRealtime() - base;
                onTick(elapsedTime);
                sendMessageDelayed(obtainMessage(MSG), interval);
            }
        }
    };

}
