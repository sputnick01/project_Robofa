package com.example.farshid.myproject_robofa.DataBase.Child;

/**
 * Created by farshid on 11/16/2018.
 */

public class ChildModle {
    private String Note;
    private String Date;
    private String Time;
    private String CountSeen;
//
//    public DataBaseModle(String note) {
//        Note = note;
//    }

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

    public void setCountSeen(String countSeen) {
        CountSeen = countSeen;
    }

    public String getCountSeen() {
        return CountSeen;
    }
}
