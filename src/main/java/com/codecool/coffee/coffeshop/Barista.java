package com.codecool.coffee.coffeshop;

import java.util.ArrayDeque;
import java.util.Deque;

public class Barista {

    private Deque<Order> orders = new ArrayDeque<>();

    private void processOrders(){}

    public void addNewOrder(Order order){
        orders.add(order);
    }

    public void maintainCoffeMachine(){}

    public void brewCoffe(){}
}
