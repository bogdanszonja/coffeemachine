package com.codecool.coffee.coffeshop;

import java.util.ArrayDeque;
import java.util.Deque;

public class Barista {

    private Deque<Order> orders = new ArrayDeque<>();

    private void processOrders(){}

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

    }
}
