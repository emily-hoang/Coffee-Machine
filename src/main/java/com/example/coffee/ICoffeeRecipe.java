package com.example.coffee;

public interface ICoffeeRecipe {
     int water = 0;
     int milk = 0;
     int beans = 0;
     int cost = 0;

     int getWater();
     void setWater(int water);

     int getMilk();
     void setMilk(int milk);

     int getBeans();
     void setBeans(int beans);

     int getCost();
     void setCost(int cost);
}
