package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.Tablet;

import java.io.IOException;
import java.util.List;

public class Order {
	private static List<Dish> dishes;
	private Tablet tablet;

	public Order(Tablet tablet) throws IOException {
		dishes = ConsoleHelper.getAllDishesForOrder();
		this.tablet = tablet;
	}

	public boolean isEmpty() {
		return dishes == null || dishes.isEmpty();
	}

	public int getTotalCookingTime() {
		int totalTime = 0;
		for (Dish dish : dishes)
			totalTime += dish.getDuration();
		return totalTime;
	}

	@Override
	public String toString() {
		String res = "";
		if (!dishes.isEmpty())
			res = "Your order: " + dishes + " of " + tablet.toString();
		return res;
	}
}
