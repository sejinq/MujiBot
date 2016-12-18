package com.example.sejini.mujibot.inner;

import java.util.Calendar;

/**
 * Created by sejini on 2016-12-18.
 */

public class PhysiologicalNeed {
    private final Calendar c = Calendar.getInstance();
    private Calendar calSet = (Calendar) c.clone();

//    calSet.set(Calendar.HOUR_OF_DAY, 10);
//    calSet.set(Calendar.MINUTE, 2);
//    calSet.set(Calendar.SECOND, 0);
//    calSet.set(Calendar.MILLISECOND, 0);

}
//버튼이 온이 되었을 때 start시간 시작
//어플 시작할 때 start타임 시작 main 에서 체크 현재 시간 비교 4시간이