# MujiBot
소셜로봇 mujibot입니다

MujiBot

모바일 환경의 소셜 로봇을 이용한 조현병 환자의 감정 인지치료 시스템 설계 및 구현

##실행영상

https://www.youtube.com/watch?v=nCehhk19qo4&t=36s


소셜로봇 mujibot입니다

    조현병의 사회 인지 장애가 크게 나타나는 정신 질환이다. 
    이는 약물 치료 이외의 치료가 매우 어렵거나 불가능하다고 생각되어 왔다. 
    하지만 약물 치료는 여러 부작용들을 야기하기 때문에 소셜 로봇을 활용한 새로운 치료 방법이 필요하다. 
    따라서 본 프로젝트에서는 많은 사회 인지 장애 중 감정 인식에 초점을 맞춰 환자의 감정을 시각적으로 보여주는 소셜 로봇 시스템을 설계 및 구현한다. 
    본 시스템에서는 뇌파 측정 데이터를 이용하여 환자들의 감정 시스템을 설계하고 이를 소셜 로봇에 주입한다. 
    그리고 감정을 직면할 수 있는 상황을 8가지로 설정해 로봇이 상황에 맞게 반응하도록 한다. 
    이를 통해 환자에게 상황에 따른 감정의 당위성을 부여 하여 인지 능력을 향상시키는 것이 목적이다.



내부설계

###inner
- emotion : mujibot의 감정 상태를 저장
  - 모든 감정은 기본 값으로 50이 설정되어 있다
  - emotion flag는 다음과 같이 정의된다.
  
```
    public static int feelJOY=0; //joy 감정발현
    public static int feelINTEREST=1; //interest 감정발현
    public static int feelBOREDOM=2; //boredom 감정발현
    public static int feelSURPRISE=3; //surprise 감정발현
    public static int feelCALM=4; //calm 감정발현
    public static int feelSORROW=5; //sorrow 감정발현
    public static int feelFEAR=6; //fear 감정발현
    public static int feelDISGUST=7; //disgust 감정발현
    public static int feelANGER=8; //anger 감정발현
    
```
<br> 
- habituation: habituation effect 7초 
  - 하나의 자극이 7초동안 유지되면 다시 50의 기본값으로 돌아오려는 항상성을 가짐
  - thread 정의
    - 내부 감정 상태가 50인 default 값이 될 때까지 1초에 4씩 줄어드는 스레드
    - 1초마다 내부 상태의 값이 ui에 보여지게 된다
    - 새로운 자극이 들어오면 중간에 스레드 종료
    
- PhysiologicalNeed 생리욕 발현
  - 졸림 ->  startSleepyTimer
     - 10초부터 20초 간격으로 나타남 (10,30,50초..)
     - 3초간 지속
  - 배고픔 -> startHungryTimer 
     - 20초부터 20초 간격으로 나타남 (20,40초..) 
     - 4초간 지속
     
- 우선순위 (생리욕구 > 감정)
    - 생리욕구가 발현되었을 때는 다른 감정 발현 잠시 중단
    - 생리욕구가 사라지면 다른 감정 발현 다시 시작
  
  //설계에서는 
  //졸림은 3시간마다 발현, 20초간 지속
  //배고픔은 4시간마다 발현, 10초간 지속
  //이었으나 확인을 위해 시간을 줄여서 구현
    
<br>
###synthetic_nervous_system

- attentionSystem : 자극에 반응
  - 추후에 보완 예정
