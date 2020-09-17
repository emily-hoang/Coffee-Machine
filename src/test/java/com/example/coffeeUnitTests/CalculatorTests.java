package com.example.coffeeUnitTests;

import com.example.coffee.Calculator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static com.example.coffee.CoffeeRecipe.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class CalculatorTests {
    Calculator calculator = new Calculator();

    @Test
    public void CalculateTheAmountOfRequiredWaterToMakeCoffee()
    {
        int requestedCups = 2;
        int expectedRequiredWater = 400;
        int actualRequiredWater = calculator.CalculateRequiredIngredient(mlOfWaterPerCup, requestedCups);

        assertEquals(expectedRequiredWater, actualRequiredWater);
    }

    @Test
    public void CalculateTheAmountOfRequiredMilkToMakeCoffee()
    {
        int requestedCups = 2;
        int expectedRequiredMilk = 100;
        int actualRequiredMilk = calculator.CalculateRequiredIngredient(mlOfMilkPerCup, requestedCups);

        assertEquals(expectedRequiredMilk, actualRequiredMilk);
    }

    @Test
    public void CalculateTheAmountOfRequiredCoffeeBeansToMakeCoffee()
    {
        int requestedCups = 2;
        int expectedRequiredCoffeeBeans = 30;
        int actualRequiredCoffeeBeans = calculator.CalculateRequiredIngredient(gramOfCoffeePerCup, requestedCups);

        assertEquals(expectedRequiredCoffeeBeans, actualRequiredCoffeeBeans);
    }

    @Test
    public void CalculateTheAmountOfAvailableCupsWithWater()
    {
        int availableWater = 400;
        int expectedCups = 2;
        int actualCups = calculator.CalculateAvailableCupPerIngrtedient(availableWater, mlOfWaterPerCup);

        assertEquals(expectedCups, actualCups);
    }

    @Test
    public void CalculateTheAmountOfAvailableCupsWithMilk()
    {
        int availableMilk = 150;
        int expectedCups = 3;
        int actualCups = calculator.CalculateAvailableCupPerIngrtedient(availableMilk, mlOfMilkPerCup);

        assertEquals(expectedCups, actualCups);
    }

    @Test
    public void CalculateTheAmountOfAvailableCupsWithCoffeeBeans()
    {
        int availableCoffeeBeans = 30;
        int expectedCups = 2;
        int actualCups = calculator.CalculateAvailableCupPerIngrtedient(availableCoffeeBeans, gramOfCoffeePerCup);

        assertEquals(expectedCups, actualCups);
    }

    @Test
    public void GetMinimumAvailableCupsOfCoffee()
    {
        int availableCupsWithWater = 10;
        int availableCupsWithMilk = 5;
        int availableCupsWithCoffeeBeans = 2;
        int expectedAvailableCups = 2;
        int actualAvailableCups = calculator.GetMinimumAvailableCups(availableCupsWithWater, availableCupsWithMilk, availableCupsWithCoffeeBeans);

        assertEquals(expectedAvailableCups, actualAvailableCups);
    }
}
