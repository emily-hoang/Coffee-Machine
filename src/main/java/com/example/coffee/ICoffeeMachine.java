package com.example.coffee;

import java.util.HashMap;

public interface ICoffeeMachine {
    HashMap<String, Integer> getResources();
    boolean makeCoffee(ICoffeeRecipe coffeeRecipe, int cupsOrder);
    void refillResources(int refillWater, int refillMilk, int refillBeans, int refillCups);
    int dispenseMoney();
}
