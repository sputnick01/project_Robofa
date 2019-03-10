package com.example.farshid.myproject_robofa.MainPage.Channel.MYChildren;

/**
 * Created by farshid on 11/15/2018.
 */

public class Modle {

    private String Note;
    private String Date;
    private String Time;

    public Modle(String note,String date,String time) {
        Note = note;
        Date=date;
        Time=time;
    }

    public void setNote(String note) {
        Note = note;
    }

    public String getNote() {
        return Note;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getDate() {
        return Date;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getTime() {
        return Time;
    }
}
