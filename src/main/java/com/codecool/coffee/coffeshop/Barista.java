package com.codecool.coffee.coffeshop;

import com.codecool.coffee.sql.SQLConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayDeque;
import java.util.Deque;


public class Barista {

    private static final Logger logger = LoggerFactory.getLogger(Barista.class);

    private Order currentOrder;

    private Deque<Order> orders = new ArrayDeque<>();

    private void preparePriorityOrder() {
        currentOrder = SQLConnection.getPriorityOrder();
    }

    public void addNewOrder(Order order){
        orders.add(order);
    }

    public void maintainCoffeeMachine(Trouble trouble) {
        logger.debug("maintainCoffeeMachine method called with Trouble type: {}.", trouble);
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
