package com.example.coffee;

import java.util.Scanner;

public class Order {
    public int TakeOrder()
    {
            System.out.println("How many cups of coffee would you like?");

            Scanner scanner = new Scanner(System.in);
            int numberOfCups = scanner.nextInt();

        return numberOfCups;
    }
}
