package com.example.moneymanager.Model;

import java.io.Serializable;

public class Chi implements Serializable {
    private int id;
    private int sotien;
    private LoaiChi loaiChi;
    private ViTien viTien;
    private String ghichu;

    public Chi(int id, int sotien, LoaiThu loaiThu, ViTien viTien, String ghichu) {
        this.id = id;
        this.sotien = sotien;
        this.loaiChi = loaiChi;
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

    public LoaiChi getLoaiChi() {
        return loaiChi;
    }

    public void setLoaiChi(LoaiChi loaiChi) {
        this.loaiChi = loaiChi;
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

    public int getIDLoaiChi(){
        return loaiChi.getId();
    }
}
