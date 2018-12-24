package com.example.lenovo.testdatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import com.example.lenovo.testdatabase.Friend;

public class DBHelper extends SQLiteOpenHelper {



    private final String TAG = getClass().getSimpleName();

    private SQLiteDatabase sqLiteDatabase;

    public DBHelper(Context context) {
        super(context, Friend.DATABASE_NAME, null, Friend.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_FRIEND_TABLE = String.format("CREATE TABLE %s " +
                        "(%s INTEGER PRIMARY KEY  AUTOINCREMENT, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT)",
                Friend.TABLE,
                Friend.Column.ID,
                Friend.Column.FIRST_NAME,
                Friend.Column.LAST_NAME,
                Friend.Column.TEL,
                Friend.Column.EMAIL,
                Friend.Column.DESCRIPTION);

        Log.i(TAG, CREATE_FRIEND_TABLE);

        // create friend table
        db.execSQL(CREATE_FRIEND_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


        String DROP_FRIEND_TABLE = "DROP TABLE IF EXISTS " + Friend.TABLE;

        db.execSQL(DROP_FRIEND_TABLE);

        Log.i(TAG, "Upgrade Database from " + oldVersion + " to " + newVersion);

        onCreate(db);

    }

    String CREATE_FRIEND_TABLE = String.format("CREATE TABLE %s " +
                    "(%s INTEGER PRIMARY KEY  AUTOINCREMENT, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT)",
            Friend.TABLE,
            Friend.Column.ID,
            Friend.Column.FIRST_NAME,
            Friend.Column.LAST_NAME,
            Friend.Column.TEL,
            Friend.Column.EMAIL,
            Friend.Column.DESCRIPTION);

    public List<String> getFriendList() {
        List<String> friends = new ArrayList<String>();

        sqLiteDatabase = this.getWritableDatabase();

        Cursor cursor = sqLiteDatabase.query
                (Friend.TABLE, null, null, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        while(!cursor.isAfterLast()) {

            friends.add(cursor.getLong(0) + " " +
                    cursor.getString(1) + " " +
                    cursor.getString(2));

            cursor.moveToNext();
        }

        sqLiteDatabase.close();

        return friends;
    }
    public void addFriend(Friend friend) {
        sqLiteDatabase = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        //values.put(Friend.Column.ID, friend.getId());
        values.put(Friend.Column.FIRST_NAME, "FirstName");
        values.put(Friend.Column.LAST_NAME, "LastName");
        values.put(Friend.Column.TEL, "Tel");
        values.put(Friend.Column.EMAIL, "Email");
        values.put(Friend.Column.DESCRIPTION, "Descriptio");

        sqLiteDatabase.insert(Friend.TABLE, null, values);

        sqLiteDatabase.close();
    }


}
