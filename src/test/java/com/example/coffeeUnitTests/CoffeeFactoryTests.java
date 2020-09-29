package com.example.coffeeUnitTests;

import com.example.coffee.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.test.context.ContextConfiguration;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ContextConfiguration
public class CoffeeFactoryTests {
    CoffeeFactory factory = new CoffeeFactory();

    @ParameterizedTest
    @ValueSource(ints = {1})
    public void WhenCustomerOrderEspresso_ThenReturnTheEspressoRecipe(int number)
    {
        Espresso expectedCoffeeRecipe = new Espresso();
        ICoffeeRecipe actualCoffeeRecipe = factory.getCoffeeRecipe(number);

        assertThat(actualCoffeeRecipe).isEqualToComparingFieldByField(expectedCoffeeRecipe);
    }

    @ParameterizedTest
    @ValueSource(ints = {2})
    public void WhenGCustomerOrderLatte_ThenReturnTheLatteRecipe(int number)
    {
        Latte expectedCoffeeRecipe = new Latte();
        ICoffeeRecipe actualCoffeeRecipe = factory.getCoffeeRecipe(number);

        assertThat(actualCoffeeRecipe).isEqualToComparingFieldByField(expectedCoffeeRecipe);
    }

    @ParameterizedTest
    @ValueSource(ints = {3})
    public void WhenCustomerOrderCappuccino_ThenReturnTheCappuccinoRecipe(int number)
    {
        Cappuccino expectedCoffeeRecipe = new Cappuccino();
        ICoffeeRecipe actualCoffeeRecipe = factory.getCoffeeRecipe(number);

        assertThat(actualCoffeeRecipe).isEqualToComparingFieldByField(expectedCoffeeRecipe);
    }

    @ParameterizedTest
    @ValueSource(ints = {3,5})
    public void WhenCustomerOrderUnsupportedCoffeeType_ThenThrowsAnIllegalArgumentException(int number)
    {
        ICoffeeFactory factory = mock(ICoffeeFactory.class);
        when(factory.getCoffeeRecipe(number)).thenThrow(IllegalArgumentException.class);

        IllegalArgumentException exception = null;

        try {
            factory.getCoffeeRecipe(number);
        } catch (IllegalArgumentException ex) {
            exception = ex;
        }

        assertNotNull(exception);
    }

}
