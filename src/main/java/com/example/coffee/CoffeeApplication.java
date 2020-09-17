package com.example.coffee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CoffeeApplication {
	public static void main(String[] args) {
		SpringApplication.run(CoffeeApplication.class, args);

		Process();
	}

	public static void Process() {
		String response = "";
		String welcomeMessage = "Welcome to the Baby Coffee Machine!";
		String coffeeRecipeInformation = "Did you know that each coffee cup is made with 200ml of water, 50ml of milk, and 15g of coffee beans?";
		String getInformation = "Before you make your order, please provide some information!";

		CoffeeMachine machine = new CoffeeMachine(new Calculator());
		Order order = new Order();
		Inventory inventory = new Inventory();

		do {
			try {
				System.out.println("=============================================================================================================");
				System.out.println(welcomeMessage);
				System.out.println(coffeeRecipeInformation);
				System.out.println(getInformation);
				System.out.println("=============================================================================================================");

				int water = inventory.GetMillilitreOfWater();
				int milk = inventory.GetMillilitreOfMilk();
				int coffee = inventory.GetGramOfCoffeeBeans();
				int numberOfCups = order.TakeOrder();

				response = machine.Response(water, milk, coffee, numberOfCups);
				if (response.contains("Yes")) {
					machine.PrintProcessInformation();
				}
			} catch (Exception ex) {
				System.out.println("Error Message: " + ex);
			}
		} while (response.contains("Sorry"));
	}
}