- perceptionSystem : 자극을 판단하는 시스템
  - social releasers/stimulation 인지 판단
    - Button의 id값으로 판별
      - btn_picture_like - 사용자가 좋아하는 사진을 보여준다.
      - btn_picture_dislike - 사용자가 싫어하는 사진을 보여준다.
      - btn_picture_treatment - 사용자에게 마음을 진정시키는 차분한 느낌의 사진을 보여준다
      - btn_eeg_happy - 사용자의 감정이 행복하다는 것을 나타내는 뇌파 신호를 보여준다.
      - btn_eeg_sorrow - 사용자의 감정이 슬프다는 것을 나타내는 뇌파 신호를 보여준다.
      - btn_eeg_anger - 사용자의 감정이 화났다는 것을 나타내는 뇌파 신호를 보여준다.
    - TouchMotion 으로 판별
      - onClick - 사용자가 톡톡 두드려서 주목시킨다.
      - swipe motion - 사용자가 때리는 행동이다.스와이프를 통해 표현한다.
        
  - 센서의 값을 symbolization
    - btn_picture_like > PICTURE_LIKE
    - btn_picture_dislike > PICTURE_DISLIKE
    - btn_picture_treatment  > PICTURE_TREATMENT
    - btn_eeg_happy > EEG_HAPPY
    - btn_eeg_sorrow  > EEG_SORROW
    - btn_eeg_anger > EEG_ANGER
    - onClick  > BODY_TOUCHED
    - swipe motion > BODY_SWIPED
      
  - 자극에 따른 gain값을 motivation system에 전달
    - 함수로 gain값을 inner 감정에 더해준다( JOY/BOREDOM/INTEREST/SURPRISE/SORROW/CALM/FEAR/DISGUST/ANGER)
      - void showPictureLike() : PICTURE_LIKE 자극이 들어왔을 때 감정에 gain값을 준다
        gain 값 : (0.5/ -0.3/ 0.5/ 0.1/ -0.3/ -0.1/ -0.3/ -0.2/ -0.3)
      - void showPictureDislike() : PICTURE_DISLIKE 자극이 들어왔을 때 감정에 gain값을 준다
        gain 값 : (-0.3/ 0.3/ -0.3/ -0.1/ 0.2/ 0.1/ 0.2/ 0.5/ 0.5)
      - void showPictureTreatment() : PICTURE_TREATMENT 자극이 들어왔을 때 감정에 gain값을 준다
        gain 값 : (0.1/ -0.1/ 0.1/ -0.1/ -0.1/ 0.3/ -0.1/ -0.1/ -0.1)
      - void checkEEGhappy() : EEG_HAPPY 뇌파를 받아들였을 때 감정에 gain값을 줌
        gain 값 : (0.5/ -0.1/ 0.1/ 0.1/ -0.5/ -0.1/ -0.1/ -0.1/ -0.2)
      - void checkEEGsorrow() : EEG_SORROW 뇌파를 받아들였을 때 감정에 gain값을 줌
        gain 값 : (-0.5/ -0.1/ 0.1/ 0.1/ 0.5/ -0.1/  0.1/ 0.1/ 0.2)
      - void checkEEGanger() : EEG_ANGER 뇌파를 받아들였을 때 감정에 gain값을 줌
        gain 값 : (-0.4/ -0.1/ 0.1/ 0.5/ 0.2/ -0.1/ 0.1/ 0.1/ 0.5)
      - void hitMujibot() : BODY_SWIPED 자극이 들어왔을 때 감정에 gain값을 줌
        gain 값 : (0.2/ -0.5/ 0.5/ 0.2/ -0.2/ -0.1/ 0.1/ -0.1/ -0.1)
      - void petMujibot() :  BODY_TOUCHED 자극이 들어왔을 때 감정에 gain값을 줌
        gain 값 : (-0.2/ -0.1/ 0.1/ 0.5/ 0.2/ -0.2/ 0.5/ 0.2/ 0.5)
        

- motivationSystem :  값에 따른 감정 상태 판단
  - mainActivity에서 6가지 상황에 따른 버튼 입력을 전달
  - thread 정의
    - 버튼 값이 ON인 동안 1초에 한번씩 perceptionSystem의 해당 함수를 불러와 감정별 gain값 계산
    - gain값이 70이 넘는 감정들 랜덤 선택
    - 선택된 감정 behaviorSystem에 전달
    
    - 7초 이내에 버튼이 OFF되면 스레드 종료
    - 혹은 7초가 지나면 종료
 - 선택된 감정 behaviorSystem에 전달
    

- behaviorSystem : 감정상태에 따른 행동 선택
    - checkEmotion(int emotion) 
      - int emotion은 Emotion.java에 있는 emotion flag를 뜻한다
      - motivation system에서 받아온 감정을 행동과 매치
- 감정에 따른 여러 행동들 중 하나를 random()를 이용해 랜덤하게 선택
- 선택된 행동을 view에 전달


