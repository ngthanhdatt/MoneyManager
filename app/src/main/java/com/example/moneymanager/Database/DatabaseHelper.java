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
import com.example.moneymanager.Model.User;
import com.example.moneymanager.Model.ViTien;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Money Manager";

    //table user
    private static final String TABLE_USER = "user";
    private static final String COLUMN_USER_ID = "id";
    private static final String COLUMN_USER_NAME = "name";
    private static final String COLUMN_USER_PASSWORD = "password";

    //table_vitien
    private static final String TABLE_VI = "vi";
    private static final String COLUMN_VI_ID = "vi_id";
    private static final String COLUMN_VI_NAME = "vi_name";
    private static final String COLUMN_VI_MONEY = "vi_money";

    //table thu
    private static final String TABLE_THU = "thu";
    private static final String COLUMN_THU_ID = "thu_id";
    private static final String COLUMN_THU_SOTIEN = "thu_money";
    private static final String COLUMN_THU_THOIGIAN = "thu_thoigian";
    private static final String COLUMN_THU_LOAITHUID = "thu_loaithuid";
    private static final String COLUMN_THU_VITIENID = "thu_vitienid";
    private static final String COLUMN_THU_GHICHU = "thu_ghichu";

    //table chi
    private static final String TABLE_CHI = "chi";
    private static final String COLUMN_CHI_ID = "chi_id";
    private static final String COLUMN_CHI_SOTIEN = "chi_money";
    private static final String COLUMN_CHI_THOIGIAN = "chi_thoigian";
    private static final String COLUMN_CHI_LOAICHIID = "chi_loaichiid";
    private static final String COLUMN_CHI_VITIENID = "chi_vitienid";
    private static final String COLUMN_CHI_GHICHU = "chi_ghichu";

    //table loai_thu
    private static final String TABLE_LOAITHU = "loaithu";
    private static final String COLUMN_LOAITHU_ID = "loaithu_id";
    private static final String COLUMN_LOAITHU_NAME = "loaithu_name";

    //table loai_chi
    private static final String TABLE_LOAICHI = "loaichi";
    private static final String COLUMN_LOAICHI_ID = "loaichi_id";
    private static final String COLUMN_LOAICHI_NAME = "loaichi_name";

    //table thoi gian
    private static final String TABLE_THOIGIAN = "thoigian";
    private static final String COLUMN_THOIGIAN_ID = "thoigian_id";
    private static final String COLUMN_THOIGIAN_BATDAU = "thoigian_batdau";
    private static final String COLUMN_THOIGIAN_KETTHUC = "thoigian_kethuc";
    private static final String COLUMN_THOIGIAN_THANG="thoigian_thang";
    private static final String COLUMN_THOIGIAN_BD = "thoigian_batdau(khoi tao)";
    private static final String COLUMN_THOIGIAN_KT="thoigian_kethuc(khoi tao)";

    private String create_user = "CREATE TABLE " + TABLE_USER + "(" +
            COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            COLUMN_USER_NAME + " TEXT, " +
            COLUMN_USER_PASSWORD + " TEXT " + ")";

    private String create_vi = "CREATE TABLE " + TABLE_VI + "(" +
            COLUMN_VI_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            COLUMN_VI_NAME + " TEXT, " +
            COLUMN_VI_MONEY + " INTEGER " + ")";

    private String create_thu = "CREATE TABLE " + TABLE_THU + "(" +
            COLUMN_THU_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            COLUMN_THU_SOTIEN + " INTEGER, " +
            COLUMN_THU_THOIGIAN + " TEXT, " +
            COLUMN_THU_LOAITHUID + " INTEGER, " +
            COLUMN_THU_VITIENID + " INTEGER, " +
            COLUMN_THU_GHICHU + " TEXT " + ")";

    private String create_chi = "CREATE TABLE " + TABLE_CHI + "(" +
            COLUMN_CHI_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            COLUMN_CHI_SOTIEN + " INTEGER, " +
            COLUMN_CHI_THOIGIAN + " TEXT, " +
            COLUMN_CHI_LOAICHIID + " INTEGER, " +
            COLUMN_CHI_VITIENID + " INTEGER, " +
            COLUMN_CHI_GHICHU + " TEXT " + ")";

    private String create_loaithu = "CREATE TABLE " + TABLE_LOAITHU + "(" +
            COLUMN_LOAITHU_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            COLUMN_LOAITHU_NAME + " TEXT " + ")";

    private String create_loaichi = "CREATE TABLE " + TABLE_LOAICHI + "(" +
            COLUMN_LOAICHI_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            COLUMN_LOAICHI_NAME + " TEXT" + ")";

    private String create_thoigian = "CREATE TABLE " + TABLE_THOIGIAN + "(" +
            COLUMN_THOIGIAN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            COLUMN_THOIGIAN_BATDAU + " TEXT, " +
            COLUMN_THOIGIAN_KETTHUC + " TEXT " +")";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(create_user);
        db.execSQL(create_vi);
        db.execSQL(create_loaichi);
        db.execSQL(create_loaithu);
        db.execSQL(create_chi);
        db.execSQL(create_thu);
        db.execSQL(create_thoigian);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_VI);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LOAICHI);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LOAITHU);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CHI);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_THU);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_THOIGIAN);
        onCreate(db);
    }

    //===================user===============================//
    public void addUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_USER_NAME, user.getName());
        contentValues.put(COLUMN_USER_PASSWORD, user.getPassword());
        db.insert(TABLE_USER, null, contentValues);
        db.close();
    }

    public void deleteUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_USER, COLUMN_USER_ID + "=?", new String[]{String.valueOf(user.getId())});
        db.close();
    }

    public boolean checkLogin(String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {COLUMN_USER_ID};
        String selections = COLUMN_USER_PASSWORD + " =?";
        String[] values = {password};
        //select id from user where  password = "dsdas"
        Cursor cursor = db.query(TABLE_USER,
                columns,
                selections,
                values,
                null,
                null,
                null);
        int count = cursor.getCount();
        cursor.close();
        db.close();
        if (count > 0) {
            return true;
        }
        return false;
    }

    public List<User> getAllUser() {

        List<User> userList = new ArrayList<User>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_USER;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                User user = new User();
                user.setId(Integer.parseInt(cursor.getString(0)));
                user.setName(cursor.getString(1));
                user.setPassword(cursor.getString(2));
                userList.add(user);
            } while (cursor.moveToNext());
        }
        return userList;
    }

    //===================vitien=============================//
    public void addViTien(ViTien viTien) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_VI_NAME, viTien.getName());
        contentValues.put(COLUMN_VI_MONEY, viTien.getMoney());
        db.insert(TABLE_VI, null, contentValues);
        db.close();
    }

    public void deleteViTien(ViTien viTien) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_VI, COLUMN_VI_ID + "=?", new String[]{String.valueOf(viTien.getId())});
        db.close();
    }

    public int updateViTien(ViTien viTien) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_VI_NAME, viTien.getName());
        values.put(COLUMN_VI_MONEY, viTien.getMoney());

        // updating row
        return db.update(TABLE_VI, values, COLUMN_VI_NAME + " = ?",
                new String[]{viTien.getName()});
    }

    public int updateViTienByID(ViTien viTien,ViTien viTien2) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_VI_NAME, viTien.getName());
        values.put(COLUMN_VI_MONEY, viTien.getMoney());

        // updating row
        return db.update(TABLE_VI, values, COLUMN_VI_ID + " = ?",
                new String[]{String.valueOf(viTien2.getId())});
    }

    public List<ViTien> getAllViTien() {

        List<ViTien> viTienList = new ArrayList<ViTien>();
        String selectQuery = "SELECT  * FROM " + TABLE_VI;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                ViTien vi = new ViTien();
                vi.setId(Integer.parseInt(cursor.getString(0)));
                vi.setName(cursor.getString(1));
                vi.setMoney(Integer.parseInt(cursor.getString(2)));
                viTienList.add(vi);
            } while (cursor.moveToNext());
        }
        return viTienList;
    }

    public int getViCount() {
        String countQuery = "SELECT  * FROM " + TABLE_VI;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }

    public void addVi_Default() {
        int count = this.getViCount();
        if (count == 0) {
            ViTien tienmat = new ViTien("Tiền mặt", 0);
            ViTien taikhoan = new ViTien("Tài khoản ngân hàng", 0);
            ViTien tindung = new ViTien("Thẻ tín dụng", 0);
            this.addViTien(tienmat);
            this.addViTien(taikhoan);
            this.addViTien(tindung);
        }
    }

    public ViTien getViTienByName(String name) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_VI, new String[] { COLUMN_VI_ID,
                        COLUMN_VI_NAME, COLUMN_VI_MONEY }, COLUMN_VI_NAME + "=?",
                new String[] { name }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        ViTien viTien = new ViTien(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), Integer.parseInt(cursor.getString(2)));
        return viTien;
    }

    public ViTien getViTienById(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_VI, new String[] { COLUMN_VI_ID,
                        COLUMN_VI_NAME, COLUMN_VI_MONEY }, COLUMN_VI_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        ViTien viTien = new ViTien(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), Integer.parseInt(cursor.getString(2)));
        return viTien;
    }


    //=============================loai thu===========================//
    public void addLoaiThu(LoaiThu loaiThu) {
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

    public void addLoaiThu_Default() {
        int count = this.getLoaiThuCount();
        if (count == 0) {
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

    public List<LoaiThu> getAllLoaiThu() {

        List<LoaiThu> list = new ArrayList<LoaiThu>();
        String selectQuery = "SELECT  * FROM " + TABLE_LOAITHU;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                LoaiThu loaiThu = new LoaiThu();
                loaiThu.setId(Integer.parseInt(cursor.getString(0)));
                loaiThu.setName(cursor.getString(1));
                list.add(loaiThu);
            } while (cursor.moveToNext());
        }
        return list;
    }

    public LoaiThu getLoaiThuByName(String name) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_LOAITHU, new String[] { COLUMN_LOAITHU_ID,
                        COLUMN_LOAITHU_NAME}, COLUMN_LOAITHU_NAME + "=?",
                new String[] { name }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        LoaiThu loaiThu = new LoaiThu(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1));
        return loaiThu;
    }

    public LoaiThu getLoaiThuById(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_LOAITHU, new String[] { COLUMN_LOAITHU_ID,
                        COLUMN_LOAITHU_NAME}, COLUMN_LOAITHU_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        LoaiThu loaiThu = new LoaiThu(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1));
        return loaiThu;
    }




    //===============================loai chi==========================//
    public void addLoaiChi(LoaiChi loaiChi) {
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

    public void addLoaiChi_Default() {
        int count = this.getLoaiChiCount();
        if (count == 0) {
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

    public List<LoaiChi> getAllLoaiChi() {

        List<LoaiChi> list = new ArrayList<LoaiChi>();
        String selectQuery = "SELECT  * FROM " + TABLE_LOAICHI;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                LoaiChi loaiChi = new LoaiChi();
                loaiChi.setId(Integer.parseInt(cursor.getString(0)));
                loaiChi.setName(cursor.getString(1));
                list.add(loaiChi);
            } while (cursor.moveToNext());
        }
        return list;
    }

    public LoaiChi getLoaiChiByName(String name) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_LOAICHI, new String[] { COLUMN_LOAICHI_ID,
                        COLUMN_LOAICHI_NAME}, COLUMN_LOAICHI_NAME + "=?",
                new String[] { name }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        LoaiChi loaiChi = new LoaiChi(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1));
        return loaiChi;
    }

    public LoaiChi getLoaiChiById(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_LOAICHI, new String[] { COLUMN_LOAICHI_ID,
                        COLUMN_LOAICHI_NAME}, COLUMN_LOAICHI_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        LoaiChi loaiChi = new LoaiChi(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1));
        return loaiChi;
    }


    //====================================thu==============================//
    public void addThu(Thu thu,ViTien viTien) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_THU_SOTIEN, thu.getSotien());
        contentValues.put(COLUMN_THU_THOIGIAN, thu.getThoiGian());
        contentValues.put(COLUMN_THU_LOAITHUID, thu.getIDLoaiThu());
        contentValues.put(COLUMN_THU_VITIENID, thu.getViTien().getId());
        contentValues.put(COLUMN_THU_GHICHU, thu.getGhichu());
        db.insert(TABLE_THU, null, contentValues);
        viTien= new ViTien(viTien.getName(),viTien.getMoney()+thu.getSotien());
        updateViTien(viTien);
        db.close();
    }

    public void deleteThu(Thu thu,ViTien viTien) {
        SQLiteDatabase db = this.getWritableDatabase();
        ViTien viTien2= new ViTien(viTien.getName(),viTien.getMoney()-thu.getSotien());
        updateViTienByID(viTien2,viTien);
        db.delete(TABLE_THU, COLUMN_THU_ID + "=?", new String[]{String.valueOf(thu.getId())});
        db.close();
    }

    public int updateThu(Thu thu, Thu thu2, ViTien viTien) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_THU_SOTIEN, thu.getSotien());
        values.put(COLUMN_THU_THOIGIAN, thu.getThoiGian());
        values.put(COLUMN_THU_LOAITHUID, thu.getIDLoaiThu());
        values.put(COLUMN_THU_VITIENID, thu.getViTien().getId());
        values.put(COLUMN_THU_GHICHU, thu.getGhichu());
        viTien = new ViTien(viTien.getName(),viTien.getMoney()-thu2.getSotien()+thu.getSotien());
        updateViTien(viTien);
        // updating row
        return db.update(TABLE_THU, values, COLUMN_THU_ID + " = ?",
                new String[]{String.valueOf(thu2.getId())});
    }

    public List<Thu> getAllThu() {

        List<Thu> list = new ArrayList<Thu>();
        String selectQuery = "SELECT  * FROM " + TABLE_THU;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Thu thu = new Thu();
                thu.setId(Integer.parseInt(cursor.getString(0)));
                thu.setSotien(Integer.parseInt(cursor.getString(1)));
                thu.setThoiGian(cursor.getString(2));
                thu.setLoaiThu(getLoaiThuById(Integer.parseInt(cursor.getString(3))));
                thu.setViTien(getViTienById(Integer.parseInt(cursor.getString(4))));
                thu.setGhichu(cursor.getString(5));
                list.add(thu);
            } while (cursor.moveToNext());
        }
        return list;
    }



    //====================================chi==============================//
    public void addChi(Chi chi,ViTien viTien) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_CHI_SOTIEN, chi.getSotien());
        contentValues.put(COLUMN_CHI_THOIGIAN, chi.getThoiGian());
        contentValues.put(COLUMN_CHI_LOAICHIID, chi.getLoaiChiId());
        contentValues.put(COLUMN_CHI_VITIENID, chi.getVitienId());
        contentValues.put(COLUMN_CHI_GHICHU, chi.getGhichu());
        db.insert(TABLE_CHI, null, contentValues);
        viTien= new ViTien(viTien.getName(),viTien.getMoney()-chi.getSotien());
        updateViTien(viTien);
        db.close();
    }

    public void deleteChi(Chi chi,ViTien viTien) {
        SQLiteDatabase db = this.getWritableDatabase();
        ViTien viTien2= new ViTien(viTien.getName(),viTien.getMoney()+chi.getSotien());
        updateViTienByID(viTien2,viTien);
        db.delete(TABLE_CHI, COLUMN_CHI_ID + "=?", new String[]{String.valueOf(chi.getId())});
        db.close();
    }

    public int updateChi(Chi chi,Chi chi2,ViTien viTien) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_CHI_SOTIEN, chi.getSotien());
        values.put(COLUMN_CHI_THOIGIAN, chi.getThoiGian());
        values.put(COLUMN_CHI_LOAICHIID, chi.getLoaiChiId());
        values.put(COLUMN_CHI_VITIENID, chi.getVitienId());
        values.put(COLUMN_CHI_GHICHU, chi.getGhichu());
        viTien = new ViTien(viTien.getName(),viTien.getMoney()+chi2.getSotien()-chi.getSotien());
        updateViTien(viTien);

        // updating row
        return db.update(TABLE_CHI, values, COLUMN_CHI_ID + " = ?",
                new String[]{String.valueOf(chi2.getId())});
    }


    public List<Chi> getAllChi() {

        List<Chi> list = new ArrayList<Chi>();
        String selectQuery = "SELECT  * FROM " + TABLE_CHI;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Chi chi = new Chi();
                chi.setId(Integer.parseInt(cursor.getString(0)));
                chi.setSotien(Integer.parseInt(cursor.getString(1)));
                chi.setThoiGian(cursor.getString(2));
                chi.setLoaiChi(getLoaiChiById(Integer.parseInt(cursor.getString(3))));
                chi.setViTien(getViTienById(Integer.parseInt(cursor.getString(4))));
                chi.setGhichu(cursor.getString(5));
                list.add(chi);
            } while (cursor.moveToNext());
        }
        return list;
    }



    //===============================thoigian====================================//
    public int getThoiGianCount() {
        String countQuery = "SELECT  * FROM " + TABLE_THOIGIAN;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }

    public void addThoiGian() {
        int count = this.getThoiGianCount();
        if (count == 0) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(COLUMN_THOIGIAN_BATDAU, 0);
            contentValues.put(COLUMN_THOIGIAN_KETTHUC, 0);
            db.insert(TABLE_THOIGIAN, null, contentValues);
            db.close();
        }
    }

    public int updateBatDau(String batdau) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_THOIGIAN_BATDAU, batdau);

        // updating row
        return db.update(TABLE_THOIGIAN, values, COLUMN_THOIGIAN_ID + " = ?",
                new String[]{String.valueOf(1)});
    }

    public int updateKetThuc(String ketthuc) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_THOIGIAN_KETTHUC, ketthuc);

        // updating row
        return db.update(TABLE_THOIGIAN, values, COLUMN_THOIGIAN_ID + " = ?",
                new String[]{String.valueOf(1)});
    }

    public String getBatDau() {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_THOIGIAN, new String[] { COLUMN_THOIGIAN_ID,
                        COLUMN_THOIGIAN_BATDAU,COLUMN_THOIGIAN_KETTHUC}, COLUMN_THOIGIAN_ID + "=?",
                new String[] { String.valueOf(1) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        String t=cursor.getString(1);
        return t;
    }

    public String getKetThuc() {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_THOIGIAN, new String[] { COLUMN_THOIGIAN_ID,
                        COLUMN_THOIGIAN_BATDAU,COLUMN_THOIGIAN_KETTHUC}, COLUMN_THOIGIAN_ID + "=?",
                new String[] { String.valueOf(1) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        String t=cursor.getString(2);
        return t;
    }

}
