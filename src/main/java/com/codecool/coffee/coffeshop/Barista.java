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
    private CoffeeMachine coffeeMachine = CoffeeMachine.getInstance();

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
            coffeeMachine.refillCoffeeBean();
        } else if (trouble == Trouble.NOT_ENOUGH_WATER) {
            coffeeMachine.refillWater();
        } else if (trouble == Trouble.TRASH_IS_FULL) {
            coffeeMachine.emptyGrounds();
        }
    }

    public void brewCoffee(int id) throws InvalidActivityException{
        preparePriorityOrder();
        int waterRequired = currentOrder.getCoffeeType().getRequiredWater();
        int beanRequired = currentOrder.getCoffeeType().getRequiredCoffeeBean();
        int groundMade = currentOrder.getCoffeeType().getGroundMade();
        if(coffeeMachine.getWaterLevel() - waterRequired >= 0 && coffeeMachine.getCoffeeBeanLevel() - beanRequired >= 0
                && coffeeMachine.getRemainingGroundLevel() - groundMade >= 0) {
            if(id == currentOrder.getId()) {
                coffeeMachine.make(currentOrder.getCoffeeType());
                SQLConnection.markOrderAsCompleted(currentOrder);
            }
        } else {
            throw new InvalidActivityException();
        }
    }
}
