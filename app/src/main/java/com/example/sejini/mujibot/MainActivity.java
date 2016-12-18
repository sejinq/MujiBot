package com.example.sejini.mujibot;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    boolean is_PICTURE_LIKE = false;
    boolean is_PICTURE_DISLIKE = false;
    boolean is_PICTURE_TREATMENT = false;
    boolean is_EEG_HAPPY = false;
    boolean is_EEG_SORROW = false;
    boolean is_EEG_ANGER = false;
    public static ImageView mujiBot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mujiBot = (ImageView)findViewById(R.id.mujibot);
        Button PICTURE_LIKE = (Button)findViewById(R.id.btn_picture_like);
        Button PICTURE_DISLIKE = (Button)findViewById(R.id.btn_picture_dislike);
        Button PICTURE_TREATMENT = (Button)findViewById(R.id.btn_picture_treatment);
        Button EEG_HAPPY = (Button)findViewById(R.id.btn_eeg_happy);
        Button EEG_SORROW = (Button)findViewById(R.id.btn_eeg_sorrow);
        Button EEG_ANGER = (Button)findViewById(R.id.btn_eeg_anger);

    }
}
