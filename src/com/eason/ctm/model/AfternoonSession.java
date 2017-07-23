package com.eason.ctm.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AfternoonSession extends Session {
    
    boolean flag = false;

    public AfternoonSession() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mmp ");
        date.setHours(0);
        date.setMinutes(0);
        date.setSeconds(0);
        startTime = date;
    }

}
