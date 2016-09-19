package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.kitchen.Order;
import com.javarush.test.level27.lesson15.big01.kitchen.Waitor;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.LinkedBlockingQueue;

public class Restaurant {
	private final static int ORDER_CREATING_INTERVAL = 100;
	private final static LinkedBlockingQueue<Order> QUEUE = new LinkedBlockingQueue<>();
	private final static LinkedBlockingQueue<Order> READY_QUEUE = new LinkedBlockingQueue<>();

	public static void main(String[] args) {
		Locale.setDefault(Locale.ENGLISH);

		Cook cookAmigo = new Cook("Amigo");
		Cook cookChief = new Cook("Chief");
		cookAmigo.setQueue(QUEUE);
		cookAmigo.setReadyOrders(READY_QUEUE);
		cookChief.setQueue(QUEUE);
		cookChief.setReadyOrders(READY_QUEUE);

		Waitor waitor = new Waitor();
		waitor.setReadyOrders(READY_QUEUE);

		List<Tablet> tablets = new ArrayList<>();
		for (int i = 1; i <= 5; i++) {
			Tablet tablet = new Tablet(i);
			tablet.setQueue(QUEUE);
			tablets.add(tablet);
		}

		Thread threadAmigo = new Thread(cookAmigo);
		Thread threadChief = new Thread(cookChief);
		threadAmigo.start();
		threadChief.start();

		Thread threadWaitor = new Thread(waitor);
		threadWaitor.start();

		Thread threadOrderGenerator = new Thread(new RandomOrderGeneratorTask(tablets, ORDER_CREATING_INTERVAL));
		threadOrderGenerator.start();
		try {
			Thread.sleep(1000);
		}
		catch (InterruptedException ignored) {
		}
		threadOrderGenerator.interrupt();

		while (true) {
			if (QUEUE.size() == 0 && READY_QUEUE.size() == 0)
				if (!cookAmigo.isBusy() && !cookChief.isBusy() && !waitor.isBusy()) {
					threadAmigo.interrupt();
					threadChief.interrupt();
					threadWaitor.interrupt();
					break;
				}
		}

		try {
			threadAmigo.join();
			threadChief.join();
			threadWaitor.join();
		}
		catch (InterruptedException e) {
			System.out.println("Trying to join threads");
		}

		DirectorTablet directorTablet = new DirectorTablet();
		directorTablet.printAdvertisementProfit();
		directorTablet.printCookWorkloading();
		directorTablet.printActiveVideoSet();
		directorTablet.printArchivedVideoSet();
		directorTablet.printNoAvailableVideo();
	}
}