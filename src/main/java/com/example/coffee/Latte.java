package com.example.coffee;

public class Latte implements ICoffeeRecipe {
    int water = 350;
    int milk = 75;
    int beans = 20;
    int cost = 7;

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
