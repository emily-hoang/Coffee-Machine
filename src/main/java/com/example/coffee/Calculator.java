package com.example.coffee;

import java.util.Arrays;

public class Calculator {
    public int CalculateRequiredIngredient(int requiredIngredientPerCup, int requestedCups) {
        return requiredIngredientPerCup * requestedCups;
    }

    public int CalculateAvailableCupPerIngrtedient(int availableIngredient, int gramOfCoffeePerCup) {
        return availableIngredient / gramOfCoffeePerCup;
    }

    public int GetMinimumAvailableCups(int cupsPerWater, int cupsPerMilk, int cupsPerCoffeeBeans) {
        int cupsAvailableByIngredients[] = {cupsPerWater, cupsPerMilk, cupsPerCoffeeBeans};
        int availableCups = getMinimum(cupsAvailableByIngredients);
        return availableCups;
    }

    private int getMinimum(int[] a)
    { Arrays.sort(a); return a[0]; }
}
