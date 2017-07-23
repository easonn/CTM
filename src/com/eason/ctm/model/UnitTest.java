package com.eason.ctm.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

import org.junit.Test;

public class UnitTest {

    @Test
    public void uTest1() {
        String str = "Writing Fast Tests Against Enterprise Rails 60min";
        String[] tmp = str.replaceAll("[^\\d]+", ",").split(",");
        for (String string : tmp) {
            if (string.length() > 0) {
                System.out.println(string);
            }
        }
    }

    @Test
    public void uTest2() {
        File file = new File("C:/Users/yinsh/Desktop/conference_info.txt");
        StringBuilder result = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String s = null;
            while ((s = br.readLine()) != null) {
                result.append(System.lineSeparator() + s);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(result);

    }

    @Test
    public void getNextScheduledTime() {
        Date date = new Date();
        long timeInLong = date.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mma ");

        long timeDurationInLong = 30 * 60 * 1000;
        long newTimeInLong = timeInLong + timeDurationInLong;

        date.setTime(newTimeInLong);
        String str = dateFormat.format(date);
        System.err.println(str);
    }
    
}
