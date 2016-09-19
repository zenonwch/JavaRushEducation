package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticEventManager;
import com.javarush.test.level27.lesson15.big01.statistic.event.CookedOrderEventDataRow;

import java.util.concurrent.LinkedBlockingQueue;

public class Cook implements Runnable {
	private String name;
	private boolean busy;
	private LinkedBlockingQueue<Order> queue;
	private LinkedBlockingQueue<Order> readyOrders;

	public Cook(String name) {
		this.name = name;
	}

	public boolean isBusy() {
		return busy;
	}

	public void setQueue(LinkedBlockingQueue<Order> queue) {
		this.queue = queue;
	}

	public void setReadyOrders(LinkedBlockingQueue<Order> readyOrders) {
		this.readyOrders = readyOrders;
	}

	public void startCookingOrder(Order order) {
		busy = true;
		order.setCook(this);
		ConsoleHelper.writeMessage("Start cooking - " + order + ", cooking time " + order.getTotalCookingTime() + "min");
		StatisticEventManager.getInstance().register(new CookedOrderEventDataRow(order.getTablet().toString(), name, order.getTotalCookingTime() * 60, order.getDishes()));
		try {
			Thread.sleep(order.getTotalCookingTime() * 10);
			readyOrders.put(order);
			busy = false;
		}
		catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted())
			try {
				startCookingOrder(queue.take());
				Thread.sleep(10);
			}
			catch (InterruptedException e) {
				System.out.println(name + " end working");
				Thread.currentThread().interrupt();
			}
	}

	@Override
	public String toString() {
		return name;
	}
}
