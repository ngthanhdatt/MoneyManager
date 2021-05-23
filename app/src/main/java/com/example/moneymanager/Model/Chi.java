package com.example.moneymanager.Model;

import java.io.Serializable;

public class Chi implements Serializable {
    private int id;
    private int sotien;
    private String thoiGian;
    private LoaiChi loaiChi;
    private ViTien viTien;
    private String ghichu;

    public Chi() {
    }

    public Chi(int id, int sotien, LoaiChi loaiChi, ViTien viTien, String ghichu) {
        this.id = id;
        this.sotien = sotien;
        this.loaiChi = loaiChi;
        this.viTien = viTien;
        this.ghichu = ghichu;
    }

    public Chi(int sotien, String thoiGian, LoaiChi loaiChi, ViTien viTien, String ghichu) {
        this.sotien = sotien;
        this.thoiGian = thoiGian;
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

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public int getVitienId() {
        return viTien.getId();
    }

    public int getLoaiChiId() {
        return loaiChi.getId();
    }


}
