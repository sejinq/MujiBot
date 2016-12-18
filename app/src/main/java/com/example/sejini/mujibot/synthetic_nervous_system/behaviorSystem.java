package com.example.sejini.mujibot.synthetic_nervous_system;

import com.example.sejini.mujibot.MainActivity;
import com.example.sejini.mujibot.R;
import com.example.sejini.mujibot.inner.Emotion;

import java.util.Random;

/**
 * Created by dahee on 2016-12-17.
 */

public class behaviorSystem {
    public static void checkEmotion(int emotion){
        Random random = new Random();
        int randomValue = random.nextInt(3);

        if(emotion == Emotion.feelJOY){
            JOYBehavior(randomValue);
        }
        else if(emotion == Emotion.feelINTEREST){
            INTERESTBehavior(randomValue);
        }
        else if(emotion == Emotion.feelANGER){
            ANGERBehavior(randomValue);
        }
        else if(emotion == Emotion.feelBOREDOM){
            BOREDOMBehavior(randomValue);
        }
        else if(emotion == Emotion.feelCALM){
            CALMBehavior(randomValue);
        }
        else if(emotion == Emotion.feelDISGUST){
            DISGUSTBehavior(randomValue);
        }
        else if(emotion == Emotion.feelFEAR){
            FEARBehavior(randomValue);
        }
        else if(emotion == Emotion.feelSORROW){
            SORROWBehavior(randomValue);
        }
        else if(emotion == Emotion.feelSURPRISE){
            SURPRISEBehavior(randomValue);
        }
        else{
            return;
        }
    }

    private static void DISGUSTBehavior(int randomValue) {
        switch (randomValue){
            case 0:
                MainActivity.mujiBot.setImageResource(R.drawable.disgust1);break;
            case 1:
                MainActivity.mujiBot.setImageResource(R.drawable.disgust2);break;
            case 2:
                MainActivity.mujiBot.setImageResource(R.drawable.disgust3);break;
            default:
                MainActivity.mujiBot.setImageResource(R.drawable.normal1);
        }
    }

    private static void CALMBehavior(int randomValue) {
        switch (randomValue){
            case 0:
                MainActivity.mujiBot.setImageResource(R.drawable.calm1);break;
            case 1:
                MainActivity.mujiBot.setImageResource(R.drawable.calm2);break;
            case 2:
                MainActivity.mujiBot.setImageResource(R.drawable.calm3);break;
            default:
                MainActivity.mujiBot.setImageResource(R.drawable.normal1);
        }
    }

    private static void FEARBehavior(int randomValue) {
        switch (randomValue){
            case 0:
                MainActivity.mujiBot.setImageResource(R.drawable.fear1);break;
            case 1:
                MainActivity.mujiBot.setImageResource(R.drawable.fear2);break;
            case 2:
                MainActivity.mujiBot.setImageResource(R.drawable.fear3);break;
            default:
                MainActivity.mujiBot.setImageResource(R.drawable.normal1);
        }
    }

    private static void SORROWBehavior(int randomValue) {
        switch (randomValue){
            case 0:
                MainActivity.mujiBot.setImageResource(R.drawable.sorrow1);break;
            case 1:
                MainActivity.mujiBot.setImageResource(R.drawable.sorrow2);break;
            case 2:
                MainActivity.mujiBot.setImageResource(R.drawable.sorrow3);break;
            default:
                MainActivity.mujiBot.setImageResource(R.drawable.normal1);
        }
    }

    private static void SURPRISEBehavior(int randomValue) {
        switch (randomValue){
            case 0:
                MainActivity.mujiBot.setImageResource(R.drawable.surprise);break;
            case 1:
                MainActivity.mujiBot.setImageResource(R.drawable.surprise2);break;
            case 2:
                MainActivity.mujiBot.setImageResource(R.drawable.surprise3);break;
            default:
                MainActivity.mujiBot.setImageResource(R.drawable.normal1);
        }
    }

    private static void BOREDOMBehavior(int randomValue) {
        switch (randomValue){
            case 0:
                MainActivity.mujiBot.setImageResource(R.drawable.boredom1);break;
            case 1:
                MainActivity.mujiBot.setImageResource(R.drawable.boredom2);break;
            case 2:
                MainActivity.mujiBot.setImageResource(R.drawable.boredom3);break;
            default:
                MainActivity.mujiBot.setImageResource(R.drawable.normal1);
        }
    }

    private static void ANGERBehavior(int randomValue) {
        switch (randomValue){
            case 0:
                MainActivity.mujiBot.setImageResource(R.drawable.anger1);break;
            case 1:
                MainActivity.mujiBot.setImageResource(R.drawable.anger2);break;
            case 2:
                MainActivity.mujiBot.setImageResource(R.drawable.anger3);break;
            default:
                MainActivity.mujiBot.setImageResource(R.drawable.normal1);
        }
    }

    private static void INTERESTBehavior(int randomValue) {
        switch (randomValue){
            case 0:
                MainActivity.mujiBot.setImageResource(R.drawable.interest1);break;
            case 1:
                MainActivity.mujiBot.setImageResource(R.drawable.interest2);break;
            case 2:
                MainActivity.mujiBot.setImageResource(R.drawable.interest3);break;
            default:
                MainActivity.mujiBot.setImageResource(R.drawable.normal1);
        }
    }

    private static void JOYBehavior(int randomValue) {
        switch (randomValue){
            case 0:
                MainActivity.mujiBot.setImageResource(R.drawable.joy1);break;
            case 1:
                MainActivity.mujiBot.setImageResource(R.drawable.joy2);break;
            case 2:
                MainActivity.mujiBot.setImageResource(R.drawable.joy3);break;
            default:
                MainActivity.mujiBot.setImageResource(R.drawable.normal1);
        }
    }
}
