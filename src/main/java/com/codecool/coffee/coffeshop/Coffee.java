package com.codecool.coffee.coffeshop;

/**
 * Coffee types that can be used.
 */
public enum Coffee {

    /**
     * Espresso coffee.
     */
    ESPRESSO (100, 10, 10, 25),

    /**
     * Long coffee.
     */
    LONG (150, 15, 15, 30),

    /**
     * Doppio coffee.
     */
    DOPPIO (200, 20, 20, 30),

    /**
     * Americano coffee.
     */
    AMERICANO (300, 30, 30, 35);

    private int requiredWater;
    private int requiredCoffeeBean;
    private int groundMade;
    private int brewingTime;

    /**
     * Class constructor.
     *
     * @param requiredWater
     * @param requiredCoffeeBean
     * @param groundMade
     * @param brewingTime
     */
    Coffee(int requiredWater, int requiredCoffeeBean, int groundMade, int brewingTime) {
        this.requiredWater = requiredWater;
        this.requiredCoffeeBean = requiredCoffeeBean;
        this.groundMade = groundMade;
        this.brewingTime = brewingTime;
    }

    /**
     * Getter method for required water.
     *
     * @return int requiredWater.
     */
    public int getRequiredWater() {
        return requiredWater;
    }

    /**
     * Getter method for required coffee bean.
     *
     * @return int requiredCoffeeBean.
     */
    public int getRequiredCoffeeBean() {
        return requiredCoffeeBean;
    }

    /**
     * Getter method for ground made.
     *
     * @return int groundMade.
     */
    public int getGroundMade() {
        return groundMade;
    }

    /**
     * Getter method for brewing time.
     *
     * @return int brewingTime.
     */
    public int getBrewingTime() {
        return brewingTime;
    }
}
