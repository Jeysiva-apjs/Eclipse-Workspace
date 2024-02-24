package com.jey.builder;

public class Main {

	public static void main(String[] args) {
		MealBuilder builder = new MealBuilder();
		Meal myMeal = builder.addCost(15.99)
		                     .addTakeOut(true)
		                     .addMainCourse("Burger")
		                     .addDrink("Coke")
		                     .build();

		myMeal.getCost();       // Cost: 15.99
		myMeal.getTakeOut();    // TakeOut: true
		myMeal.getMain();       // Main: "Burger"
		myMeal.getDrink();      // Drink: "Coke"


	}

}
