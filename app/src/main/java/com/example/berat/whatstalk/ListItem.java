package com.example.berat.whatstalk;

public class ListItem {
    private String name;
    private String number;
    private String duration;
    private String startTime;
    private String endTime;

    public ListItem(String name, String number, String duration, String startTime, String endTime) {
        this.name = name;
        this.number = number;
        this.duration = duration;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String getDuration() {
        return duration;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
