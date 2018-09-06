package com.codecool.coffee.coffeshop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Coffee Machine singleton.
 * It is capable of making coffee.
 *
 * @author  Szabó Anita, Kiszely Milán, Bogdán Szonja
 * @version 1.0
 * @since   2018-09-05
 */
public class CoffeeMachine {

    private static final Logger logger = LoggerFactory.getLogger(CoffeeMachine.class);

    private int waterLevel;
    private int coffeeBeanLevel;
    private int remainingGroundLevel;
    private final int maxWaterLevel = 1200;
    private final int maxBeanLevel = 200;
    private final int groundsCapacity = 250;

    private static final CoffeeMachine instance = new CoffeeMachine();

    /**
     * Class constructor.
     */
    private CoffeeMachine() {
        waterLevel = maxWaterLevel;
        coffeeBeanLevel = maxBeanLevel;
        remainingGroundLevel = groundsCapacity;
    }

    public static CoffeeMachine getInstance() {
        return instance;
    }

    /**
     * Make method returns a Coffee type coffee.
     * The class fields change based on the type of the coffee.
     *
     * @param coffee
     * @return Coffee
     */
    Coffee make(Coffee coffee) {
        logger.debug("make method called with Coffee type: {}.", coffee);

        waterLevel -= coffee.getRequiredWater();
        coffeeBeanLevel -= coffee.getRequiredCoffeeBean();
        remainingGroundLevel -= coffee.getGroundMade();

        return coffee;
    }

    /**
     * Set waterLevel to max.
     */
    public void refillWater() {
        waterLevel = maxWaterLevel;
    }

    /**
     * Set coffeeBeanLevel to max.
     */
    public void refillCoffeeBean() {
        coffeeBeanLevel = maxBeanLevel;
    }

    /**
     * Set remainingGroundLevel to max.
     */
    public void emptyGrounds() { remainingGroundLevel = groundsCapacity; }

    /**
     *
     * @return the current level of water in int.
     */
    public int getWaterLevel() {
        return waterLevel;
    }

    /**
     *
     * @return the current level of coffee beans in int.
     */
    public int getCoffeeBeanLevel() {
        return coffeeBeanLevel;
    }

    /**
     *
     * @return the remaining ground level in int.
     */
    public int getRemainingGroundLevel() {
        return remainingGroundLevel;
    }
}
