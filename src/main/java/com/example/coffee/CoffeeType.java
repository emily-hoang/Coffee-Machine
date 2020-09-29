package com.example.coffee;

import java.util.HashMap;
import java.util.Map;

public enum CoffeeType {
        ESPRESSO(1), LATTE(2), CAPPUCCINO(3),;

        public final int number;

        CoffeeType(int number) {
                this.number = number;
                Mapper.lookup.put(this.number, this);
        }

        public static CoffeeType getCoffeeType(int number) {
                return Mapper.lookup.get(number);
        }
}

final class Mapper {
        public static final Map<Integer, CoffeeType> lookup = new HashMap<>();
}
