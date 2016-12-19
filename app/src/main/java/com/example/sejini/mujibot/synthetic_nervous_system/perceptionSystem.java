package com.example.sejini.mujibot.synthetic_nervous_system;
//perceptionSystem -

import com.example.sejini.mujibot.inner.Emotion;

/**
 * Created by dahee on 2016-12-17.
 */

public class perceptionSystem {

    //( JOY/BOREDOM/INTEREST/SURPRISE/SORROW/CALM/FEAR/DISGUST/ANGER)
    public static void showPictureLike(){
        Emotion.JOY += 5;
        Emotion.INTEREST += 5;
        Emotion.BOREDOM -= 3;
        Emotion.SURPRISE += 1;
        Emotion.CALM -= 1;
        Emotion.SORROW -= 3;
        Emotion.FEAR -= 3;
        Emotion.DISGUST -= 2;
        Emotion.ANGER -= 3;

    }

    public static void showPictureDislike(){
        Emotion.JOY -= 3;
        Emotion.INTEREST -= 3;
        Emotion.BOREDOM += 3;
        Emotion.SURPRISE -= 1;
        Emotion.CALM += 1;
        Emotion.SORROW += 2;
        Emotion.FEAR += 2;
        Emotion.DISGUST += 5;
        Emotion.ANGER += 5;

    }

    public static void showPictureTreatment(){
        Emotion.JOY += 1;
        Emotion.INTEREST += 1;
        Emotion.BOREDOM -= 1;
        Emotion.SURPRISE -= 1;
        Emotion.CALM += 3;
        Emotion.SORROW -= 1;
        Emotion.FEAR -= 1;
        Emotion.DISGUST -= 1;
        Emotion.ANGER -= 1;

    }
    public static void checkEEGhappy(){
        Emotion.JOY += 5;
        Emotion.INTEREST += 1;
        Emotion.BOREDOM -= 1;
        Emotion.SURPRISE += 1;
        Emotion.CALM -= 1;
        Emotion.SORROW -= 5;
        Emotion.FEAR -= 1;
        Emotion.DISGUST -= 1;
        Emotion.ANGER -= 2;

    }

    public static void checkEEGsorrow(){
        Emotion.JOY -= 5;
        Emotion.INTEREST += 1;
        Emotion.BOREDOM -= 1;
        Emotion.SURPRISE += 1;
        Emotion.CALM -= 1;
        Emotion.SORROW += 5;
        Emotion.FEAR += 1;
        Emotion.DISGUST += 1;
        Emotion.ANGER += 2;

    }

    public static void checkEEGanger(){
        Emotion.JOY -= 4;
        Emotion.INTEREST += 1;
        Emotion.BOREDOM -= 1;
        Emotion.SURPRISE += 5;
        Emotion.CALM -= 1;
        Emotion.SORROW += 2;
        Emotion.FEAR += 1;
        Emotion.DISGUST += 1;
        Emotion.ANGER += 5;

    }

    public static void hitMujibot(){
        Emotion.JOY -= 2;
        Emotion.INTEREST += 1;
        Emotion.BOREDOM -= 1;
        Emotion.SURPRISE += 5;
        Emotion.CALM -= 2;
        Emotion.SORROW += 2;
        Emotion.FEAR += 5;
        Emotion.DISGUST += 2;
        Emotion.ANGER += 5;

    }

    public static void petMujibot(){
        Emotion.JOY += 2;
        Emotion.INTEREST += 5;
        Emotion.BOREDOM -= 5;
        Emotion.SURPRISE += 2;
        Emotion.CALM -= 1;
        Emotion.SORROW -= 2;
        Emotion.FEAR += 1;
        Emotion.DISGUST -= 1;
        Emotion.ANGER -= 1;

    }


}
