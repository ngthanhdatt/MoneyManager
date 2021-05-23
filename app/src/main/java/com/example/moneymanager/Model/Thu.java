package com.example.moneymanager.Model;

import java.io.Serializable;

public class Thu implements Serializable {
    private int id;
    private int sotien;
    private String thoiGian;
    private LoaiThu loaiThu;
    private ViTien viTien;
    private String ghichu;

    public Thu() {
    }

    public Thu(int id, int sotien, LoaiThu loaiThu, ViTien viTien, String ghichu) {
        this.id = id;
        this.sotien = sotien;
        this.loaiThu = loaiThu;
        this.viTien = viTien;
        this.ghichu = ghichu;
    }

    public Thu(int sotien, String thoiGian, LoaiThu loaiThu, ViTien viTien, String ghichu) {
        this.sotien = sotien;
        this.thoiGian = thoiGian;
        this.loaiThu = loaiThu;
        this.viTien = viTien;
        this.ghichu = ghichu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }

    public int getSotien() {
        return sotien;
    }

    public void setSotien(int sotien) {
        this.sotien = sotien;
    }

    public String getGhichu() {
        return ghichu;
    }

    public LoaiThu getLoaiThu() {
        return loaiThu;
    }

    public void setLoaiThu(LoaiThu loaiThu) {
        this.loaiThu = loaiThu;
    }

    public ViTien getViTien() {
        return viTien;
    }

    public void setViTien(ViTien viTien) {
        this.viTien = viTien;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public int getIDViTien() {
        return viTien.getId();
    }

    public int getIDLoaiThu() {
        return loaiThu.getId();
    }
}
