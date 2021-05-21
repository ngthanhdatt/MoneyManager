package com.example.moneymanager.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.moneymanager.Model.User;
import com.example.moneymanager.Model.ViTien;

public class ViTienHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME ="hello";
    private static final String TABLE_NAME ="vitien";
    private static final String COLUMN_ID ="id";
    private static final String COLUMN_NAME ="name";
    private static final String COLUMN_COST ="cost";
    private static final String ID_USER ="userID";

    public ViTienHelper(Context context){
        super(context, DATABASE_NAME, null, 1 );
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlQuery = "CREATE TABLE " + TABLE_NAME + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                COLUMN_NAME + " TEXT, "+
                COLUMN_COST + " FLOAT, "+
                ID_USER + " INTEGER " + ")";
        db.execSQL(sqlQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void addViTien(ViTien viTien, String idUser){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NAME, viTien.getName());
        contentValues.put(COLUMN_COST, viTien.getCost());
        contentValues.put(ID_USER, idUser);
        db.insert(TABLE_NAME, null, contentValues);
        db.close();
    }

    public void delete(ViTien viTien){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, COLUMN_ID + "=?" ,new String[]{String.valueOf(viTien.getId())} );
        db.close();
    }

//    public int getIdVi(int id){
//        SQLiteDatabase db = this.getReadableDatabase();
//        // select * from vitien where id = ?
//        Cursor cursor = db.query(TABLE_NAME,
//                new String[] { COLUMN_ID, COLUMN_NAME, COLUMN_COST },
//                COLUMN_ID + "=?",
//                new String[] { String.valueOf(id) },
//                null,
//                null,
//                null,
//                null);
//
//    }
}
