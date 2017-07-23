package com.eason.ctm.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Tools {

    public static Date getNextStartTime(Date date, Talk talk) {
        long timeNow = date.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mma ");
        talk.setStartTime(dateFormat.format(date));

        long talkTime = talk.getTimer() * 60 * 1000;
        long newStartTime = timeNow + talkTime;

        date.setTime(newStartTime);
        return date;
    }

}
