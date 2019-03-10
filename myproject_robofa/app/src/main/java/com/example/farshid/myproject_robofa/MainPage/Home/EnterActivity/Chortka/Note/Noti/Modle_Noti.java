package com.example.farshid.myproject_robofa.MainPage.Home.EnterActivity.Chortka.Note.Noti;

/**
 * Created by farshid on 11/23/2018.
 */

public class Modle_Noti {

    private String Note;
    private String Date;
    private String Time;
    private String Seen;
    public Modle_Noti(String note, String date, String time, String seen) {
        Note = note;
        Date = date;
        Time = time;
        Seen = seen;
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

    public void setSeen(String seen) {
        Seen = seen;
    }

    public String getSeen() {
        return Seen;
    }
}
