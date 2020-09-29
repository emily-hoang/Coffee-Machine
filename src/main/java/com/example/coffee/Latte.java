package com.example.coffee;

public class Latte extends CoffeeRecipe {
    static final int water = 350;
    static final int milk = 75;
    static final int beans = 20;
    static final int cost = 7;

    public Latte () {
        super(water, milk, beans, cost);
    }
}
