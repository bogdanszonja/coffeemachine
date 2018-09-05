package com.codecool.coffee.coffeshop;

import com.codecool.coffee.sql.SQLConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.activity.InvalidActivityException;
import java.util.ArrayDeque;
import java.util.Deque;


public final class Barista {

    private static final Logger logger = LoggerFactory.getLogger(Barista.class);
    private static Barista instance = null;

    private Order currentOrder;

    private Deque<Order> orders = new ArrayDeque<>();

    public static Barista getInstance() {
        if (instance == null) {
            instance = new Barista();
        }
        return instance;
    }

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

    public void brewCoffee(int id) throws InvalidActivityException{
        preparePriorityOrder();
        if(id == currentOrder.getId()) {
            CoffeeMachine.getInstance().make(currentOrder.getCoffeeType());
            SQLConnection.markOrderAsCompleted(currentOrder);
        } else {
            throw new InvalidActivityException();
        }
    }
}
