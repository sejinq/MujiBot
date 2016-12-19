package com.example.sejini.mujibot.synthetic_nervous_system;

import android.os.SystemClock;

import com.example.sejini.mujibot.MainActivity;
import com.example.sejini.mujibot.inner.Emotion;
import com.example.sejini.mujibot.inner.habituation;

import java.util.Random;
import java.util.Timer;

/**
 * Created by dahee on 2016-12-17.
 */

//mainActivity에서 6가지 상황에 따른 버튼 입력을 전달
//        thread 정의    - 버튼 값이 ON인 동안 1초에 한번씩 perceptionSystem의 해당 함수를 불러와 감정별 gain값 계산
//
//        gain값이 70이 넘는 감정들 랜덤 선택
//        선택된 감정 behaviorSystem에 전달
//
//        7초 이내에 버튼이 OFF되면 스레드 종료
//
//        혹은 7초가 지나면 종료
//        선택된 감정 behaviorSystem에 전달

public class motivationSystem extends Thread {
    habituation thread;
    Timer timer;
    int count = 0;
    android.os.Handler handler;
    int state=0;
    //boolean OnOff = false;

    //SelectEmotion();

    public motivationSystem(android.os.Handler handler, int state){
        this.handler = handler;
        this.state = state;
        //this.OnOff = m_OnOff;
    }

    public void run() {
        while (true) {
            if (count >= 7) {
                break;
            }
            if (state == 0) {
                if (MainActivity.is_PICTURE_LIKE) {
                    perceptionSystem.showPictureLike();
                } else {
                    //break;
                }
            } else if (state == 1) {
                if (MainActivity.is_PICTURE_DISLIKE) {
                    perceptionSystem.showPictureDislike();
                } else {
                    //break;
                }
            } else if (state == 2) {
                if (MainActivity.is_PICTURE_TREATMENT) {
                    perceptionSystem.showPictureTreatment();
                } else {
                    // break;
                }
            } else if (state == 3) {
                if (MainActivity.is_EEG_HAPPY) {
                    perceptionSystem.checkEEGhappy();
                } else {
                    // break;
                }
            } else if (state == 4) {
                if (MainActivity.is_EEG_SORROW) {
                    perceptionSystem.checkEEGsorrow();
                } else {
                    //break;
                }
            } else if (state == 5) {
                if (MainActivity.is_EEG_ANGER) {
                    perceptionSystem.checkEEGanger();
                } else {
                    //break;
                }
            }
            count++;

            handler.sendEmptyMessage(0);

            handler.post(new Runnable() {
                public void run() {
                    SelectEmotion();
                }
            });
            SystemClock.sleep(1000);


            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
//        while(true){  //count
//
//
//        } // end while
    } // end run()

    public void SelectEmotion(){
        //List
        int [] s_emotion;
        s_emotion = new int [9];

        int n =0;
        if(Emotion.JOY >= 70){ //리스트
            s_emotion[n] = Emotion.feelJOY;
            n++;
        }
        else if(Emotion.INTEREST >= 70){
            s_emotion[n] = Emotion.feelINTEREST;
            n++;
        }
        else if(Emotion.BOREDOM >= 70){
            s_emotion[n] =  Emotion.feelBOREDOM;
            n++;
        }
        else if(Emotion.SURPRISE >= 70){
            s_emotion[n] =  Emotion.feelSURPRISE;
            n++;
        }
        else if(Emotion.CALM >= 70){
            s_emotion[n] = Emotion.feelCALM;
            n++;
        }
        else if(Emotion.SORROW >= 70){
            s_emotion[n] =  Emotion.feelSORROW;
            n++;
        }
        else if(Emotion.FEAR >= 70){
            s_emotion[n] = Emotion.feelFEAR;
            n++;
        }
        else if (Emotion.DISGUST >= 70){
            s_emotion[n] = Emotion.feelDISGUST;
            n++;
        }
        else if(Emotion.ANGER >= 70){
            s_emotion[n] = Emotion.feelANGER;
            n++;
        }
        if(n >= 1){
            Random random = new Random();
            int randomValue = random.nextInt(n);
            behaviorSystem.checkEmotion(s_emotion[randomValue]);
        }
        else{

        }


    }


}



