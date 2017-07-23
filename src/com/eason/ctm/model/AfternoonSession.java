package com.eason.ctm.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class AfternoonSession extends Session {
    
    boolean flag = false;

    @SuppressWarnings({ "unused", "deprecation" })
	public AfternoonSession() {
        Date date = new Date();
        date.setHours(1);
        date.setMinutes(0);
        date.setSeconds(0);
        startTime = date;
    }

}
