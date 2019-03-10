package com.example.farshid.myproject_robofa.Karshinas;

/**
 * Created by farshid on 11/15/2018.
 */

public class ModleKa {
    private String Note;
    private int Id;

    public ModleKa(int Id, String note) {
        Note = note;
        this.Id = Id;
    }

    public void setNote(String note) {
        Note = note;
    }

    public String getNote() {
        return Note;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getId() {
        return Id;
    }
}
