package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Order;

public class Tablet {
	final int number;

	public Tablet(int number) {
		this.number = number;
	}

	public void createOrder() {
		Order order = new Order();
		System.out.println(order);
	}
}
