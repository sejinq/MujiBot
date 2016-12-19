package com.example.sejini.mujibot.synthetic_nervous_system;

import com.example.sejini.mujibot.MainActivity;
import com.example.sejini.mujibot.inner.Emotion;
import com.example.sejini.mujibot.inner.habituation;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

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
    boolean OnOff = false;
    boolean ishabituation = false;

    //SelectEmotion();

    public motivationSystem(android.os.Handler handler, int state, boolean m_OnOff){
        this.handler = handler;
        this.state = state;
        this.OnOff = m_OnOff;
    }

    public void run() {
        while(true){  //count
            if(!ishabituation){
                if(!OnOff){
                    if(state == 0){
                        perceptionSystem.showPictureLike();
                    }
                    else if(state==1){
                        perceptionSystem.showPictureDislike();
                    }
                    else if(state ==2){
                        perceptionSystem.showPictureTreatment();
                    }
                    else if(state==3){
                        perceptionSystem.checkEEGhappy();
                    }
                    else if(state==4){
                        perceptionSystem.checkEEGsorrow();
                    }
                    else if(state==5){
                        perceptionSystem.checkEEGanger();
                    }
                }
                else {
                    //nothing 노 반응/??3
                }

                count ++;
                MainActivity.showInnerState();
                //MainActivity.habituationState[state] = false;
                break;
            }
            else{
                // 메인에서 생성된 Handler 객체의 sendEmpryMessage 를 통해 Message 전달
                handler.sendEmptyMessage(0);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } // end while
    } // end run()

    public void SelectEmotion(){
        int [] s_emotion;
        s_emotion = new int [9];

        int n =0;
        if(Emotion.JOY >= 70){
            s_emotion[n] = 0;
            n++;
        }
        else if(Emotion.INTEREST >= 70){
            s_emotion[n] = 1;
            n++;
        }
        else if(Emotion.BOREDOM >= 70){
            s_emotion[n] = 2;
            n++;
        }
        else if(Emotion.SURPRISE >= 70){
            s_emotion[n] = 3;
            n++;
        }
        else if(Emotion.CALM >= 70){
            s_emotion[n] = 4;
            n++;
        }
        else if(Emotion.SORROW >= 70){
            s_emotion[n] = 5;
            n++;
        }
        else if(Emotion.FEAR >= 70){
            s_emotion[n] = 6;
            n++;
        }
        else if (Emotion.DISGUST >= 70){
            s_emotion[n] = 7;
            n++;
        }
        else if(Emotion.ANGER >= 70){
            s_emotion[n] = 8;
            n++;
        }
        Random random = new Random();
        int randomValue = random.nextInt(n-1);
        behaviorSystem.checkEmotion(s_emotion[randomValue]);

    }


    public void StartTimer(int m_state){  //7초 확인 후 habituation실행
        final int state = m_state;
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                ishabituation = true;
                thread = new habituation(handler, state);
                thread.setDaemon(true);
                thread.start();
            }
        }, 7000);    //7초 뒤에 habituation 실행행
    }
    public void StopTimer(){ //버튼 OFF들어오면 while문 실행 노노 아!!!
        timer.cancel();
        //ishabituation = false;
    }

}



