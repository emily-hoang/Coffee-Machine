package com.example.coffee;

import java.util.Arrays;

public class Calculator {
    final int WATER_PER_CUP = 200;
    final int MILK_PER_CUP = 50;
    final int BEANS_PER_CUP = 15;

    public int calculateRequiredWater(int requestedCups) {
        return WATER_PER_CUP * requestedCups;
    }

    public int calculateRequiredMilk(int requestedCups) {
        return MILK_PER_CUP * requestedCups;
    }

    public int calculateRequiredBeans(int requestedCups) {
        return BEANS_PER_CUP * requestedCups;
    }

    public int calculateAdditionalCups(int availableCups, int requestedCups)
    {
        return availableCups - requestedCups;
    }

    public int calculateAvailableCupsWithBeans(int availableIngredient) {
        return availableIngredient / BEANS_PER_CUP;
    }

    public int calculateAvailableCupsWithWater(int availableIngredient) {
        return availableIngredient / WATER_PER_CUP;
    }

    public int calculateAvailableCupsWithMilk(int availableIngredient) {
        return availableIngredient / MILK_PER_CUP;
    }

    public int GetMinimumAvailableCups(int availableCupsWithWater, int availableCupsWithMilk, int availableCupsWithBeans) {
        int cupsAvailableByIngredients[] = {availableCupsWithWater, availableCupsWithMilk, availableCupsWithBeans};
        int availableCups = getMinimum(cupsAvailableByIngredients);
        return availableCups;
    }

    private int getMinimum(int[] a) { Arrays.sort(a); return a[0]; }
}
