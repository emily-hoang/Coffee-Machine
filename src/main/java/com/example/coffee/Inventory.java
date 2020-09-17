package com.example.coffee;

import java.util.Scanner;

public class Inventory {
    public int GetMillilitreOfWater()
    {
        System.out.println("How many ml of water does the coffee machine has?");

        Scanner scanner = new Scanner(System.in);
        int waterAmount = scanner.nextInt();

        return waterAmount;
    }

    public int GetMillilitreOfMilk()
    {
        System.out.println("How many ml of milk does the coffee machine has?");

        Scanner scanner = new Scanner(System.in);
        int milkAmount = scanner.nextInt();

        return milkAmount;
    }

    public int GetGramOfCoffeeBeans()
    {
        System.out.println("How many grams of coffee beans does the coffee machine has?");

        Scanner scanner = new Scanner(System.in);
        int coffeeAmount = scanner.nextInt();

        return coffeeAmount;
    }
}
