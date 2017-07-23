package com.eason.ctm.model;

public class Talk {

    private String title;

    // default 5mins
    private int timer = 5;

    // true means the talk was scheduled. default is false.
    boolean flag = false;

    private String startTime;

    public Talk(String info) {
        this.title = info;
        String[] tmp = info.replaceAll("[^\\d]+", ",").split(",");
        for (String str : tmp) {
            if (str.length() > 0) {
                this.timer = Integer.parseInt(str);
                return;
            }
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTimer() {
        return timer;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String toString() {
        return startTime + " " + title + " " + timer;
    }
}
