package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.kitchen.Order;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticEventManager;


import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.LinkedBlockingQueue;

public class OrderManager implements Observer {
	LinkedBlockingQueue<Order> queue = new LinkedBlockingQueue<>();

	public OrderManager() {
		Thread daemon = new Thread(new Runnable() {
			@Override
			public void run() {
				while (!Thread.currentThread().isInterrupted())
					if (!queue.isEmpty())
						for (Cook cook : StatisticEventManager.getInstance().getCooks())
							if (!cook.isBusy())
								cook.startCookingOrder(queue.poll());
				try {
					Thread.sleep(10);
				}
				catch(InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			}
		});
		daemon.setDaemon(true);
		daemon.start();
	}

	public void update(Observable observable, Object object) {
		queue.offer((Order) object);
	}
}
