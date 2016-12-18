package com.example.sejini.mujibot.synthetic_nervous_system;
//perceptionSystem -

import com.example.sejini.mujibot.inner.Emotion;

/**
 * Created by dahee on 2016-12-17.
 */

public class perceptionSystem {

    //( JOY/BOREDOM/INTEREST/SURPRISE/SORROW/CALM/FEAR/DISGUST/ANGER)
    public void showPictureLike(){
        Emotion.JOY += 0.5;
        Emotion.INTEREST += 0.5;
        Emotion.BOREDOM -= 0.3;
        Emotion.SURPRISE += 0.1;
        Emotion.CALM -= 0.1;
        Emotion.SORROW -= 0.3;
        Emotion.FEAR -= 0.3;
        Emotion.DISGUST -= 0.2;
        Emotion.ANGER -= 0.3;

    }

    public void showPictureDislike(){
        Emotion.JOY -= 0.3;
        Emotion.INTEREST -= 0.3;
        Emotion.BOREDOM += 0.3;
        Emotion.SURPRISE -= 0.1;
        Emotion.CALM += 0.1;
        Emotion.SORROW += 0.2;
        Emotion.FEAR += 0.2;
        Emotion.DISGUST += 0.5;
        Emotion.ANGER += 0.5;

    }

    public void showPictureTreatment(){
        Emotion.JOY += 0.1;
        Emotion.INTEREST += 0.1;
        Emotion.BOREDOM -= 0.1;
        Emotion.SURPRISE -= 0.1;
        Emotion.CALM += 0.3;
        Emotion.SORROW -= 0.1;
        Emotion.FEAR -= 0.1;
        Emotion.DISGUST -= 0.1;
        Emotion.ANGER -= 0.1;

    }
    public void checkEEGhappy(){
        Emotion.JOY += 0.5;
        Emotion.INTEREST += 0.1;
        Emotion.BOREDOM -= 0.1;
        Emotion.SURPRISE += 0.1;
        Emotion.CALM -= 0.1;
        Emotion.SORROW -= 0.5;
        Emotion.FEAR -= 0.1;
        Emotion.DISGUST -= 0.1;
        Emotion.ANGER -= 0.2;

    }

    public void checkEEGsorrow(){
        Emotion.JOY -= 0.5;
        Emotion.INTEREST += 0.1;
        Emotion.BOREDOM -= 0.1;
        Emotion.SURPRISE += 0.1;
        Emotion.CALM -= 0.1;
        Emotion.SORROW += 0.5;
        Emotion.FEAR += 0.1;
        Emotion.DISGUST += 0.1;
        Emotion.ANGER += 0.2;

    }

    public void checkEEGanger(){
        Emotion.JOY -= 0.4;
        Emotion.INTEREST += 0.1;
        Emotion.BOREDOM -= 0.1;
        Emotion.SURPRISE += 0.5;
        Emotion.CALM -= 0.1;
        Emotion.SORROW += 0.2;
        Emotion.FEAR += 0.1;
        Emotion.DISGUST += 0.1;
        Emotion.ANGER += 0.5;

    }

    public void hitMujibot(){
        Emotion.JOY -= 0.2;
        Emotion.INTEREST += 0.1;
        Emotion.BOREDOM -= 0.1;
        Emotion.SURPRISE += 0.5;
        Emotion.CALM -= 0.2;
        Emotion.SORROW += 0.2;
        Emotion.FEAR += 0.5;
        Emotion.DISGUST += 0.2;
        Emotion.ANGER += 0.5;

    }

    public void petMujibot(){
        Emotion.JOY += 0.2;
        Emotion.INTEREST += 0.5;
        Emotion.BOREDOM -= 0.5;
        Emotion.SURPRISE += 0.2;
        Emotion.CALM -= 0.1;
        Emotion.SORROW -= 0.2;
        Emotion.FEAR += 0.1;
        Emotion.DISGUST -= 0.1;
        Emotion.ANGER -= 0.1;

    }


}
