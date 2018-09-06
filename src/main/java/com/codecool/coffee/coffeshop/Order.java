package com.codecool.coffee.coffeshop;

import java.util.Date;

/**
 * The Order class contains all the necessary information
 * about the customer, the type and the location.
 *
 * @author  Szabó Anita, Kiszely Milán, Bogdán Szonja
 * @version 1.0
 * @since   2018-09-05
 */
public class Order {
    private String customerName;
    private Coffee coffeeType;
    private Date orderTime;
    private Room customerRoom;
    private int id;

    /**
     * Class constructor without id.
     *
     * @param costumerName
     * @param coffeeType
     * @param orderTime
     * @param customerRoom
     */
    public Order(String costumerName, Coffee coffeeType, Date orderTime, Room customerRoom){
        this.customerName = costumerName;
        this.coffeeType = coffeeType;
        this.orderTime = orderTime;
        this.customerRoom = customerRoom;
    }

    /**
     * Class constructor with id.
     *
     * @param id
     * @param costumerName
     * @param coffeeType
     * @param orderTime
     * @param customerRoom
     */
    public Order(int id, String costumerName, Coffee coffeeType, Date orderTime, Room customerRoom){
        this.id = id;
        this.customerName = costumerName;
        this.coffeeType = coffeeType;
        this.orderTime = orderTime;
        this.customerRoom = customerRoom;
    }

    /**
     * Setter method for id.
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter method for id.
     *
     * @return int id.
     */
    public int getId() { return id; }

    /**
     * Getter method for costumerName.
     *
     * @return String costumerName.
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * Getter method for coffeeType.
     *
     * @return Coffee coffeeType.
     */
    public Coffee getCoffeeType() {
        return coffeeType;
    }

    /**
     * Getter method for orderTime.
     *
     * @return Date orderTime.
     */
    public Date getOrderTime() {
        return orderTime;
    }

    /**
     * Getter method for costumerRoom.
     *
     * @return Room customerRoom.
     */
    public Room getCustomerRoom() {
        return customerRoom;
    }
}
