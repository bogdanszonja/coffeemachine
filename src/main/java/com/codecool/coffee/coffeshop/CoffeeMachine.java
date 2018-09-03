package com.codecool.coffee.coffeshop;

public class CoffeeMachine {

    private int waterLevel;
    private int coffeeBeanLevel;
    private int remainingGroundLevel;
    private int maxWaterLevel;
    private int maxBeanLevel;
    private int groundsCapacity;

    /*private Coffee make() {
        //not implemented yet
    }*/

    public void refillWater(int waterLevel) {
        this.waterLevel = waterLevel;
    }

    public void refillCoffeeBean(int coffeeBeanLevel) {
        this.coffeeBeanLevel = coffeeBeanLevel;
    }

    public void emptyGrounds(int remainingGroundLevel) {
        this.remainingGroundLevel = remainingGroundLevel;
    }
}
