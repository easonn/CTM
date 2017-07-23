package com.eason.ctm.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MorningSession extends Session {

	boolean flag = true;

	public MorningSession() {
		Date date = new Date();
		date.setHours(9);
		date.setMinutes(0);
		date.setSeconds(0);
		startTime = date;
	}

}
