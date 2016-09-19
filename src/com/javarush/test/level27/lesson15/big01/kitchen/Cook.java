package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticEventManager;
import com.javarush.test.level27.lesson15.big01.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;
import java.util.concurrent.LinkedBlockingQueue;

public class Cook extends Observable implements Runnable {
	private String name;
	private LinkedBlockingQueue<Order> queue;

	public Cook(String name) {
		this.name = name;
	}

	public void setQueue(LinkedBlockingQueue<Order> queue) {
		this.queue = queue;
	}

	public void startCookingOrder(Order order) {
		ConsoleHelper.writeMessage("Start cooking - " + order + ", cooking time " + order.getTotalCookingTime() + "min");
		StatisticEventManager.getInstance().register(new CookedOrderEventDataRow(order.getTablet().toString(), name, order.getTotalCookingTime() * 60, order.getDishes()));
		try {
			Thread.sleep(order.getTotalCookingTime() * 10);
		}
		catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		setChanged();
		notifyObservers(order);
	}

	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted())
			try {
				startCookingOrder(queue.take());
				Thread.sleep(10);
			}
			catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
	}

	@Override
	public String toString() {
		return name;
	}
}
