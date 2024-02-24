package com.jey.builder;

public class MealBuilder {
	private Meal meal;

    public MealBuilder() {
        meal = new Meal();
    }

    public MealBuilder addCost(double cost) {
        meal.setCost(cost);
        return this;
    }

    public MealBuilder addTakeOut(boolean takeOut) {
        meal.setTakeOut(takeOut);
        return this;
    }

    public MealBuilder addMainCourse(String main) {
        meal.setMain(main);
        return this;
    }

    public MealBuilder addDrink(String drink) {
        meal.setDrink(drink);
        return this;
    }

    Meal build() {
        return meal;
    }

}
