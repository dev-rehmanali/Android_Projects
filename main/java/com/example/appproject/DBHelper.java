package com.example.appproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String dbName = "cemetery";
    public static int dbVersion = 1;

    public DBHelper(Context context) {
        super(context,"cemetery",null,dbVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        createUser(sqLiteDatabase);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void createUser(SQLiteDatabase sqLiteDatabase){

        String queryUser = "CREATE TABLE user (id	INTEGER PRIMARY KEY AUTOINCREMENT, username	TEXT, fullname TEXT, email TEXT, contactnum TEXT, address TEXT,password TEXT)";
//        String queryService = "CREATE TABLE service (id	INTEGER PRIMARY KEY AUTOINCREMENT, person TEXT, burrialdate TEXT, burrialtime TEXT, relation TEXT)";
        String queryOrders = "CREATE TABLE orders (id	INTEGER PRIMARY KEY AUTOINCREMENT, person TEXT, burrialdate TEXT, burrialtime TEXT, relation TEXT, cotton TEXT, shroud TEXT, religionist TEXT, flower TEXT, labour TEXT)";
        sqLiteDatabase.execSQL(queryUser);
//        sqLiteDatabase.execSQL(queryService);
        sqLiteDatabase.execSQL(queryOrders);
    }

    public void insertUser(User user){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username", user.getUserName());
        values.put("fullname", user.getFullName());
        values.put("email", user.getEmail());
        values.put("contactnum", user.getMobile());
        values.put("address", user.getAddress());
        values.put("password", user.getPassword());
        db.insert("user", null, values);
        db.close();

    }//insertUser

    public boolean authenticate(String email, String password) {
        // array of columns to fetch from the db
        String[] columns = {
                "username","fullname"
        };
        SQLiteDatabase db = this.getReadableDatabase();
        // selection criteria
        String selection = "email" + " = ?" + " AND " + "password" + " = ?";
        // selection arguments
        String[] selectionArgs = {email, password};
        // query user table with conditions
        Cursor cursor = db.query("user", //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                       //filter by row groups
                null);                      //The sort order
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();
        if (cursorCount > 0) {
            return true;
        }
        return false;
    }//authenticateUser

    public User getUser(String email) {
        // array of columns to fetch from the db
        User user = new User();
        String[] columns = {
                "username","fullname"
        };
        SQLiteDatabase db = this.getReadableDatabase();
        // selection criteria
        String selection = "email" + " = ?";
        // selection arguments
        String[] selectionArgs = {email};
        // query user table with conditions
        Cursor cursor = db.query("user", //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                       //filter by row groups
                null);                      //The sort order

        cursor.moveToFirst();
        user.setFullName(cursor.getString(1));

        return user;
    }//getUser

    public void insertOrder(Service service){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("person", service.getPerson());
        values.put("burrialdate", service.getBurrialDate());
        values.put("burrialtime", service.getBurrialTime());
        values.put("relation", service.getRelation());
        values.put("cotton", service.getCotton());
        values.put("shroud", service.getShroud());
        values.put("religionist", service.getReligionist());
        values.put("flower", service.getFlower());
        values.put("labour", service.getLabour());
        db.insert("service", null, values);
        db.close();

    }

}
