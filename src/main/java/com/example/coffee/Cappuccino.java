package com.example.coffee;

public class Cappuccino extends CoffeeRecipe {
    static final int water = 200;
    static final int milk = 100;
    static final int beans = 12;
    static final int cost = 6;

    public Cappuccino () {
        super(water, milk, beans, cost);
    }
}
