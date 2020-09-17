package com.example.coffeeUnitTests;

import com.example.coffee.Calculator;
import com.example.coffee.CoffeeMachine;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CoffeeMachineTests {
    CoffeeMachine machine = new CoffeeMachine(new Calculator());

    @Test
    public void WhenHasEnoughIngredientsToMakeEnoughCoffeeAsRequested_ThenOuputTheAppropiateMessage()
    {
        String expectedMessage = "Yes, I can make that amount of coffee";
        int water = 300;
        int milk = 65;
        int coffee = 100;
        int numberOfCups = 1;
        String actualMessage = machine.Response(water, milk, coffee, numberOfCups);

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void WhenHasMoreIngredientsThanRequestedAmountOfCoffee_ThenOutputTheAppropiateMessage()
    {
        int water = 1550;
        int milk = 299;
        int coffee = 300;
        int numberOfCups = 3;
        int additionalCups = 2;
        String actualMessage = machine.Response(water, milk, coffee, numberOfCups);
        String expectedMessage = "Yes, I can make that amount of coffee (and even " + additionalCups + " more than that)";

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void WhenHasEnoughIngredientsAndNoCoffeeIsRequested_ThenOutputTheAppropiateMessage()
    {
        int water = 200;
        int milk = 50;
        int coffee = 15;
        int numberOfCups = 0;
        int additionalCups = 1;
        String actualMessage = machine.Response(water, milk, coffee, numberOfCups);
        String expectedMessage = "Yes, I can make that amount of coffee (and even " + additionalCups + " more than that)";

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void WhenDoesntHasEnoughIngredientsToMakeTheRequestedAmountOfCoffee_ThenOuputTheAppropiateMessage()
    {
        int water = 500;
        int milk = 250;
        int coffee = 200;
        int numberOfCups = 10;
        int availableCups = 2;
        String expectedMessage = "Sorry, I can make only " + availableCups + " cup(s) of coffee";
        String actualMessage = machine.Response(water, milk, coffee, numberOfCups);

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void WhenHasNoIngredientsToMakeTheRequestedAmountOfCoffee_ThenOuputTheAppropiateMessage()
    {
        int water = 0;
        int milk = 0;
        int coffee = 0;
        int numberOfCups = 1;
        String actualMessage = machine.Response(water, milk, coffee, numberOfCups);
        String expectedMessage = "Sorry, there is not enough ingredients to make coffee!";

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void WhenDoesntHasEnoughIngredientsToMakeAnyCoffee_ThenOuputTheAppropiateMessage()
    {
        int water = 50;
        int milk = 10;
        int coffee = 15;
        int numberOfCups = 3;
        String actualMessage = machine.Response(water, milk, coffee, numberOfCups);
        String expectedMessage = "Sorry, there is not enough ingredients to make coffee!";

        assertEquals(expectedMessage, actualMessage);
    }
}
