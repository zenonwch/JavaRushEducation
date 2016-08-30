package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.kitchen.Waitor;

public class Restaurant {
	public static void main(String[] args) {
		Tablet tablet = new Tablet(5);
		Cook cook = new Cook("Amigo");
		Waitor waitor = new Waitor();

		tablet.addObserver(cook);
		cook.addObserver(waitor);
		tablet.createOrder();
	}
}
