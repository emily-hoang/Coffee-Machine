package com.example.coffee;

public class Espresso extends CoffeeRecipe {
    static final int water = 250;
    static final int milk = 0;
    static final int beans = 16;
    static final int cost = 4;

    public Espresso () {
        super(water, milk, beans, cost);
    }
}
