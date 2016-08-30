package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Cook;

public class Restaurant {
	public static void main(String[] args) {
		Tablet tablet = new Tablet(5);
		Cook cook = new Cook("Amigo");
		tablet.addObserver(cook);
		tablet.createOrder();
	}
}
