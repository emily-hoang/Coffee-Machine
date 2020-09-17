package com.example.coffeeUnitTests;

import com.example.coffee.Order;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class OrderTests {
    Order order = new Order();

    @Test
    public void GetNumberOfCupsRequestedFromUser()
    {
        int inputNumberOfCups = 4;
        String inputData = String.valueOf(inputNumberOfCups);
        InputStream in = new ByteArrayInputStream(inputData.getBytes());
        System.setIn(in);

        assertEquals(inputNumberOfCups, order.TakeOrder());
    }
}
