package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Order;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet {
	private static final Logger logger = Logger.getLogger(Tablet.class.getName());
	private final int number;

	public Tablet(int number) {
		this.number = number;
	}

	public void createOrder() {
		try {
			Order order = new Order(this);
			ConsoleHelper.writeMessage(String.format(order.toString(), number));
		}
		catch (IOException e) {
			logger.log(Level.SEVERE, "Console is unavailable.");
		}
	}

	public String toString() {
		return "Tablet{number=" + number + "}";
	}
}
