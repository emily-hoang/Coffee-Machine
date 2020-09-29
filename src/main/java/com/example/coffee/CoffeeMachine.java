package com.example.coffee;

import java.util.HashMap;

public class CoffeeMachine implements ICoffeeMachine {
    private int currentWater;
    private int currentMilk;
    private int currentBeans;
    private int currentCups;
    private int currentMoney;

    public CoffeeMachine(int currentWater, int currentMilk, int currentBeans, int currentCups, int currentMoney) {
        this.currentWater = currentWater;
        this.currentMilk = currentMilk;
        this.currentBeans = currentBeans;
        this.currentCups = currentCups;
        this.currentMoney = currentMoney;
    }

    public HashMap<String, Integer> getResources() {
        HashMap<String, Integer> machineState = new HashMap<>();

        machineState.put("water", currentWater);
        machineState.put("milk", currentMilk);
        machineState.put("beans", currentBeans);
        machineState.put("cups", currentCups);
        machineState.put("money", currentMoney);

        return machineState;
    }

    public boolean makeCoffee(ICoffeeRecipe coffeeRecipe, int requestedCups) {
        int requiredWater = coffeeRecipe.getWater() * requestedCups;
        int requiredMilk = coffeeRecipe.getMilk() * requestedCups;
        int requiredBeans = coffeeRecipe.getBeans() * requestedCups;
        int cost = coffeeRecipe.getCost() * requestedCups;
        boolean canMakeCoffee = canMakeCoffee(requiredWater, requiredMilk, requiredBeans, requestedCups);

        if (canMakeCoffee) {
            this.currentWater = currentWater - requiredWater;
            this.currentMilk = currentMilk - requiredMilk;
            this.currentBeans = currentBeans - requiredBeans;
            this.currentMoney = currentMoney + cost;
            this.currentCups = currentCups - requestedCups;

            return true;
        } else {
            return false;
        }
    }

    public void refillResources(int refillWater, int refillMilk, int refillBeans, int refillCups) {
        this.currentWater = currentWater + refillWater;
        this.currentMilk = currentMilk + refillMilk;
        this.currentBeans = currentBeans + refillBeans;
        this.currentCups = currentCups + refillCups;
    }

    public int dispenseMoney() {
        int dispensedMoney = currentMoney;
        this.currentMoney = 0;

        return dispensedMoney;
    }

    private boolean canMakeCoffee(int requiredWater, int requiredMilk, int requiredBeans, int requiredCups) {
        if (currentWater >= requiredWater && currentMilk >= requiredMilk && currentBeans >= requiredBeans && currentCups >= requiredCups) {
            return true;
        }
        return false;
    }

}


