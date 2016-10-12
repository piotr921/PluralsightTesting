package com.pluralsight.testing;

/**
 * Created by Comarch on 2016-10-10.
 */
public enum CoffeeType {
    Latte(7, 227),
    Espresso(8, 0),
    FilterCoffee(10,0);

    private final int requiredBeans;
    private final int requiredMilk;

    CoffeeType(int requiredBeans, int requiredMilk){
        this.requiredBeans = requiredBeans;
        this.requiredMilk = requiredMilk;
    }

    public int getRequiredBeans() {
        return requiredBeans;
    }

    public int getRequiredMilk() {
        return requiredMilk;
    }
}
