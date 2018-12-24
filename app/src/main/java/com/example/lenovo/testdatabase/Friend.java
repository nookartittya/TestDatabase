package com.example.lenovo.testdatabase;

import android.provider.BaseColumns;

public class Friend {

    private int id;
    private String firstName;
    private String lastName;
    private String tel;
    private String email;
    private String description;

    //Database
    public static final String DATABASE_NAME = "devahoy_friends.db";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE = "friend";

    public void setFirstName(String s) {
    }

    public void setLastName(String s) {
    }

    public void setTel(String s) {
    }

    public void setEmail(String s) {
    }

    public void setDescription(String s) {
    }

    public void setId(int id) {
    }


    public static class Column {
        public static final String ID = BaseColumns._ID;
        public static final String FIRST_NAME = "first_name";
        public static final String LAST_NAME = "last_name";
        public static final String TEL = "tel";
        public static final String EMAIL = "email";
        public static final String DESCRIPTION = "description";
    }

    //Default Constructor
    public Friend() {

    }
    //Constructor
    public Friend(int id, String firstName, String lastName, String tel,
                  String email, String description) {

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.tel = tel;
        this.email = email;
        this.description = description;

    }

    //Getter, Setter
}
