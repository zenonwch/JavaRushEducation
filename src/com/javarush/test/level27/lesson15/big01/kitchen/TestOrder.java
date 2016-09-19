package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.Tablet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class TestOrder extends Order {

	public TestOrder(Tablet tablet) throws IOException {
		super(tablet);
	}

	@Override
	protected void initDishes() {
		List<Dish> availableDishes = Arrays.asList(Dish.values());
		Collections.shuffle(availableDishes);
		int numOfSelectedDishes = ThreadLocalRandom.current().nextInt(availableDishes.size()) + 1;
		dishes = new ArrayList<>();
		for (int i = 0; i < numOfSelectedDishes; i++)
			dishes.add(availableDishes.get(i));
	}
}
