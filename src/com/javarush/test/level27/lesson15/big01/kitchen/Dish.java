package com.javarush.test.level27.lesson15.big01.kitchen;

public enum Dish {
	Fish,
	Steak,
	Soup,
	Juice,
	Water;

	public static String allDishesToString() {
		String allDishes = "";
		for (Dish dish : Dish.values()) {
			if (allDishes.isEmpty()) allDishes += dish;
			else allDishes += ", " + dish;
		}
		return allDishes.trim();
	}
}
