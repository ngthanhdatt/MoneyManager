package com.example.moneymanager.Model;

import java.io.Serializable;

public class Thu implements Serializable {
    private int id;
    private int sotien;
    private LoaiThu loaiThu;
    private ViTien viTien;
    private String ghichu;

    public Thu(int id, int sotien, LoaiThu loaiThu, ViTien viTien, String ghichu) {
        this.id = id;
        this.sotien = sotien;
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

    public int getIDViTien(){
        return viTien.getId();
    }

    public int getIDLoaiThu(){
        return loaiThu.getId();
    }
}
