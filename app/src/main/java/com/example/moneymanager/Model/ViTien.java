package com.example.moneymanager.Model;

import java.io.Serializable;

public class ViTien implements Serializable {
    private int id;
    private String name;
    private float cost;
    private User user;

    public ViTien(int id, String name, float cost, User user) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.user = user;
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

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
