package com.codecool.coffee.coffeshop;

public class CoffeeMachine {

    private int waterLevel;
    private int coffeeBeanLevel;
    private int remainingGroundLevel;
    private int maxWaterLevel = 100;
    private int maxBeanLevel = 100;
    private int groundsCapacity = 100;

    static CoffeeMachine instance = new CoffeeMachine();

    private CoffeeMachine() {
    }

    public CoffeeMachine getInstance() {
        return instance;
    }

    private Coffee make(Coffee coffee) {

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
}
