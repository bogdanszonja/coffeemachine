package com.codecool.coffee.coffeshop;

import java.util.Date;

public class Order {
    private String customerName;
    private Coffee coffeeType;
    private Date orderTime;
    private Room customerRoom;
    private int id;

    public Order(String costumerName, Coffee coffeeType, Date orderTime, Room customerRoom){
        this.customerName = costumerName;
        this.coffeeType = coffeeType;
        this.orderTime = orderTime;
        this.customerRoom = customerRoom;
    }

    public Order(int id, String costumerName, Coffee coffeeType, Date orderTime, Room customerRoom){
        this.id = id;
        this.customerName = costumerName;
        this.coffeeType = coffeeType;
        this.orderTime = orderTime;
        this.customerRoom = customerRoom;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() { return id; }

    public String getCustomerName() {
        return customerName;
    }

    public Coffee getCoffeeType() {
        return coffeeType;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public Room getCustomerRoom() {
        return customerRoom;
    }
}
