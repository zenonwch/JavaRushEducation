package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;

import java.util.concurrent.LinkedBlockingQueue;

public class Waitor implements Runnable {
	private boolean busy;
	private LinkedBlockingQueue<Order> readyOrders;

	public boolean isBusy() {
		return busy;
	}

	public void setReadyOrders(LinkedBlockingQueue<Order> readyOrders) {
		this.readyOrders = readyOrders;
	}

	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			busy = true;
			try {
				Order order = readyOrders.take();
				if (order != null)
					ConsoleHelper.writeMessage(order + " was cooked by " + order.getCook());
				busy = false;
			}
			catch (InterruptedException e) {
				System.out.println("waiter end working");
				Thread.currentThread().interrupt();
			}
		}
	}
}
