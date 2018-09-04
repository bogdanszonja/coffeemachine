package com.codecool.coffee.coffeshop;

import com.codecool.coffee.sql.SQLConnection;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.ArrayDeque;
import java.util.Deque;

public class Barista {

    private Order currentOrder;

    private Deque<Order> orders = new ArrayDeque<>();

    private void preparePriorityOrder() {
        currentOrder = SQLConnection.getPriorityOrder();
    }

    public void addNewOrder(Order order){
        orders.add(order);
    }

    public void maintainCoffeeMachine(Trouble trouble) {
        if (trouble == Trouble.NOT_ENOUGH_COFFEE) {
            CoffeeMachine.getInstance().refillCoffeeBean();
        } else if (trouble == Trouble.NOT_ENOUGH_WATER) {
            CoffeeMachine.getInstance().refillWater();
        } else if (trouble == Trouble.TRASH_IS_FULL) {
            CoffeeMachine.getInstance().emptyGrounds();
        }
    }

    public void brewCoffee() {
        CoffeeMachine.getInstance().make(currentOrder.getCoffeeType());
        SQLConnection.markOrderAsCompleted(currentOrder);
    }
}
