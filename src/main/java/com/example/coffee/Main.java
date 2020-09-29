package com.example.coffee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Scanner;

@SpringBootApplication
public class Main {
	private static Scanner scanner = new Scanner(System.in);
	private static ICoffeeFactory factory = new CoffeeFactory();
	private static ICoffeeMachine machine = new CoffeeMachine(400, 540, 120, 9, 550);
	private static CoffeeType[] types = CoffeeType.values();


	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
		process();
	}

	private static void process() {
		try {
			printWelcomeMessage();
			printMachineResources(machine);

			System.out.println("What would you like to do? Our options are: buy, fill, take.");
			String action = scanner.nextLine().toLowerCase();

			if (action.equals("buy")) {
				System.out.println("What do you want to buy? Our options are:");
				for(CoffeeType type : types) {
					System.out.println( type.number + " - " + type.name() );
				}
				int coffeeOrder = scanner.nextInt();

				System.out.println("How many coffee would you like?");
				int requestedCups = scanner.nextInt();

				if (makeCoffeeOrder(coffeeOrder, requestedCups)) {
					printProcessInformation();
				} else {
					System.out.println("Sorry, there are not enough resources to make your order!");
				}

				printMachineResources(machine);
			} else if (action.equals("take")) {
				int money = machine.dispenseMoney();
				System.out.println("You have receive " + money + " from the machine.");

				printMachineResources(machine);
			} else if (action.equals("fill")) {
				HashMap<String, Integer> resources = getResourcesFromUser();
				int water = resources.get("water");
				int milk = resources.get("milk");
				int beans = resources.get("beans");
				int cups = resources.get("cups");

				machine.refillResources(water, milk, beans, cups);

				printMachineResources(machine);
			}
		} catch (Exception ex) {
			System.out.println("Error Message: " + ex);
		}
	}

	private static boolean makeCoffeeOrder(int coffeeOrder, int requestedCups) {
		ICoffeeRecipe coffeeRecipe = factory.getCoffeeRecipe(coffeeOrder);
		boolean isCoffeeMade = machine.makeCoffee(coffeeRecipe, requestedCups);
		return isCoffeeMade;
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

	private static void printWelcomeMessage()
	{
		String welcomeMessage = "Welcome to the Baby Coffee Machine!\nDid you know that each coffee cup is made with 200ml of water, 50ml of milk, and 15g of coffee beans?";
		System.out.println("=======================================================================================");
		System.out.println(welcomeMessage);
		System.out.println("=======================================================================================");

	}

	private static void printMachineResources(ICoffeeMachine machine)
	{
		HashMap<String, Integer> state = machine.getResources();
		int water = state.get("water");
		int milk = state.get("milk");
		int beans = state.get("beans");
		int cups = state.get("cups");
		int money = state.get("money");

		System.out.println("The coffee machine has:");
		System.out.println(String.format("%s of water\n%s of milk\n%s of beans\n%s of disposable cups\n%s of money", water, milk, beans, cups, money));

	}

	private static HashMap<String, Integer> getResourcesFromUser() {
		HashMap<String, Integer> resources = new HashMap<>();
		System.out.println("How many ml of water do you want to add?");
		int water = scanner.nextInt();
		System.out.println("How many ml of milk do you want to add?");
		int milk = scanner.nextInt();
		System.out.println("How many grams of beans do you want to add?");
		int beans = scanner.nextInt();
		System.out.println("How many cups do you want to add?");
		int cups = scanner.nextInt();

		resources.put("water", water);
		resources.put("milk", milk);
		resources.put("beans", beans);
		resources.put("cups", cups);

		return resources;
	}
}
