package com.example.coffeeUnitTests;

import com.example.coffee.CoffeeMachine;
import com.example.coffee.ICoffeeRecipe;
import com.example.coffee.ICoffeeRecipe;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.test.context.ContextConfiguration;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

@ContextConfiguration
public class CoffeeMachineTests {
    int currentWater = 600;
    int currentMilk = 400;
    int currentBeans = 100;
    int currentCups = 10;
    int currentMoney = 500;

    CoffeeMachine machine = new CoffeeMachine(currentWater, currentMilk, currentBeans, currentCups, currentMoney);

    @ParameterizedTest
    @CsvSource({ "300, 65, 100, 1" })
    public void WhenHasEnoughIngredientsToMakeEnoughCoffeeOrder_ThenOutputTheAppropriateMessage(int water, int milk, int coffee, int requestedCups)
    {
        String expectedMessage = "Yes, I can make that amount of coffee.";
        String actualMessage = machine.Response(water, milk, coffee, requestedCups);

        assertEquals(expectedMessage, actualMessage);
    }

    @ParameterizedTest
    @CsvSource({ "1550, 299, 300, 3, 2" })
    public void WhenHasEnoughIngredientsToMakeMoreCoffeeThanOrder_ThenOutputTheAppropriateMessage(int water, int milk, int coffee, int requestedCups, int additionalCups)
    {
        String actualMessage = machine.Response(water, milk, coffee, requestedCups);
        String expectedMessage = "Yes, I can make that amount of coffee (and even " + additionalCups + " more than that).";

        assertEquals(expectedMessage, actualMessage);
    }

    @ParameterizedTest
    @CsvSource({ "200, 50, 15, 0, 1" })
    public void WhenHasEnoughIngredientsAndNoCoffeeIsRequested_ThenOutputTheAppropriateMessage(int water, int milk, int coffee, int requestedCups, int additionalCups)
    {
        String actualMessage = machine.Response(water, milk, coffee, requestedCups);
        String expectedMessage = "Yes, I can make that amount of coffee (and even " + additionalCups + " more than that).";

        assertEquals(expectedMessage, actualMessage);
    }

    @ParameterizedTest
    @CsvSource({ "500, 250, 200, 10, 2" })
    public void WhenDoesntHasEnoughIngredientsToMakeCoffeeOrder_ThenOutputTheAppropriateMessage(int water, int milk, int coffee, int requestedCups, int availableCups)
    {
        String expectedMessage = "Sorry, I can make only " + availableCups + " cup(s) of coffee.";
        String actualMessage = machine.Response(water, milk, coffee, requestedCups);

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void PrintOutTheCurrentStateOfTheCoffeeMachine()
    {
        HashMap<String, Integer> expectedMachineState = new HashMap<>();

        expectedMachineState.put("water", currentWater);
        expectedMachineState.put("milk", currentMilk);
        expectedMachineState.put("beans", currentBeans);
        expectedMachineState.put("cups", currentCups);
        expectedMachineState.put("money", currentMoney);

        HashMap<String, Integer> actualMachineState = machine.getState();

        assertTrue(expectedMachineState.equals(actualMachineState));
    }

    @ParameterizedTest
    @CsvSource({ "1" })
    public void WhenAbleToMakeCoffee_ThenReturnTrue(int cupsOrder)
    {
        ICoffeeRecipe mockCoffeeRecipe = mock(ICoffeeRecipe.class);
        mockCoffeeRecipe.setWater(250);
        mockCoffeeRecipe.setMilk(0);
        mockCoffeeRecipe.setBeans(16);
        mockCoffeeRecipe.setCost(4);

        boolean makeCoffee = machine.makeCoffee(mockCoffeeRecipe, cupsOrder);

        assertEquals(true, makeCoffee);
    }

    @ParameterizedTest
    @CsvSource({ "20" })
    public void WhenNotAbleToMakeCoffee_ThenReturnFalse(int cupsOrder)
    {
        ICoffeeRecipe mockCoffeeRecipe = mock(ICoffeeRecipe.class);
        mockCoffeeRecipe.setWater(250);
        mockCoffeeRecipe.setMilk(0);
        mockCoffeeRecipe.setBeans(16);
        mockCoffeeRecipe.setCost(4);

        boolean makeCoffee = machine.makeCoffee(mockCoffeeRecipe, cupsOrder);

        assertEquals(false, makeCoffee);
    }

    @ParameterizedTest
    @CsvSource({ "1" })
    public void AfterMakingCoffee_ThenReturnTheCurrentState(int cupsOrder)
    {
        HashMap<String, Integer> beforeState = machine.getState();

        ICoffeeRecipe mockCoffeeRecipe = mock(ICoffeeRecipe.class);
        mockCoffeeRecipe.setWater(250);
        mockCoffeeRecipe.setMilk(0);
        mockCoffeeRecipe.setBeans(16);
        mockCoffeeRecipe.setCost(4);

        machine.makeCoffee(mockCoffeeRecipe, cupsOrder);

        HashMap<String, Integer> afterState = machine.getState();

        assertNotEquals(beforeState, afterState);
    }
}
