package com.pluralsight.testing;

/**
 * Created by Comarch on 2016-10-10.
 */
public class Cafe {

    private int beansInStock = 0;
    private int milkInStock = 0;

    public int getBeansInStock() { return beansInStock; }
    public int getMilkInStock() { return milkInStock; }

    public Coffee brew(CoffeeType coffeeType){ return brew(coffeeType, 1);}

    public Coffee brew(CoffeeType coffeeType, int quantity){
        requirePositive(quantity);

        int requiredBeans = coffeeType.getRequiredBeans() * quantity;
        int requiredMilk = coffeeType.getRequiredMilk() * quantity;
        if(requiredBeans > beansInStock || requiredMilk > milkInStock){
            throw new IllegalStateException("Insufficient beans or milk");
        }

        beansInStock -= requiredBeans;
        milkInStock -= requiredMilk;

        return new Coffee(coffeeType, requiredBeans, requiredMilk);
        //return new Coffee(null, 1 + requiredBeans, 1 + requiredMilk);
    }

    public void restockBeans(int weightInGrams){
        requirePositive(weightInGrams);
        beansInStock += weightInGrams;
    }

    public void restockMilk(int weightInGrams) {
        requirePositive(weightInGrams);
        milkInStock += weightInGrams;
    }

    public void requirePositive(int value){
        if(value < 1){
            throw new IllegalArgumentException();
        }
    }
}
