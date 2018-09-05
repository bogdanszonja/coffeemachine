package com.codecool.coffee.coffeshop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CoffeeMachine {

    private static final Logger logger = LoggerFactory.getLogger(CoffeeMachine.class);


    private int waterLevel;
    private int coffeeBeanLevel;
    private int remainingGroundLevel;
    private final int maxWaterLevel = 1200;
    private final int maxBeanLevel = 200;
    private final int groundsCapacity = 250;

    private static final CoffeeMachine instance = new CoffeeMachine();

    private CoffeeMachine() {
        waterLevel = maxWaterLevel;
        coffeeBeanLevel = maxBeanLevel;
        remainingGroundLevel = groundsCapacity;
    }

    public static CoffeeMachine getInstance() {
        return instance;
    }

    Coffee make(Coffee coffee) {
        logger.debug("make method called with Coffee type: {}.", coffee);

        waterLevel -= coffee.getRequiredWater();
        coffeeBeanLevel -= coffee.getRequiredCoffeeBean();
        remainingGroundLevel -= coffee.getGroundMade();

        return coffee;
    }

    public void refillWater() {
        waterLevel = maxWaterLevel;
    }

    public void refillCoffeeBean() {
        coffeeBeanLevel = maxBeanLevel;
    }

    public void emptyGrounds() { remainingGroundLevel = groundsCapacity; }

    public int getWaterLevel() {
        return waterLevel;
    }

    public int getCoffeeBeanLevel() {
        return coffeeBeanLevel;
    }

    public int getRemainingGroundLevel() {
        return remainingGroundLevel;
    }
}
