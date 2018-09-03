package com.codecool.coffee.coffeshop;

import java.util.Date;

public class Order {
    private String customerName;
    private Coffee coffeeType;
    private Date orderTime;
    private Room customerRoom;
    private int id;

    public void setId(int id) {
        this.id = id;
    }
}
