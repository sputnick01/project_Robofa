package com.example.farshid.myproject_robofa.Rigster;

/**
 * Created by farshid on 12/13/2018.
 */

public class ModleShowAllImage {
    private String Topic;
    private String Image;
    private String Image2;
    private String Id;
    private String Seen;
    private String Date;
    private String Time;
    private String SendBy;

    public ModleShowAllImage(String topic, String image, String id, String seen, String date, String time,String image2,String SendBy) {
        Topic = topic;
        Image = image;
        Id = id;
        Seen = seen;
        Date = date;
        Time = time;
        Image2 = image2;
        this.SendBy=SendBy;

    }

    public void setTopic(String topic) {
        Topic = topic;
    }

    public String getTopic() {
        return Topic;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getImage() {
        return Image;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getId() {
        return Id;
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

    public void setImage2(String image2) {
        Image2 = image2;
    }

    public String getImage2() {
        return Image2;
    }

    public void setSendBy(String sendBy) {
        SendBy = sendBy;
    }

    public String getSendBy() {
        return SendBy;
    }
}
