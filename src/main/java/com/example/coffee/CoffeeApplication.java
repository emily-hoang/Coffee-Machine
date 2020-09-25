package com.example.coffee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class CoffeeApplication {
	public static void main(String[] args) {
		SpringApplication.run(CoffeeApplication.class, args);

		process();
	}

	public static void process() {
		String response = "";
		String welcomeMessage = "Welcome to the Baby Coffee Machine!\nDid you know that each coffee cup is made with 200ml of water, 50ml of milk, and 15g of coffee beans?\nBefore you make your order, please provide some information!";

		CoffeeMachine machine = new CoffeeMachine(new Calculator());
		Scanner scanner = new Scanner(System.in);

		do {
			try {
				System.out.println("=======================================================================================");
				System.out.println(welcomeMessage);
				System.out.println("=======================================================================================");

				System.out.println("How many ml of water does the coffee machine has?");
				int water = scanner.nextInt();

				System.out.println("How many ml of milk does the coffee machine has?");
				int milk = scanner.nextInt();

				System.out.println("How many grams of coffee beans does the coffee machine has?");
				int coffeeBeans = scanner.nextInt();

				System.out.println("How many cups of coffee would you like?");
				int numberOfCups = scanner.nextInt();

				response = machine.Response(water, milk, coffeeBeans, numberOfCups);

				if (response.contains("Yes")) {
					printProcessInformation();
					break;
				}
			} catch (Exception ex) {
				System.out.println("Error Message: " + ex);
			}
		} while (response.contains("Sorry"));
	}

	private static void printProcessInformation()
	{
		System.out.println("---------------------------------------------------------------------------------------");
		System.out.println("Starting to make your coffee now.");
		System.out.println("Be patient! I'm grinding coffee beans.");
		System.out.println("Time to boil some water.");
		System.out.println("I'm mixing boiled water with crushed coffee beans. How exciting!");
		System.out.println("Ok. The coffee is ready to be poured into the cup.");
		System.out.println("Oops! I nearly forget to add some milk.");
		System.out.println("Phew!!!! Coffee is ready!");
		System.out.println("Enjoy! See you again!");
		System.out.println("========================================================================================");
	}
}
