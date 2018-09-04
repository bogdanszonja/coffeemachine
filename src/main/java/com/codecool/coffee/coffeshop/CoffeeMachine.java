package com.codecool.coffee.coffeshop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CoffeeMachine {

    private static final Logger logger = LoggerFactory.getLogger(CoffeeMachine.class);


    private int waterLevel;
    private int coffeeBeanLevel;
    private int remainingGroundLevel;
    private int maxWaterLevel = 100;
    private int maxBeanLevel = 100;
    private int groundsCapacity = 100;

    private static final CoffeeMachine instance = new CoffeeMachine();

    private CoffeeMachine() {
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
