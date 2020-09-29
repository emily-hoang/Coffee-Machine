//package com.example.coffeeUnitTests;
//
//import com.example.coffee.Calculator;
//import com.example.coffee.Espresso;
//import com.example.coffee.ICoffeeRecipe;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.CsvSource;
//import org.junit.jupiter.params.provider.ValueSource;
//import org.springframework.test.context.ContextConfiguration;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//
//@ContextConfiguration
//public class CalculatorTests {
//    Calculator calculator = new Calculator();
//
//    @ParameterizedTest
//    @ValueSource(ints = {2})
//    public void CalculateRequiredWaterAmountToMakeCoffee(int requestedCups)
//    {
//        int expectedRequiredWater = 400;
//        int actualRequiredWater = calculator.calculateRequiredWater(requestedCups);
//
//        assertEquals(expectedRequiredWater, actualRequiredWater);
//    }
//
//    @ParameterizedTest
//    @ValueSource(ints = {2})
//    public void CalculateRequiredMilkAmountToMakeCoffee(int requestedCups)
//    {
//        int expectedRequiredMilk = 100;
//        int actualRequiredMilk = calculator.calculateRequiredMilk(requestedCups);
//
//        assertEquals(expectedRequiredMilk, actualRequiredMilk);
//    }
//
//    @ParameterizedTest
//    @ValueSource(ints = {1})
//    public void CalculateRequiredBeansAmountToMakeCoffee(int requestedCups)
//    {
//        Espresso espresso = new Espresso();
//        int expectedRequiredCoffeeBeans = 30;
//        int actualRequiredCoffeeBeans = calculator.calculateRequiredBeans(espresso, requestedCups);
//
//        assertEquals(expectedRequiredCoffeeBeans, actualRequiredCoffeeBeans);
//    }
//
//    @ParameterizedTest
//    @ValueSource(ints = {400})
//    public void CalculateAvailableCupsWithWater(int availableWater)
//    {
//        int expectedCups = 2;
//        int actualCups = calculator.calculateAvailableCupsWithWater(availableWater);
//
//        assertEquals(expectedCups, actualCups);
//    }
//
//    @ParameterizedTest
//    @ValueSource(ints = {150})
//    public void CalculateAvailableCupsWithMilk(int availableMilk)
//    {
//        int expectedCups = 3;
//        int actualCups = calculator.calculateAvailableCupsWithMilk(availableMilk);
//
//        assertEquals(expectedCups, actualCups);
//    }
//
//    @ParameterizedTest
//    @ValueSource(ints = {30})
//    public void CalculateAvailableCupsWithBeans(int availableCoffeeBeans)
//    {
//        int expectedCups = 2;
//        int actualCups = calculator.calculateAvailableCupsWithBeans(availableCoffeeBeans);
//
//        assertEquals(expectedCups, actualCups);
//    }
//
//    @ParameterizedTest
//    @CsvSource({ "300, 200, 30" })
//    public void GetMinimumAvailableCupsOfCoffee(int availableCupsWithWater, int availableCupsWithMilk, int availableCupsWithCoffeeBeans)
//    {
//        int expectedAvailableCups = 30;
//        int actualAvailableCups = calculator.GetMinimumAvailableCups(availableCupsWithWater, availableCupsWithMilk, availableCupsWithCoffeeBeans);
//
//        assertEquals(expectedAvailableCups, actualAvailableCups);
//    }
//}
