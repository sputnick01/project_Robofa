package com.example.farshid.myproject_robofa.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.farshid.myproject_robofa.DataBase.Child.ChildModle;
import com.example.farshid.myproject_robofa.DataBase.Noti.NotificationModle;
import com.example.farshid.myproject_robofa.Teacher.ShowAllForTeacher.Modle_ShowAllForTeacher;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by farshid on 9/8/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME23 = "Student23";
    public static final String TABLE_NAME = "note";

    public static final String COL_ID = "ID1";
    public static final String COL_Note = "Note1";
    public static final String COL_TypeNote = "TypeNote";
    public static final String COL_DateAd = "Date1";
    public static final String COL_TimeAd = "Time1";
    public static final String COL_SeenAd = "Seen1";


    public static final String TABLE_NAMEChild = "child";
    public static final String COL_IDChild = "ID2";
    public static final String COL_NoteChild = "Note2";
    public static final String COL_Date = "Date";
    public static final String COL_Time = "Time";
    public static final String COL_Seen = "Seen";



    public static final String TABLE_NAMEShowAll = "showall";
    public static final String COL_IDShowAll = "ID4";
    public static final String COL_NoteShowAll = "Note4";
    public static final String COL_DateShowAll = "Date4";
    public static final String COL_TimeShowAll = "Time4";
    public static final String COL_SeenShowAll = "Seen4";


    public static final String COL_TypeNoteChild = "TypeNote2";


    public static final String TABLE_NAMENoti = "noti";
    public static final String COL_IDNoti = "ID";
    public static final String COL_NoteNoti = "Note";
    public static final String COL_TypeNoteNoti = "TypeNote3";
    public static final String COL_DateNoti = "Date2";
    public static final String COL_TimeNoti = "Time2";
    public static final String COL_SeenNoti = "Seen2";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME23, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (ID1  INTEGER PRIMARY KEY AUTOINCREMENT, Note1 TEXT, Date1 TEXT , Time1 TEXT , Seen1 TEXT)");
        db.execSQL("create table " + TABLE_NAMEChild + " (ID2  INTEGER PRIMARY KEY AUTOINCREMENT, Note2 TEXT , Date TEXT , Time TEXT , Seen TEXT)");
        db.execSQL("create table " + TABLE_NAMENoti + " (ID  INTEGER PRIMARY KEY AUTOINCREMENT, Note TEXT , Date2 TEXT , Time2 TEXT , Seen2 TEXT)");
        db.execSQL("create table " + TABLE_NAMEShowAll + " (ID4  INTEGER PRIMARY KEY AUTOINCREMENT, Note4 TEXT, Date4 TEXT , Time4 TEXT , Seen4 TEXT)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAMEChild);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAMENoti);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAMEShowAll);
        onCreate(db);
    }

    public boolean insertData(String Note,String Date,String Time,String Seen) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_Note, Note);
        contentValues.put(COL_DateAd, Date);
        contentValues.put(COL_TimeAd, Time);
        contentValues.put(COL_SeenAd, Seen);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }
    public boolean insertDataShowAll(String Note,String Date,String Time,String Seen) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_NoteShowAll, Note);
        contentValues.put(COL_DateShowAll, Date);
        contentValues.put(COL_TimeShowAll, Time);
        contentValues.put(COL_SeenShowAll, Seen);
        long result = db.insert(TABLE_NAMEShowAll, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public boolean insertDataChild(String Note ,String Date ,String Time,String Seen) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_NoteChild, Note);
        contentValues.put(COL_Date,Date);
        contentValues.put(COL_Time,Time);
        contentValues.put(COL_Seen,Seen);
        long result = db.insert(TABLE_NAMEChild, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public boolean insertDataNoti(String Note ,String Date ,String Time ,String Seen) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_NoteNoti, Note);
        contentValues.put(COL_DateNoti, Date);
        contentValues.put(COL_TimeNoti, Time);
        contentValues.put(COL_SeenNoti, Seen);
        long result = db.insert(TABLE_NAMENoti, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }


    public ArrayList<String> getAllData() {
        ArrayList<String> myList = new ArrayList<String>(10);
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cr = db.rawQuery("select * from " + TABLE_NAME, null);
        cr.moveToFirst();
        String s = "";
        while (cr.moveToNext()) {
            int id = cr.getInt(cr.getColumnIndex("ID"));
            String image = cr.getString(cr.getColumnIndex("Note"));
//            String image = cr.getString(cr.getColumnIndex("Note"));
//            String image = cr.getString(cr.getColumnIndex("Note"));
//            s = s + image + id;
            myList.add(image);
        }
        return myList;
    }

    public List<DataBaseModle> getDataFromDB() {
        List<DataBaseModle> modelList = new ArrayList<DataBaseModle>();
        String query = "select * from " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                DataBaseModle model = new DataBaseModle();
                model.setNote(cursor.getString(1));
                model.setDate(cursor.getString(2));
                model.setTime(cursor.getString(3));
                model.setCountSeen(cursor.getString(4));
                modelList.add(model);
            } while (cursor.moveToNext());
        }

        return modelList;
    }
