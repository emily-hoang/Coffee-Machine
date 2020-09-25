package com.example.coffee;

import java.util.HashMap;

public class CoffeeMachine {
    private Calculator calculator;
    private int water;
    private int milk;
    private int beans;
    private int cups;
    private int money;

    public CoffeeMachine(int water, int milk, int beans, int cups, int money ) {
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.cups = cups;
        this.money = money;
    }

    public CoffeeMachine(Calculator calculator) {
        this.calculator = calculator;
    }


    public String Response(int availableWater, int availableMilk, int availableCoffeeBeans, int requiredCups) {
        int requiredWater = calculator.calculateRequiredWater(requiredCups);
        int requiredMilk = calculator.calculateRequiredMilk(requiredCups);
        int requiredBeans= calculator.calculateRequiredBeans(requiredCups);

        int availableCupsWithWater = calculator.calculateAvailableCupsWithWater(availableWater);
        int availableCupsWithMilk = calculator.calculateAvailableCupsWithMilk(availableMilk);
        int availableCupsWithCoffeeBeans = calculator.calculateAvailableCupsWithBeans(availableCoffeeBeans);

        int availableCups = calculator.GetMinimumAvailableCups(availableCupsWithWater, availableCupsWithMilk, availableCupsWithCoffeeBeans);
        int additionalCups = calculator.calculateAdditionalCups(availableCups, requiredCups);

        boolean canMakeCoffee = canMakeCoffee(requiredWater, requiredMilk, requiredBeans, requiredCups);

        if (availableCups > requiredCups) {
            String message1 = "Yes, I can make that amount of coffee (and even " + additionalCups + " more than that).";
            System.out.println(message1);
            return message1;
        } else if (availableCups < requiredCups) {
            String message3 = "Sorry, I can make only " + availableCups + " cup(s) of coffee.";
            System.out.println(message3);
            return message3;
        } else if (canMakeCoffee) {
            String message2 = "Yes, I can make that amount of coffee.";
            System.out.println(message2);
            return message2;
        } else {
            String message = "Sorry, the coffee machine is having a break. Please come back later";
            return message;
        }
    }

    private boolean canMakeCoffee( int requiredWater, int requiredMilk, int requiredBeans, int requiredCups)
    {
        if (water >= requiredWater && milk >= requiredMilk && beans >= requiredBeans && cups >= requiredCups)
        { return true; }
        return false;
    }

    public HashMap<String, Integer> getState() {
        HashMap<String, Integer> machineState = new HashMap<>();

        machineState.put("water", water);
        machineState.put("milk", milk);
        machineState.put("beans", beans);
        machineState.put("cups", cups);
        machineState.put("money", money);

        return machineState;
    }

    public boolean makeCoffee(ICoffeeRecipe coffeeRecipe, int cupsOrder) {
        int requiredWater = coffeeRecipe.water * cupsOrder;
        int requiredMilk = coffeeRecipe.milk * cupsOrder;
        int requiredBeans = coffeeRecipe.beans * cupsOrder;
        int cost = coffeeRecipe.cost * cupsOrder;

        if(canMakeCoffee(requiredWater, requiredMilk, requiredBeans, cupsOrder)) {
            this.water = water - requiredWater;
            this.milk = milk - requiredMilk;
            this.beans = beans - requiredBeans;
            this.money = money + cost;
            this.cups = cups - cupsOrder;

            return true;
        } else {
            return false;
        }
    }

    enum CoffeeTypes {
        ESPRESSO, LATTE, CAPPUCCINO
    }
}


