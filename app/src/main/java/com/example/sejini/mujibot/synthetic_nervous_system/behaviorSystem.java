package com.example.sejini.mujibot.synthetic_nervous_system;

import com.example.sejini.mujibot.inner.Emotion;

/**
 * Created by dahee on 2016-12-17.
 */

public class behaviorSystem {
    public static void checkEmotion(int emotion){
        if(emotion == Emotion.feelJOY){
            JOYBehavior();
        }
        else if(emotion == Emotion.feelINTEREST){
            INTERESTBehavior();
        }
        else if(emotion == Emotion.feelANGER){
            ANGERBehavior();
        }
        else if(emotion == Emotion.feelBOREDOM){
            BOREDOMBehavior();
        }
        else if(emotion == Emotion.feelCALM){
            CALMBehavior();
        }
        else if(emotion == Emotion.feelDISGUST){
            DISGUSTBehavior();
        }
        else if(emotion == Emotion.feelFEAR){
            FEARBehavior();
        }
        else if(emotion == Emotion.feelSORROW){
            SORROWBehavior();
        }
        else if(emotion == Emotion.feelSURPRISE){
            SURPRISEBehavior();
        }
        else{
            return;
        }
    }

    private static void DISGUSTBehavior() {

    }

    private static void CALMBehavior() {
    }

    private static void FEARBehavior() {
    }

    private static void SORROWBehavior() {
    }

    private static void SURPRISEBehavior() {
    }

    private static void BOREDOMBehavior() {
    }

    private static void ANGERBehavior() {
    }

    private static void INTERESTBehavior() {
    }

    private static void JOYBehavior() {
    }
}
