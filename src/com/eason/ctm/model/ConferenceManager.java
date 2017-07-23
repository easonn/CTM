package com.eason.ctm.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;

public class ConferenceManager {

    public static final int MORNING_LIMIT = 180;

    public static final int AFTERNOON_LIMIT = 240;

    public static List<Talk> initTalkList = new ArrayList<Talk>();

    public static List<List<List<Talk>>> trackList = new ArrayList<List<List<Talk>>>();

    static {
        File file = new File("F:/Java/workspace/CTM/conference_info.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String talkInfo = null;
            while ((talkInfo = br.readLine()) != null && !"".equals(talkInfo.trim())) {
                Talk talk = new Talk(talkInfo);
                initTalkList.add(talk);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (Talk talk : initTalkList) {
            // System.out.println(talk.timer);
        }
    }

    public static void main(String[] args) {

    }

    public void scheduleTrack() {
        Session morningSession = scheduleMorningSession();
        scheduleAfternoonSession();

        // if there any talk isn't schedule, run this method again, new another
        // Track;
        if (initTalkList.size() > 0) {
            scheduleTrack();
        }
    }

    public Session scheduleMorningSession() {

        Session session = new MorningSession();

        return session;

    }

    public void scheduleAfternoonSession() {

    }

    public Session getBestPlan(Session session, int limitTime) {

        for (int bestTime = limitTime; bestTime < 0; bestTime--) {
            arrangeTime(session, bestTime);
        }
        return session;
    }

    public void arrangeTime(Session session, int bestTime) {

    }

}
