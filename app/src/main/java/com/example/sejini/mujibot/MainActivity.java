package com.example.sejini.mujibot;

import android.os.Bundle;
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
    public static ImageView mujiBot;
    perceptionSystem perception = new perceptionSystem();
    int timePet=0;
    int timeSwipe=0;
    static TextView joyText;
    static TextView interestText;
    static TextView angerText;
    static TextView boredomText;
    static TextView calmText;
    static TextView disgustText;
    static TextView fearText;
    static TextView sorrowText;
    static TextView surpriseText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
                //motivation에서 감정 판단되면
                if(timePet<7){
                    perception.petMujibot();
                    timePet++;
                    showInnerState();
                }
                else{
                    timePet=0;
                    habituation thread = new habituation();
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
}
