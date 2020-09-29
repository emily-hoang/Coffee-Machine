package com.example.coffee;

import static com.example.coffee.CoffeeType.getCoffeeType;

public class CoffeeFactory implements ICoffeeFactory {
    public ICoffeeRecipe getCoffeeRecipe(int number) {
       CoffeeType type = getCoffeeType(number);

        switch(type) {
            case ESPRESSO:
                return new Espresso();
            case LATTE:
                return new Latte();
            case CAPPUCCINO:
                return new Cappuccino();
            default:
                throw new IllegalArgumentException(" Your coffee is not available. Please choose a different one!");
        }
    }
}
