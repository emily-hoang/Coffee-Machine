package com.example.coffeeUnitTests;

import com.example.coffee.CoffeeMachine;
import com.example.coffee.CoffeeRecipe;
import com.example.coffee.ICoffeeMachine;
import com.example.coffee.ICoffeeRecipe;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.test.context.ContextConfiguration;
import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ContextConfiguration
public class CoffeeMachineTests {
    int currentWater = 600;
    int currentMilk = 400;
    int currentBeans = 100;
    int currentCups = 10;
    int currentMoney = 500;

    ICoffeeMachine machine = new CoffeeMachine(currentWater, currentMilk, currentBeans, currentCups, currentMoney);

    @Test
    public void PrintOutTheCurrentResourcesOfTheCoffeeMachine()
    {
        HashMap<String, Integer> expectedMachineResources = new HashMap<>();

        expectedMachineResources.put("water", currentWater);
        expectedMachineResources.put("milk", currentMilk);
        expectedMachineResources.put("beans", currentBeans);
        expectedMachineResources.put("cups", currentCups);
        expectedMachineResources.put("money", currentMoney);

        HashMap<String, Integer> actualMachineResources = machine.getResources();

        assertTrue(expectedMachineResources.equals(actualMachineResources));
    }

    @ParameterizedTest
    @CsvSource({"250, 0, 16, 4, 1", "350, 75, 20, 7, 1", "200, 100, 12, 6, 1"})
    public void WhenAbleToMakeCoffee_ThenReturnTrue(int requiredWater, int requiredMilk, int requiredBeans, int cost, int requiredCups)
    {
        ICoffeeRecipe mockCoffeeRecipe = mock(ICoffeeRecipe.class);
        doReturn(requiredWater).when(mockCoffeeRecipe).getWater();
        doReturn(requiredMilk).when(mockCoffeeRecipe).getMilk();
        doReturn(requiredBeans).when(mockCoffeeRecipe).getBeans();
        doReturn(cost).when(mockCoffeeRecipe).getCost();

        boolean makeCoffee = machine.makeCoffee(mockCoffeeRecipe, requiredCups);

        assertEquals(true, makeCoffee);
    }

    @ParameterizedTest
    @CsvSource({"250, 0, 16, 4, 20", "350, 75, 20, 7, 20", "200, 100, 12, 6, 20"})
    public void WhenNotAbleToMakeCoffee_ThenReturnFalse(int requiredWater, int requiredMilk, int requiredBeans, int cost, int requiredCups)
    {
        ICoffeeRecipe mockCoffeeRecipe = mock(ICoffeeRecipe.class);
        doReturn(requiredWater).when(mockCoffeeRecipe).getWater();
        doReturn(requiredMilk).when(mockCoffeeRecipe).getMilk();
        doReturn(requiredBeans).when(mockCoffeeRecipe).getBeans();
        doReturn(cost).when(mockCoffeeRecipe).getCost();

        boolean makeCoffee = machine.makeCoffee(mockCoffeeRecipe, requiredCups);

        assertEquals(false, makeCoffee);
    }

    @ParameterizedTest
    @CsvSource({"250, 0, 16, 4, 1", "350, 75, 20, 7, 1", "200, 100, 12, 6, 1"})
    public void WhenCoffeeOrderIsMade_ThenReturnTheCorrectResources(int requiredWater, int requiredMilk, int requiredBeans, int cost, int requiredCups)
    {
        ICoffeeRecipe mockCoffeeRecipe = mock(ICoffeeRecipe.class);
        doReturn(requiredWater).when(mockCoffeeRecipe).getWater();
        doReturn(requiredMilk).when(mockCoffeeRecipe).getMilk();
        doReturn(requiredBeans).when(mockCoffeeRecipe).getBeans();
        doReturn(cost).when(mockCoffeeRecipe).getCost();

        machine.makeCoffee(mockCoffeeRecipe, requiredCups);
        HashMap<String, Integer> resourcesAfterTransaction = machine.getResources();

        int expectedWaterAfterTransaction = currentWater - requiredWater;
        int expectedMilkAfterTransaction = currentMilk - requiredMilk;
        int expectedBeansAfterTransaction = currentBeans - requiredBeans;
        int expectedMoneyAfterTransaction = currentMoney + cost;
        int expectedCupsAfterTransaction = currentCups - requiredCups;

        int actualWaterAfterTransaction = resourcesAfterTransaction.get("water");
        int actualMilkAfterTransaction = resourcesAfterTransaction.get("milk");
        int actualBeansAfterTransaction = resourcesAfterTransaction.get("beans");
        int actualMoneyAfterTransaction = resourcesAfterTransaction.get("money");
        int actualCupsAfterTransaction = resourcesAfterTransaction.get("cups");

        assertEquals(expectedWaterAfterTransaction, actualWaterAfterTransaction);
        assertEquals(expectedMilkAfterTransaction, actualMilkAfterTransaction);
        assertEquals(expectedBeansAfterTransaction, actualBeansAfterTransaction);
        assertEquals(expectedCupsAfterTransaction, actualCupsAfterTransaction);
        assertEquals(expectedMoneyAfterTransaction, actualMoneyAfterTransaction);
    }

