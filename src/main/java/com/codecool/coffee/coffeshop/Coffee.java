package com.codecool.coffee.coffeshop;

public enum Coffee {

    ESPRESSO (100, 10, 10, 25),
    LONG (150, 15, 15, 30),
    DOPPIO (200, 20, 20, 30),
    AMERICANO (300, 30, 30, 35);

    private int requiredWater;
    private int requiredCoffeeBean;
    private int groundMade;
    private int brewingTime;

    Coffee(int requiredWater, int requiredCoffeeBean, int groundMade, int brewingTime) {
        this.requiredWater = requiredWater;
        this.requiredCoffeeBean = requiredCoffeeBean;
        this.groundMade = groundMade;
        this.brewingTime = brewingTime;
    }

    public int getRequiredWater() {
        return requiredWater;
    }

    public int getRequiredCoffeeBean() {
        return requiredCoffeeBean;
    }

    public int getGroundMade() {
        return groundMade;
    }

    public int getBrewingTime() {
        return brewingTime;
    }
}
