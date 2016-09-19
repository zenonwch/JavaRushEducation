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

	public static void main(String[] args) {
		Locale.setDefault(Locale.ENGLISH);

		Cook cookAmigo = new Cook("Amigo");
		Cook cookChief = new Cook("Chief");
		cookAmigo.setQueue(QUEUE);
		cookChief.setQueue(QUEUE);

		Waitor waitor = new Waitor();
		cookAmigo.addObserver(waitor);
		cookChief.addObserver(waitor);

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


		Thread thread = new Thread(new RandomOrderGeneratorTask(tablets, ORDER_CREATING_INTERVAL));
		thread.start();
		try {
			Thread.sleep(1000);
		}
		catch (InterruptedException e) {
		}
		thread.interrupt();
		threadAmigo.interrupt();
		threadChief.interrupt();

		try {
			threadAmigo.join();
			threadChief.join();
		}
		catch (InterruptedException e) {}

		DirectorTablet directorTablet = new DirectorTablet();
		directorTablet.printAdvertisementProfit();
		directorTablet.printCookWorkloading();
		directorTablet.printActiveVideoSet();
		directorTablet.printArchivedVideoSet();
	}
}