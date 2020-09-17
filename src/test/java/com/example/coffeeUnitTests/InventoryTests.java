package com.example.coffeeUnitTests;

import com.example.coffee.Inventory;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class InventoryTests {
    Inventory inventory = new Inventory();

    @Test
    public void GetMillilitreOfWaterFromUser()
    {
        int inputMillilitreOfWater = 200;
        String inputData = String.valueOf(inputMillilitreOfWater);
        InputStream in = new ByteArrayInputStream(inputData.getBytes());
        System.setIn(in);

        assertEquals(inputMillilitreOfWater, inventory.GetMillilitreOfWater());
    }

    @Test
    public void GetMillilitreOfMilkFromUser()
    {
        int inputMillilitreOfMilk = 100;
        String inputData = String.valueOf(inputMillilitreOfMilk);
        InputStream in = new ByteArrayInputStream(inputData.getBytes());
        System.setIn(in);

        assertEquals(inputMillilitreOfMilk, inventory.GetMillilitreOfMilk());
    }

    @Test
    public void GetGramOfCoffeeBeansFromUser()
    {
        int inputMillilitreOfMilk = 100;
        String inputData = String.valueOf(inputMillilitreOfMilk);
        InputStream in = new ByteArrayInputStream(inputData.getBytes());
        System.setIn(in);

        assertEquals(inputMillilitreOfMilk, inventory.GetGramOfCoffeeBeans());
    }
}
