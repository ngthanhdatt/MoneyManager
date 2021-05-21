package com.example.moneymanager.Model;

import java.io.Serializable;

public class ViTien implements Serializable {
    private int id;
    private String name;
    private int money;

    public ViTien() {}

    public ViTien(String name, int money) {
        this.name = name;
        this.money = money;
    }

    public ViTien(int id, String name, int money) {
        this.id = id;
        this.name = name;
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