//    public List<Modle_ShowAllForTeacher> getDataFromShowAll() {
//        List<Modle_ShowAllForTeacher> modelList = new ArrayList<Modle_ShowAllForTeacher>();
//        String query = "select * from " + TABLE_NAMEShowAll;
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cursor = db.rawQuery(query, null);
//        if (cursor.moveToFirst()) {
//            do {
//                Modle_ShowAllForTeacher model = new Modle_ShowAllForTeacher();
//                model.setNote(cursor.getString(1));
//                model.setDate(cursor.getString(2));
//                model.setTime(cursor.getString(3));
//                model.setCountSeen(cursor.getString(4));
//                modelList.add(model);
//            } while (cursor.moveToNext());
//        }
//
//        return modelList;
//    }

    public List<ChildModle> getDataFromDBChild() {
        List<ChildModle> modelList = new ArrayList<ChildModle>();
        String query = "select * from " + TABLE_NAMEChild;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                ChildModle model = new ChildModle();
                model.setNote(cursor.getString(1));
                model.setDate(cursor.getString(2));
                model.setTime(cursor.getString(3));
                model.setCountSeen(cursor.getString(4));
                modelList.add(model);
            } while (cursor.moveToNext());
        }

        return modelList;
    }

    //تابع حذف کردن
    public boolean deleteDataNoti() {
//اتصال به دیتابیس قابل نوشتن
        SQLiteDatabase db = this.getWritableDatabase();

//حذف اطلاعات از دیتابیس
        long result = db.delete(TABLE_NAMENoti, "", new String[]{});

//بررسی حذف اطلاعات
        if (result == 0)
            return false;
        else
            return true;
    }

    //تابع حذف کردن
    public boolean deleteDataChild() {
//اتصال به دیتابیس قابل نوشتن
        SQLiteDatabase db = this.getWritableDatabase();

//حذف اطلاعات از دیتابیس
        long result = db.delete(TABLE_NAMEChild, "", new String[]{});

//بررسی حذف اطلاعات
        if (result == 0)
            return false;
        else
            return true;
    }

    //تابع حذف کردن
    public boolean deleteDataAdult() {
//اتصال به دیتابیس قابل نوشتن
        SQLiteDatabase db = this.getWritableDatabase();

//حذف اطلاعات از دیتابیس
        long result = db.delete(TABLE_NAME, "", new String[]{});

//بررسی حذف اطلاعات
        if (result == 0)
            return false;
        else
            return true;
    }
    public List<NotificationModle> getDataFromDBNoti() {
        List<NotificationModle> modelList = new ArrayList<NotificationModle>();
        String query = "select * from " + TABLE_NAMENoti;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                NotificationModle model = new NotificationModle();
                model.setNote(cursor.getString(1));
                model.setDate(cursor.getString(2));
                model.setTime(cursor.getString(3));
                model.setCountSeen(cursor.getString(4));
                modelList.add(model);
            } while (cursor.moveToNext());
        }

        return modelList;
    }


    public String getName(String Phone) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cr = db.rawQuery("select * from " + TABLE_NAME, null);
        cr.moveToFirst();
        String s = "";
        while (cr.moveToNext()) {

            String q = cr.getString(cr.getColumnIndex("PHONE")).toString();
            if (q.equals(Phone)) {
//            int id = cr.getInt(cr.getColumnIndex("ID"));
                String name = cr.getString(cr.getColumnIndex("NAME"));
//            String phone = cr.getString(cr.getColumnIndex("PHONE"));
//            String image = cr.getString(cr.getColumnIndex("IMAGE"));
                s = s + name;
                break;
            }

        }
        return s;
    }

    public String getPhone() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cr = db.rawQuery("select * from " + TABLE_NAME, null);
        cr.moveToFirst();
        String phone = cr.getString(cr.getColumnIndex("PHONE"));
        String s = phone;
        return s;
    }

    public String getImage(String Phone) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cr = db.rawQuery("select * from " + TABLE_NAME, null);
        String s = "";
        while (cr.moveToNext()) {

            String q = cr.getString(cr.getColumnIndex("PHONE")).toString();
            if (q.equals(Phone)) {
//            int id = cr.getInt(cr.getColumnIndex("ID"));
                String name = cr.getString(cr.getColumnIndex("IMAGE"));
//            String phone = cr.getString(cr.getColumnIndex("PHONE"));
//            String image = cr.getString(cr.getColumnIndex("IMAGE"));
                s = s + name;
                break;
            }

        }
        return s;
    }
//
//    public boolean updateData(String name,String phone,String image) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(COL_NAME,name);
////        contentValues.put(COL_PHONE,phone);
//        contentValues.put(COL_IMAGE,image);
//        db.update(TABLE_NAME23, contentValues,COL_PHONE+"="+phone,null);
//        return true;
//    }

//    public boolean updateIMAGE(String image ,String Phone) {
//        SQLiteDatabase mDb= this.getWritableDatabase();
//        ContentValues args = new ContentValues();
//        args.put(COL_IMAGE,image);
//        mDb.update(TABLE_NAME23,args, " PHONE = ?",new String[] { Phone });
//        return true;
//
//    }


//    public boolean updateNAME_PHONENUMBER(String name,String phone) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(COL_NAME,name);
//        contentValues.put(COL_PHONE,phone);
//        db.update(TABLE_NAME23, contentValues," ID = "+1,null);
//        return true;
//    }
//
//    public Integer deleteData (String id) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        return db.delete(TABLE_NAME23, "ID = ?",new String[] {id});
//    }
}
