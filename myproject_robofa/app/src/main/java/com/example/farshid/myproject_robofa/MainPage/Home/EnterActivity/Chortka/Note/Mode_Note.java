package com.example.farshid.myproject_robofa.MainPage.Home.EnterActivity.Chortka.Note;

/**
 * Created by farshid on 10/30/2018.
 */

public class Mode_Note {

    private String Note;
    private String Seen;
    private String Date;
    private String Time;
    public Mode_Note(String note, String seen, String date, String time) {
        Note = note;
        Seen = seen;
        Date = date;
        Time = time;
    }


    public void setNote(String note) {
        Note = note;
    }

    public String getNote() {
        return Note;
    }

    public void setSeen(String seen) {
        Seen = seen;
    }

    public String getSeen() {
        return Seen;
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
