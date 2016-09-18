package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.kitchen.Waitor;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticEventManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Restaurant {
	private final static int ORDER_CREATING_INTERVAL = 100;

	public static void main(String[] args) {
		Locale.setDefault(Locale.ENGLISH);
		Cook cookAmigo = new Cook("Amigo");
		Cook cookChief = new Cook("Chief");
		StatisticEventManager.getInstance().register(cookAmigo);
		StatisticEventManager.getInstance().register(cookChief);

		Waitor waitor = new Waitor();
		cookAmigo.addObserver(waitor);
		cookChief.addObserver(waitor);

		List<Tablet> tablets = new ArrayList<>();
		for (int i = 1; i <= 5; i++) {
			Tablet tablet = new Tablet(i);
			tablet.addObserver(cookAmigo);
			tablet.addObserver(cookChief);
			tablets.add(tablet);
		}

		Thread thread = new Thread(new RandomOrderGeneratorTask(tablets, ORDER_CREATING_INTERVAL));
		thread.start();
		try {
			Thread.sleep(1000);
		}
		catch (InterruptedException e) {
		}
		thread.interrupt();

		DirectorTablet directorTablet = new DirectorTablet();
		directorTablet.printAdvertisementProfit();
		directorTablet.printCookWorkloading();
		directorTablet.printActiveVideoSet();
		directorTablet.printArchivedVideoSet();
	}
}