package com.example.coffee;

import static com.example.coffee.CoffeeRecipe.*;

public class CoffeeMachine {
    private Calculator calculator;

    public CoffeeMachine(Calculator calculator) {
        this.calculator = calculator;
    }

    public String Response(int availableWater, int availableMilk, int availableCoffeeBeans, int requestedCups) {
        int requiredWater = calculator.CalculateRequiredIngredient(mlOfWaterPerCup, requestedCups);
        int requiredMilk = calculator.CalculateRequiredIngredient(mlOfMilkPerCup, requestedCups);
        int requiredCoffeeBeans = calculator.CalculateRequiredIngredient(gramOfCoffeePerCup, requestedCups);

        int availableCupsWithWater = calculator.CalculateAvailableCupPerIngrtedient(availableWater, mlOfWaterPerCup);
        int availableCupsWithMilk = calculator.CalculateAvailableCupPerIngrtedient(availableMilk, mlOfMilkPerCup);
        int availableCupsWithCoffeeBeans = calculator.CalculateAvailableCupPerIngrtedient(availableCoffeeBeans, gramOfCoffeePerCup);

        int availableCups = calculator.GetMinimumAvailableCups(availableCupsWithWater, availableCupsWithMilk, availableCupsWithCoffeeBeans);
        int additionalCups = availableCups - requestedCups;

        if (availableWater < mlOfWaterPerCup || availableMilk < mlOfMilkPerCup || availableCoffeeBeans < gramOfCoffeePerCup) {
            String message0 = "Sorry, there is not enough ingredients to make coffee!";
            System.out.println(message0);
            return message0;
        } else if (availableCups > requestedCups) {
            String message1 = "Yes, I can make that amount of coffee (and even " + additionalCups + " more than that).";
            System.out.println(message1);
            return message1;
        } else if (availableWater >= requiredWater && availableMilk >= requiredMilk && availableCoffeeBeans >= requiredCoffeeBeans) {
            String message2 = "Yes, I can make that amount of coffee.";
            System.out.println(message2);
            return message2;
        } else if (availableCups < requestedCups) {
            String message3 = "Sorry, I can make only " + availableCups + " cup(s) of coffee.";
            System.out.println(message3);
            return message3;
        } else {
            String message = "Sorry, the coffee machine is having a break. Please come back later";
            return message;
        }
    }

    protected void PrintProcessInformation()
    {
        System.out.println("--------------------------------------------------------------------------------------------------------------");
        System.out.println("Starting to make your coffee now.");
        System.out.println("Be patient! I'm grinding coffee beans.");
        System.out.println("Time to boil some water.");
        System.out.println("I'm mixing boiled water with crushed coffee beans. How exciting!");
        System.out.println("Ok. The coffee is ready to be poured into the cup.");
        System.out.println("Oops! I nearly forget to add some milk.");
        System.out.println("Phew!!!! Coffee is ready!");
        System.out.println("Enjoy! See you again!");
        System.out.println("==============================================================================================================");
    }

}
