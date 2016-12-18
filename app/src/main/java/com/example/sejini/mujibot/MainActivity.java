package com.example.sejini.mujibot;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sejini.mujibot.inner.Emotion;
import com.example.sejini.mujibot.inner.habituation;
import com.example.sejini.mujibot.synthetic_nervous_system.behaviorSystem;
import com.example.sejini.mujibot.synthetic_nervous_system.perceptionSystem;

public class MainActivity extends AppCompatActivity {
    boolean is_PICTURE_LIKE = false;
    boolean is_PICTURE_DISLIKE = false;
    boolean is_PICTURE_TREATMENT = false;
    boolean is_EEG_HAPPY = false;
    boolean is_EEG_SORROW = false;
    boolean is_EEG_ANGER = false;

    /*새로운 자극인지 체크하는 변수 nowStimulation에 현재 자극(버튼이름 또는 touchmotion) nowStimulation에 이름(버튼 id로 하자!) 저장
    이벤트 시 이름이랑 비교해서 새로운 자극이면 newStimulation을 true로 바꿔줌
    mujibo onClick 메서드 참고*/
    String nowStimulation="";
    public static boolean newStimulation = false;

    //0-5 : 버튼 다희가 정해서 사용하면 됨. 6/7 = touch/swipe
    public static boolean[] habituationState = new boolean[8];

    public static ImageView mujiBot;
    perceptionSystem perception = new perceptionSystem();
    public static int timePet=0;
    public static int timeSwipe=0;
    static TextView joyText;
    static TextView interestText;
    static TextView angerText;
    static TextView boredomText;
    static TextView calmText;
    static TextView disgustText;
    static TextView fearText;
    static TextView sorrowText;
    static TextView surpriseText;
    habituation thread;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for(int i=0;i<8;i++){
            habituationState[i] = false;
        }
         joyText = (TextView)findViewById(R.id.value_joy);
         interestText = (TextView)findViewById(R.id.value_interest);
         angerText = (TextView)findViewById(R.id.value_anger);
         boredomText = (TextView)findViewById(R.id.value_boredom);
         calmText = (TextView)findViewById(R.id.value_calm);
         disgustText = (TextView)findViewById(R.id.value_disgust);
         fearText = (TextView)findViewById(R.id.value_fear);
         sorrowText = (TextView)findViewById(R.id.value_sorrow);
         surpriseText = (TextView)findViewById(R.id.value_surprise);
        mujiBot = (ImageView)findViewById(R.id.mujibot);
        mujiBot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //thread상태가 끝났는지 체크 > 자극이 있었는지 7초가 지났다
//                if(timePet==7&&habituationState[6]==false){
//                    timePet = 0;
//                }
//                if(!nowStimulation.equals("touch")){
//                    nowStimulation = "touch";
//                    newStimulation = true;
//                }
                //7번 눌리면 background thread활성화
                if(timePet<7){
                    perception.petMujibot();
                    timePet++;
                    showInnerState();
                }
                else if(timePet>=7&&habituationState[6]==false) {
                    //touch의 habituation thread상태를 true로
                    newStimulation = false;
                    habituationState[6] = true;
                   //habituationstate 배열의 index를 넘겨줌
                    thread = new habituation(handler, 6);
                    thread.setDaemon(true);
                    thread.start();
                }
            }
        });
        Button PICTURE_LIKE = (Button)findViewById(R.id.btn_picture_like);
        Button PICTURE_DISLIKE = (Button)findViewById(R.id.btn_picture_dislike);
        Button PICTURE_TREATMENT = (Button)findViewById(R.id.btn_picture_treatment);
        Button EEG_HAPPY = (Button)findViewById(R.id.btn_eeg_happy);
        Button EEG_SORROW = (Button)findViewById(R.id.btn_eeg_sorrow);
        Button EEG_ANGER = (Button)findViewById(R.id.btn_eeg_anger);

    }
    public static void showInnerState(){
        joyText.setText(String.valueOf(Emotion.JOY));
        interestText.setText(String.valueOf(Emotion.INTEREST));
        angerText.setText(String.valueOf(Emotion.ANGER));
        boredomText.setText(String.valueOf(Emotion.BOREDOM));
        calmText.setText(String.valueOf(Emotion.CALM));
        disgustText.setText(String.valueOf(Emotion.DISGUST));
        fearText.setText(String.valueOf(Emotion.FEAR));
        sorrowText.setText(String.valueOf(Emotion.SORROW));
        surpriseText.setText(String.valueOf(Emotion.SURPRISE));
    }
    final Handler handler = new Handler(){
        public void handleMessage(Message msg){
            showInnerState();
        }
    };
}
