package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.ad.AdvertisementManager;
import com.javarush.test.level27.lesson15.big01.ad.NoVideoAvailableException;
import com.javarush.test.level27.lesson15.big01.kitchen.Order;

import java.io.IOException;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet extends Observable {
	private static final Logger logger = Logger.getLogger(Tablet.class.getName());
	private final int number;

	public Tablet(int number) {
		this.number = number;
	}

	public void createOrder() {
		Order order = null;
		try {
			order = new Order(this);
			if (!order.isEmpty()) {
				ConsoleHelper.writeMessage(order.toString());
				setChanged();
				notifyObservers(order);
				new AdvertisementManager(order.getTotalCookingTime() * 60).processVideos();
			}
		}
		catch (IOException e) {
			logger.log(Level.SEVERE, "Console is unavailable.");
		}
		catch(NoVideoAvailableException e) {
			logger.log(Level.INFO, "No video is available for the order " + order);
		}
	}

	@Override
	public String toString() {
		return "Tablet{" +
				"number=" + number +
				'}';
	}
}
