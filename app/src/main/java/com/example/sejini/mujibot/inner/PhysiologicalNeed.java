package com.example.sejini.mujibot.inner;

import android.os.Handler;

import com.example.sejini.mujibot.MainActivity;
import com.example.sejini.mujibot.R;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by sejini on 2016-12-18.
 */

//배고픔 4시간마다
//졸리움 3시간마다
//1초 1000 10초 10000
    //60초 1분 60000
    //60분 1시간 360000
    //3시간  10800000
    //4시간  14400000

public class PhysiologicalNeed extends Thread{  //다른 방법으로 강제 종료
    Timer timer_hungry;
    Timer timer_sleepy;
    Timer start_timer_hungry;
    Timer start_timer_sleepy;
    int count_hungry = 0;
    int count_sleepy = 0;
    Handler handler;

    public PhysiologicalNeed(Handler handler){
        this.handler = handler;
    }

    public void startTimer() //타이머가 시작된다.
    {
        timer_sleepy = new Timer();
        timer_sleepy.schedule(new TimerTask()
        {
            @Override
            public void run()
            {
                update_sleepy();
                count_sleepy++;
            }
        }, 20000, 20000); //졸리움 타이머는 함수 호출 후 바로 타이머가 시작, 3시간 마다 반복된다. 10800000

        timer_hungry = new Timer();
        timer_hungry.schedule(new TimerTask()
        {
            @Override
            public void run()
            {
                update_hungry();
                count_hungry++;
            }
        }, 10000, 10000); //배고픔 타이머는 함수 호출 후 바로 타이머가 시작, 4시간 마다 반복된다. 14400000

    }

    public void stopTimer()
    {
        timer_hungry.cancel();
        timer_sleepy.cancel();
        start_timer_hungry.cancel();
        start_timer_sleepy.cancel();
    }

    public void update_sleepy() {
        Runnable updater = new Runnable() {
            public void run() {
                MainActivity.mujiBot_sleepy.setImageResource(R.drawable.hunger);
                startSleepyTimer(); //졸리움이 발현되고 졸리움 지속시간 관리 타이머 시작
            }
        };
        handler.post(updater);
    }

    public void update_hungry() {
        Runnable updater = new Runnable() {
            public void run() {
                MainActivity.mujiBot_sleepy.setImageResource(R.drawable.hunger);
                //startHungryTimer(); //배고픔이 발현되고 배고픔픔 속시간 관리 타이머 시작
            }
        };
        handler.post(updater);
    }

    ////////////////생리욕이 발현되고 지속시간이 지나면 그만둬야함 쓰레드가 필요할까///////////////////////
    private void startSleepyTimer(){
        start_timer_sleepy = new Timer();
        start_timer_sleepy.schedule(new TimerTask()
        {
            @Override
            public void run()
            {
                update_s();
            }
        }, 5000);  //20초 뒤에 졸리움 사라짐 -> 10초 뒤 새로운 자극이 오면 사라짐...은 어떻게 하지!!! 생각생각생각
    }

    private void startHungryTimer(){
        start_timer_hungry = new Timer();
        start_timer_hungry.schedule(new TimerTask()
        {
            @Override
            public void run()
            {
                update_h();
            }
        }, 2000);  //10초 뒤에 배고픔 사라짐
    }

    public void update_s() {
        Runnable updater = new Runnable() {
            public void run() {
                MainActivity.mujiBot_hungry.setImageResource(R.drawable.okay);
            }
        };
        handler.post(updater);
    }

    public void update_h() {
        Runnable updater = new Runnable() {
            public void run() {
                MainActivity.mujiBot_hungry.setImageResource(R.drawable.okay);
            }
        };
        handler.post(updater);
    }

}