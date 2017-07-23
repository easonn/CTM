package com.eason.ctm.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Session {
    
    public Date startTime;

    List<Talk> talkList = new ArrayList<Talk>();

    boolean flag;

    public void addTalk(Talk talk) {
        this.startTime = Tools.getNextStartTime(startTime, talk);
        talkList.add(talk);
    }

}
