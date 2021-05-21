package com.example.moneymanager.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.moneymanager.Model.Chi;
import com.example.moneymanager.Model.LoaiChi;
import com.example.moneymanager.Model.LoaiThu;
import com.example.moneymanager.Model.Thu;
import com.example.moneymanager.Model.ViTien;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME ="Money Manager";

    //table_vitien
    private static final String TABLE_VI ="vi";
    private static final String COLUMN_VI_ID ="vi_id";
    private static final String COLUMN_VI_NAME ="vi_name";
    private static final String COLUMN_VI_MONEY ="vi_money";
    private String create_vi = "CREATE TABLE " + TABLE_VI + "(" +
            COLUMN_VI_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
            COLUMN_VI_NAME + " TEXT, "+
            COLUMN_VI_MONEY + " TEXT "+ ")";


    //table thu
    private static final String TABLE_THU ="thu";
    private static final String COLUMN_THU_ID ="thu_id";
    private static final String COLUMN_THU_SOTIEN ="thu_money";
    private static final String COLUMN_THU_LOAITHUID ="thu_loaithu";
    private static final String COLUMN_THU_VITIENID ="thu_vitienid";
    private static final String COLUMN_THU_GHICHU ="thu_ghichu";
    private String create_thu = "CREATE TABLE " + TABLE_THU + "(" +
            COLUMN_THU_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
            COLUMN_THU_SOTIEN + " INTEGER, "+
            COLUMN_THU_LOAITHUID + " INTEGER, "+
            COLUMN_THU_VITIENID + " INTEGER, "+
            COLUMN_THU_GHICHU + " TEXT "+")";


    //table chi
    private static final String TABLE_CHI ="chi";
    private static final String COLUMN_CHI_ID ="chi_id";
    private static final String COLUMN_CHI_SOTIEN ="chi_money";
    private static final String COLUMN_CHI_LOAICHIID ="chi_loaichi";
    private static final String COLUMN_CHI_VITIENID ="chi_vitienid";
    private static final String COLUMN_CHI_GHICHU ="chi_ghichu";
    private String create_chi = "CREATE TABLE " + TABLE_CHI + "(" +
            COLUMN_CHI_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
            COLUMN_CHI_SOTIEN + " INTEGER, "+
            COLUMN_CHI_LOAICHIID + " INTEGER, "+
            COLUMN_CHI_VITIENID + " INTEGER, "+
            COLUMN_CHI_GHICHU + " TEXT "+")";


    //table loai_thu
    private static final String TABLE_LOAITHU ="loaithu";
    private static final String COLUMN_LOAITHU_ID ="loaithu_id";
    private static final String COLUMN_LOAITHU_NAME ="loaithu_name";
    private String create_loaithu = "CREATE TABLE " + TABLE_LOAITHU + "(" +
            COLUMN_LOAITHU_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
            COLUMN_LOAITHU_NAME + " TEXT "+ ")";


    //table loai_chi
    private static final String TABLE_LOAICHI ="loaichi";
    private static final String COLUMN_LOAICHI_ID ="loaichi_id";
    private static final String COLUMN_LOAICHI_NAME ="loaichi_name";
    private String create_loaichi = "CREATE TABLE " + TABLE_LOAICHI + "(" +
            COLUMN_LOAICHI_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
            COLUMN_LOAICHI_NAME + " TEXT"+ ")";


    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(create_vi);
        db.execSQL(create_loaichi);
        db.execSQL(create_loaithu);
        db.execSQL(create_chi);
        db.execSQL(create_thu);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_VI);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LOAICHI);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LOAITHU);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CHI);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_THU);
        onCreate(db);
    }


    //===================vitien=============================//
    public void addViTien(ViTien viTien){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_VI_NAME, viTien.getName());
        contentValues.put(COLUMN_VI_MONEY, viTien.getMoney());
        db.insert(TABLE_VI, null, contentValues);
        db.close();
    }

    public void deleteViTien(ViTien viTien){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_VI, COLUMN_VI_ID + "=?" ,new String[]{String.valueOf(viTien.getId())} );
        db.close();
    }

    public int updateViTien(ViTien viTien) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_VI_NAME, viTien.getName());
        values.put(COLUMN_VI_MONEY, viTien.getMoney());

        // updating row
        return db.update(TABLE_VI, values, COLUMN_VI_ID + " = ?",
                new String[]{String.valueOf(viTien.getId())});
    }

    public int getViCount() {
        String countQuery = "SELECT  * FROM " + TABLE_VI;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }

    public void addVi_Default()  {
        int count = this.getViCount();
        if(count ==0 ) {
            ViTien tienmat = new ViTien("Tiền mặt",0);
            ViTien taikhoan = new ViTien("Tài khoản ngân hàng",0);
            ViTien tindung = new ViTien("Thẻ tín dụng",0);
            this.addViTien(tienmat);
            this.addViTien(taikhoan);
            this.addViTien(tindung);
        }
    }


    //=============================loai thu===========================//
    public void addLoaiThu(LoaiThu loaiThu){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_LOAITHU_NAME, loaiThu.getName());
        db.insert(TABLE_LOAITHU, null, contentValues);
        db.close();
    }

    public int getLoaiThuCount() {
        String countQuery = "SELECT  * FROM " + TABLE_LOAITHU;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }

    public void addLoaiThu_Default()  {
        int count = this.getLoaiThuCount();
        if(count ==0 ) {
            LoaiThu luong = new LoaiThu("Tiền lương");
            LoaiThu thuong = new LoaiThu("Tiền thưởng");
            LoaiThu themgio = new LoaiThu("Trả thêm giờ");
            LoaiThu khac = new LoaiThu("Khác");
            this.addLoaiThu(luong);
            this.addLoaiThu(thuong);
            this.addLoaiThu(themgio);
            this.addLoaiThu(khac);
        }
    }


    //===============================loai chi==========================//
    public void addLoaiChi(LoaiChi loaiChi){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_LOAICHI_NAME, loaiChi.getName());
        db.insert(TABLE_LOAICHI, null, contentValues);
        db.close();
    }

    public int getLoaiChiCount() {
        String countQuery = "SELECT  * FROM " + TABLE_LOAICHI;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }

    public void addLoaiChi_Default()  {
        int count = this.getLoaiChiCount();
        if(count ==0 ) {
            LoaiChi anuong = new LoaiChi("Ăn uống");
            LoaiChi giaitri = new LoaiChi("Giải trí");
            LoaiChi giaothong = new LoaiChi("Giao thông");
            LoaiChi sothich = new LoaiChi("Sở thích");
            LoaiChi sinhhoat = new LoaiChi("Sinh hoạt");
            LoaiChi aoquan = new LoaiChi("Áo quần");
            LoaiChi lamdep = new LoaiChi(" Làm đẹp");
            LoaiChi suckhoe = new LoaiChi("Sức khỏe");
            LoaiChi giaoduc = new LoaiChi("Giáo dục");
            LoaiChi sukien = new LoaiChi("Sự kiện");
            LoaiChi khac = new LoaiChi("Khác");
            this.addLoaiChi(anuong);
            this.addLoaiChi(giaitri);
            this.addLoaiChi(giaothong);
            this.addLoaiChi(sothich);
            this.addLoaiChi(sinhhoat);
            this.addLoaiChi(aoquan);
            this.addLoaiChi(lamdep);
            this.addLoaiChi(suckhoe);
            this.addLoaiChi(giaoduc);
            this.addLoaiChi(sukien);
            this.addLoaiChi(khac);
        }
    }


    //====================================thu==============================//
    public void addThu(Thu thu){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_THU_SOTIEN, thu.getSotien());
        contentValues.put(COLUMN_THU_LOAITHUID, thu.getIDLoaiThu());
        contentValues.put(COLUMN_THU_VITIENID, thu.getIDViTien());
        contentValues.put(COLUMN_THU_GHICHU, thu.getGhichu());
        db.insert(TABLE_THU, null, contentValues);
        db.close();
    }

    public void deleteThu(Thu thu){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_THU, COLUMN_THU_ID + "=?" ,new String[]{String.valueOf(thu.getId())} );
        db.close();
    }

    public int updateThu(Thu thu) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_THU_SOTIEN, thu.getSotien());
        values.put(COLUMN_THU_LOAITHUID, thu.getIDLoaiThu());
        values.put(COLUMN_THU_VITIENID, thu.getIDViTien());
        values.put(COLUMN_THU_GHICHU, thu.getGhichu());

        // updating row
        return db.update(TABLE_THU, values, COLUMN_THU_ID + " = ?",
                new String[]{String.valueOf(thu.getId())});
    }



    //====================================chi==============================//
    public void addChi(Chi chi){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_CHI_SOTIEN, chi.getSotien());
        contentValues.put(COLUMN_CHI_LOAICHIID, chi.getIDLoaiChi());
        contentValues.put(COLUMN_CHI_VITIENID, chi.getIDViTien());
        contentValues.put(COLUMN_CHI_GHICHU, chi.getGhichu());
        db.insert(TABLE_CHI, null, contentValues);
        db.close();
    }

    public void deleteChi(Chi chi){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CHI, COLUMN_CHI_ID + "=?" ,new String[]{String.valueOf(chi.getId())} );
        db.close();
    }

    public int updateChi(Chi chi) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_CHI_SOTIEN, chi.getSotien());
        values.put(COLUMN_CHI_LOAICHIID, chi.getIDLoaiChi());
        values.put(COLUMN_CHI_VITIENID, chi.getIDViTien());
        values.put(COLUMN_CHI_GHICHU, chi.getGhichu());

        // updating row
        return db.update(TABLE_CHI, values, COLUMN_CHI_ID + " = ?",
                new String[]{String.valueOf(chi.getId())});
    }


}
