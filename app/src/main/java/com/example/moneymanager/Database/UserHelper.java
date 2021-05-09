package com.example.moneymanager.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import com.example.moneymanager.Model.User;


public class UserHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME ="money_manager";
    private static final String TABLE_NAME ="user";
    private static final String COLUMN_ID ="id";
    private static final String COLUMN_NAME ="name";
    private static final String COLUMN_EMAIL ="email";
    private static final String COLUMN_PASSWORD ="password";
    private Context context;

    public UserHelper(Context context){
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlQuery = "CREATE TABLE " + TABLE_NAME + "(" +
                COLUMN_ID + " INTERGER primary key,"+
                COLUMN_NAME + " TEXT, "+
                COLUMN_EMAIL + " TEXT, "+
                COLUMN_PASSWORD + " TEXT"+ ")";
        db.execSQL(sqlQuery);
//        Toast.makeText(context, "Create Database successfully", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
        Toast.makeText(context, "Drop successfully", Toast.LENGTH_SHORT).show();
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
        String selections = COLUMN_EMAIL + "=?";
        String[] values = {email};
        //select id from user where email = "adsadsad"
        Cursor cursor = db.query(TABLE_NAME, columns, selections, values, null, null, null);
        int count = cursor.getCount();
        cursor.close();
        db.close();
        if(count>0){
            return true;
        }else {
            return false;
        }
    }

    public boolean checkLogin(String email, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        String[] columns = {COLUMN_ID};
        String selections = COLUMN_EMAIL + "=?" + "AND" + COLUMN_PASSWORD + "=?";
        String[] values = {email, password};
        //select id from user where email = "asdas" and password = "dsdas"
        Cursor cursor = db.query(TABLE_NAME, columns,selections,values, null, null, null);
        int count = cursor.getCount();
        cursor.close();
        db.close();
        if(count>0){
            return true;
        }else {
            return false;
        }
    }

    public void delete(User user){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, COLUMN_ID + "=?" ,new String[]{String.valueOf(user.getId())} );
        db.close();
    }
}
