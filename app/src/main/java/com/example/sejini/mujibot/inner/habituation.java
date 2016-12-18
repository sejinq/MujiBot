package com.example.sejini.mujibot.inner;

import android.os.Message;

import com.example.sejini.mujibot.MainActivity;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

/**
 * Created by sejini on 2016-12-18.
 */

public class habituation extends Thread  {
    final Handler handler = new Handler()

    {

        @Override
        public void publish(LogRecord logRecord) {

        }

        @Override
        public void flush() {

        }

        @Override
        public void close() throws SecurityException {

        }

        public void handleMessage(Message msg)

        {

            // 원래 하고싶었던 일들 (UI변경작업 등...)

        }

    };
    @Override
    public void run() {
        while (true) {
            if(!habituationEffect()){
                break;
            }
            try {
                Thread.sleep(1000);
                Message msg = handler.obtainMessage();
                handler.sendMessage(msg);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean habituationEffect() {
        boolean newStimulation = false;
        if (Emotion.JOY > 50) {
            if (Emotion.JOY < 55) Emotion.JOY = 50;
            else {
                Emotion.JOY -= 4;
            }
            newStimulation = true;
        } else if (Emotion.JOY < 50) {
            Emotion.JOY += 4;
            newStimulation = true;
        }
        if (Emotion.ANGER > 50) {
            if (Emotion.ANGER < 55) Emotion.ANGER = 50;
            else {
                Emotion.ANGER -= 4;
            }
            newStimulation = true;
        } else if (Emotion.ANGER < 50) {
            Emotion.ANGER += 4;
            newStimulation = true;
        }
        if (Emotion.BOREDOM > 50) {
            if (Emotion.BOREDOM < 55) Emotion.BOREDOM = 50;
            else {
                Emotion.BOREDOM -= 4;
            }
            newStimulation = true;
        } else if (Emotion.BOREDOM < 50) {
            Emotion.BOREDOM += 4;
            newStimulation = true;
        }
        if (Emotion.CALM > 50) {
            if (Emotion.CALM < 55) Emotion.CALM = 50;
            else {
                Emotion.CALM -= 4;
            }
            newStimulation = true;
        } else if (Emotion.CALM < 50) {
            Emotion.CALM += 4;
            newStimulation = true;
        }
        if (Emotion.DISGUST > 50) {
            if (Emotion.DISGUST < 55) Emotion.DISGUST = 50;
            else {
                Emotion.DISGUST -= 4;
            }
            newStimulation = true;
        } else if (Emotion.DISGUST < 50) {
            Emotion.DISGUST += 4;
            newStimulation = true;
        }
        if (Emotion.FEAR > 50) {
            if (Emotion.FEAR < 55) Emotion.FEAR = 50;
            else {
                Emotion.FEAR -= 4;
            }
            newStimulation = true;
        } else if (Emotion.FEAR < 50) {
            Emotion.FEAR += 4;
            newStimulation = true;
        }
        if (Emotion.SORROW > 50) {
            if (Emotion.SORROW < 55) Emotion.SORROW = 50;
            else {
                Emotion.SORROW -= 4;
            }
            newStimulation = true;
        } else if (Emotion.SORROW < 50) {
            Emotion.SORROW += 4;
            newStimulation = true;
        }
        if (Emotion.SURPRISE > 50) {
            if (Emotion.SURPRISE < 55) Emotion.SURPRISE = 50;
            else {
                Emotion.SURPRISE -= 4;
            }
            newStimulation = true;
        } else if (Emotion.SURPRISE < 50) {
            Emotion.SURPRISE += 4;
            newStimulation = true;
        }
        if (Emotion.INTEREST > 50) {
            if (Emotion.INTEREST < 55) Emotion.INTEREST = 50;
            else {
                Emotion.INTEREST -= 4;
            }
            newStimulation = true;
        } else if (Emotion.INTEREST < 50) {
            Emotion.INTEREST += 4;
            newStimulation = true;
        }
        MainActivity.showInnerState();
        return newStimulation;
    }
}
