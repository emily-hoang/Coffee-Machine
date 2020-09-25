package com.example.coffee;

abstract class Espresso implements ICoffeeRecipe {
    int water = 250;
    int milk = 0;
    int beans = 16;
    int cost = 4;

    public int getWater() { return water; }
    public void setWater(int water){
        this.water = water;
    }

    public int getMilk() { return milk; };
    public void setMilk(int milk) { this.milk = milk;}

    public int getBeans() { return beans; };
    public void setBeans(int beans) { this.beans = beans; }

    public int getCost() { return cost; };
    public void setCost(int cost) { this.cost = cost; }
}
