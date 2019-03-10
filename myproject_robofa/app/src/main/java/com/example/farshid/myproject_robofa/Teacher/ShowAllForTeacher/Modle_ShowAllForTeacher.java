package com.example.farshid.myproject_robofa.Teacher.ShowAllForTeacher;

/**
 * Created by farshid on 11/23/2018.
 */

public class Modle_ShowAllForTeacher {
    private String Note;
    private String Date;
    private String Time;
    private String CountSeen;
    private String Id;

    public Modle_ShowAllForTeacher(String note, String date, String time, String countSeen, String id) {
        Note = note;
        Date = date;
        Time = time;
        CountSeen = countSeen;
        Id = id;
    }


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

    public void setId(String id) {
        Id = id;
    }

    public String getId() {
        return Id;
    }
}
