package com.example.coffee;

public class CoffeeRecipe implements ICoffeeRecipe {
    int water;
    int milk;
    int beans;
    int cost;

    public CoffeeRecipe(int water, int milk, int beans, int cost) {
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.cost = cost;
    }

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
