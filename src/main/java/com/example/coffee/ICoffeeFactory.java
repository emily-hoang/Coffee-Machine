package com.example.coffee;

public interface ICoffeeFactory {
    ICoffeeRecipe getCoffeeRecipe(final int coffeeType);
}