    @ParameterizedTest
    @CsvSource({"250, 0, 16, 4, 20", "350, 75, 20, 7, 20", "200, 100, 12, 6, 20"})
    public void WhenCoffeeOrderIsNotMade_ThenReturnTheCorrectResources(int requiredWater, int requiredMilk, int requiredBeans, int cost, int requiredCups)
    {
        ICoffeeRecipe mockCoffeeRecipe = mock(ICoffeeRecipe.class);
        doReturn(requiredWater).when(mockCoffeeRecipe).getWater();
        doReturn(requiredMilk).when(mockCoffeeRecipe).getMilk();
        doReturn(requiredBeans).when(mockCoffeeRecipe).getBeans();
        doReturn(cost).when(mockCoffeeRecipe).getCost();

        machine.makeCoffee(mockCoffeeRecipe, requiredCups);
        HashMap<String, Integer> resourcesAfterTransaction = machine.getResources();

        int expectedWaterAfterTransaction = currentWater;
        int expectedMilkAfterTransaction = currentMilk;
        int expectedBeansAfterTransaction = currentBeans;
        int expectedMoneyAfterTransaction = currentMoney;
        int expectedCupsAfterTransaction = currentCups;

        int actualWaterAfterTransaction = resourcesAfterTransaction.get("water");
        int actualMilkAfterTransaction = resourcesAfterTransaction.get("milk");
        int actualBeansAfterTransaction = resourcesAfterTransaction.get("beans");
        int actualMoneyAfterTransaction = resourcesAfterTransaction.get("money");
        int actualCupsAfterTransaction = resourcesAfterTransaction.get("cups");

        assertEquals(expectedWaterAfterTransaction, actualWaterAfterTransaction);
        assertEquals(expectedMilkAfterTransaction, actualMilkAfterTransaction);
        assertEquals(expectedBeansAfterTransaction, actualBeansAfterTransaction);
        assertEquals(expectedCupsAfterTransaction, actualCupsAfterTransaction);
        assertEquals(expectedMoneyAfterTransaction, actualMoneyAfterTransaction);
    }

    @ParameterizedTest
    @CsvSource({"500, 400, 150, 10", "200, 400, 300, 20"})
    public void WhenRefillingResources_ThenReturnTheCorrectResources(int refillWater, int refillMilk, int refillBeans, int refillCups)
    {
        machine.refillResources(refillWater, refillMilk, refillBeans, refillCups);
        HashMap<String, Integer> resourcesAfterTransaction = machine.getResources();

        int expectedCurrentWaterAfterRefilling = currentWater + refillWater;
        int expectedCurrentMilkAfterRefilling = currentMilk + refillMilk;
        int expectedCurrentBeansAfterRefilling = currentBeans + refillBeans;
        int expectedCurrentCupsAfterRefilling = currentCups + refillCups;

        int actualCurrentWaterAfterRefilling = resourcesAfterTransaction.get("water");
        int actualCurrentMilkAfterRefilling = resourcesAfterTransaction.get("milk");
        int actualCurrentBeansAfterRefilling = resourcesAfterTransaction.get("beans");
        int actualCurrentCupsAfterRefilling = resourcesAfterTransaction.get("cups");

        assertEquals(expectedCurrentWaterAfterRefilling, actualCurrentWaterAfterRefilling);
        assertEquals(expectedCurrentMilkAfterRefilling, actualCurrentMilkAfterRefilling);
        assertEquals(expectedCurrentBeansAfterRefilling, actualCurrentBeansAfterRefilling);
        assertEquals(expectedCurrentCupsAfterRefilling, actualCurrentCupsAfterRefilling);
    }

    @Test
    public void AfterDispensingMoney_ThenReturnTheCorrectDispensedMoneyAmount()
    {
        int actualDispensedMoney = machine.dispenseMoney();
        assertEquals(actualDispensedMoney, currentMoney);

        HashMap<String, Integer> resourcesAfterTransaction = machine.getResources();

        int expectedCurrentMoneyAfterDispensing = resourcesAfterTransaction.get("money");
        assertEquals(expectedCurrentMoneyAfterDispensing, 0);
    }
}
