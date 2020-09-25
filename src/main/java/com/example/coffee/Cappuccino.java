package com.example.coffee;

public class Cappuccino implements ICoffeeRecipe {
    int water = 200;
    int milk = 100;
    int beans = 12;
    int cost = 6;

    public int getWater() { return water; }
    public void setWater(int water){
        this.water = water;
    };

    public int getMilk() { return milk; };
    public void setMilk(int milk) { this.milk = milk;};

    public int getBeans() { return beans; };
    public void setBeans(int beans) { this.beans = beans; };

    public int getCost() { return cost; };
    public void setCost(int cost) { this.cost = cost; };
}
