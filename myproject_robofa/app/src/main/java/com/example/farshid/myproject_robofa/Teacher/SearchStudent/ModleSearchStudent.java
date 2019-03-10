package com.example.farshid.myproject_robofa.Teacher.SearchStudent;

/**
 * Created by farshid on 11/21/2018.
 */

public class ModleSearchStudent {
    private String Name;
    private String PhoneNumber;
    private String NationalCode;
    private String Image;
    private String Id;

    public ModleSearchStudent(String Id, String name, String phoneNumber, String nationalCode, String image) {
        this.Id = Id;
        Name = name;
        PhoneNumber = phoneNumber;
        NationalCode = nationalCode;
        Image = image;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setNationalCode(String nationalCode) {
        NationalCode = nationalCode;
    }

    public String getNationalCode() {
        return NationalCode;
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
}
