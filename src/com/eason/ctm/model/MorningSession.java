package com.eason.ctm.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MorningSession extends Session{
    
    boolean flag = true;
    
    public MorningSession(){
        Date date = new Date( );
        SimpleDateFormat dateFormat = new SimpleDateFormat ("hh:mma ");
        date.setHours(9);
        date.setMinutes(0);
        date.setSeconds(0);
        startTime = date;
    }


}
