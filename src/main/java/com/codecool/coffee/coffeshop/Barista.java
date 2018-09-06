package com.codecool.coffee.coffeshop;

import com.codecool.coffee.sql.SQLConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.activity.InvalidActivityException;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * The Barista singleton knows about all of the orders.
 * It is capable of maintain the coffee machine and brew coffee.
 *
 * @author  Szabó Anita, Kiszely Milán, Bogdán Szonja
 * @version 1.0
 * @since   2018-09-05
 */
public final class Barista {

    private static final Logger logger = LoggerFactory.getLogger(Barista.class);
    private static Barista instance = null;

    private Order currentOrder;

    private Deque<Order> orders = new ArrayDeque<>();
    private CoffeeMachine coffeeMachine = CoffeeMachine.getInstance();

    /**
     * Private class constructor.
     */
    private Barista() {
    }

    /**
     *
     * @return Barista instance
     */
    public static Barista getInstance() {
        if (instance == null) {
            instance = new Barista();
        }
        return instance;
    }

    /**
     * Sets the currentOrder with the oldest order from the database.
     */
    private void preparePriorityOrder() {
        currentOrder = SQLConnection.getPriorityOrder();
    }

    /**
     * Maintains the coffee machine based on the kind of trouble it has.
     *
     * @param trouble
     */
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

    /**
     * Checks if the given id from the database is equal to the current order.
     * If it is true, it brews the coffee.
     * If it is false, it throws an exception.
     *
     * @param id
     * @throws InvalidActivityException
     */
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
