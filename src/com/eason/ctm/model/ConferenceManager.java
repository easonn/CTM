package com.eason.ctm.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

/*
 * yinsheng92@hotmail.com
 * 
 * 2017-07-23
 * 
 * 
 * */
public class ConferenceManager {

	public static final int MORNING_LIMIT = 180;

	public static final int AFTERNOON_LIMIT = 240;

	public static List<Talk> initTalkList = new ArrayList<Talk>();

	public List<Talk> talkResult = new ArrayList<Talk>();

	public static LinkedList<Talk> tmpResult = new LinkedList<Talk>();

	public static List<Track> trackList = new ArrayList<Track>();

	static {
		// File file = new File("F:/Java/workspace/CTM/conference_info.txt");
		File file = new File("/Users/eason/git/CTM/conference_info.txt");
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String talkInfo = null;
			System.out.println("Test input:");
			while ((talkInfo = br.readLine()) != null && !"".equals(talkInfo.trim())) {
				Talk talk = new Talk(talkInfo);
				initTalkList.add(talk);
				System.out.println(talk);
			}
			System.out.println();
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ConferenceManager cm = new ConferenceManager();
		cm.scheduleTrack();
		cm.printResult();
		
	}

	// Core code
	public void arrangeTime(List<Talk> talkResult, int bestTime, int index) {
		if (bestTime <= 0 || index >= initTalkList.size() || talkResult.size() > 0) {
			return;
		}
		int tmpTime = initTalkList.get(index).getTimer();
		if (bestTime == tmpTime) {
			tmpResult.push(initTalkList.get(index));
			for (Talk talk : tmpResult) {
				talkResult.add(talk);
				initTalkList.remove(talk);
			}
			return;
		}
		tmpResult.push(initTalkList.get(index));
		arrangeTime(talkResult, bestTime - tmpTime, ++index);

		tmpResult.pop();

		arrangeTime(talkResult, bestTime, ++index);
	}

	public Session getBestPlan(Session session, int limitTime) {
		for (int bestTime = limitTime; bestTime > 0; bestTime--) {
			talkResult = new ArrayList<Talk>();
			tmpResult = new LinkedList<Talk>();
			arrangeTime(talkResult, bestTime, 0);
			if (talkResult.size() > 0) {
				for (int i = talkResult.size() - 1; i >= 0; i--) {
					session.addTalk(talkResult.get(i));
				}
				break;
			}
		}
		return session;
	}

	public void scheduleTrack() {

		Session morningSession = scheduleMorningSession();
		Session afternoonSession = scheduleAfternoonSession();
		Track track = new Track(morningSession, afternoonSession);
		trackList.add(track);
		// If there any talk isn't schedule, run this method again, new another
		// Track;
		if (initTalkList.size() > 0) {
			scheduleTrack();
		}
	}

	public Session scheduleMorningSession() {

		Session session = new MorningSession();
		getBestPlan(session, MORNING_LIMIT);

		return session;

	}

	public Session scheduleAfternoonSession() {
		Session session = new AfternoonSession();
		getBestPlan(session, AFTERNOON_LIMIT);
		return session;
	}

	public void printResult() {
		for (int i = 1; i < trackList.size() + 1; i++) {
			System.out.println("Track " + i + ":");
			System.out.println();
			for (Talk talk : trackList.get(i - 1).getMorningSession().getTalkList()) {
				System.out.println(talk);
			}
			System.out.println("12:00PM Lunch ");
			System.out.println();
			AfternoonSession afternoonSession = (AfternoonSession) trackList.get(i - 1).getAfternoonSession();
			if (null != afternoonSession) {
				for (Talk talk : afternoonSession.getTalkList()) {
					System.out.println(talk);
				}
				SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mma ", Locale.ENGLISH);
				Date networkEventTime = (Date) afternoonSession.startTime;
				if (networkEventTime.getHours() < 16) {
					networkEventTime.setHours(16);
					networkEventTime.setMinutes(0);
				}
				System.out.println(dateFormat.format(networkEventTime) + "Networking Event");
				System.out.println();
			}
			;

		}
	}

}
