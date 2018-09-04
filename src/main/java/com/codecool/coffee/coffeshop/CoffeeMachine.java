package com.codecool.coffee.coffeshop;

public class CoffeeMachine {

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
