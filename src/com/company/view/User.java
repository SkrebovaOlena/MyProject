package com.company.view;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String name;
    private String password;
    private boolean isAdmin;
    private boolean blocked;
    private List<Order> orders = new ArrayList<>();

    public User(String name, String password, boolean isAdmin, boolean blocked) {
        this.name = name;
        this.password = password;
        this.isAdmin = isAdmin;
        this.blocked = blocked;
        orders.add(new Order());
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }
}
