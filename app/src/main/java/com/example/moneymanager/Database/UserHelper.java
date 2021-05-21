package com.example.moneymanager.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import com.example.moneymanager.Model.User;

import java.util.ArrayList;
import java.util.List;


public class UserHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME ="money_manager";
    private static final String TABLE_NAME ="user";
    private static final String COLUMN_ID ="id";
    private static final String COLUMN_NAME ="name";
    private static final String COLUMN_EMAIL ="email";
    private static final String COLUMN_PASSWORD ="password";
    private static final String TAG = "UserHelper";


    public UserHelper(Context context){
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlQuery = "CREATE TABLE " + TABLE_NAME + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                COLUMN_NAME + " TEXT, "+
                COLUMN_EMAIL + " TEXT, "+
                COLUMN_PASSWORD + " TEXT"+ ")";
        db.execSQL(sqlQuery);
//        Toast.makeText(context, "Create Database successfully", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
//        Toast.makeText(context, "Drop successfully", Toast.LENGTH_SHORT).show();
    }

    public void addUser(User user){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NAME, user.getName());
        contentValues.put(COLUMN_EMAIL, user.getEmail());
        contentValues.put(COLUMN_PASSWORD, user.getPassword());
        db.insert(TABLE_NAME, null, contentValues);
        db.close();
    }

    public boolean checkExist(String email){
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {COLUMN_ID};
        String selections = COLUMN_EMAIL + " =?";
        String[] values = {email};
        //select id from user where email = "adsadsad"
        Cursor cursor = db.query(TABLE_NAME,
                columns,
                selections,
                values,
                null,
                null,
                null);
        int count = cursor.getCount();
        cursor.close();
        db.close();
        if(count>0){
            return true;
        }
        return false;
    }

    public boolean checkLogin(String email, String password){
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {COLUMN_ID};
        String selections = COLUMN_EMAIL + " =?" + " AND " + COLUMN_PASSWORD + " =?";
        String[] values = {email, password};
        //select id from user where email = "asdas" and password = "dsdas"
        Cursor cursor = db.query(TABLE_NAME,
                columns,
                selections,
                values,
                null,
                null,
                null);
        int count = cursor.getCount();
        cursor.close();
        db.close();
        if(count>0) {
            return true;
        }
        return false;
    }

    public void delete(User user){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, COLUMN_ID + "=?" ,new String[]{String.valueOf(user.getId())} );
        db.close();
    }

    public int getIdVi(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        // select * from vitien where id = ?
        String[] columns = {COLUMN_ID, COLUMN_NAME};
        String selections = COLUMN_ID + " =?" ;
        String[] values = {String.valueOf(id)};
        //select id from user where email = "asdas" and password = "dsdas"
        Cursor cursor = db.query(TABLE_NAME,
                columns,
                selections,
                values,
                null,
                null,
                null);
        if(cursor.moveToNext()){
            Log.d(TAG, "getIdVi: COLUMN_NAME" + cursor.getString(1));
            return cursor.getInt(0);
        }else
            return -1;
    }

    public List<User> getAllUser() {

        List<User> userList = new ArrayList<User>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                User user = new User();
                user.setId(Integer.parseInt(cursor.getString(0)));
                user.setName(cursor.getString(1));
                user.setEmail(cursor.getString(2));
                user.setPassword(cursor.getString(3));
                userList.add(user);
            } while (cursor.moveToNext());
        }

        return userList;
    }
}
