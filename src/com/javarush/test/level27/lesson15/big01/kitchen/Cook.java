package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticEventManager;
import com.javarush.test.level27.lesson15.big01.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;

public class Cook extends Observable {
	private String name;
	private boolean busy;

	public Cook(String name) {
		this.name = name;
	}

	public boolean isBusy() {
		return busy;
	}

	public void startCookingOrder(Order order) {
		busy = true;
		ConsoleHelper.writeMessage("Start cooking - " + order + ", cooking time " + order.getTotalCookingTime() + "min");
		StatisticEventManager.getInstance().register(new CookedOrderEventDataRow(order.getTablet().toString(), name, order.getTotalCookingTime() * 60, order.getDishes()));
		try {
			Thread.sleep(order.getTotalCookingTime() * 10);
		}
		catch (InterruptedException e) {}
		setChanged();
		notifyObservers(order);
		busy = false;
	}

	@Override
	public String toString() {
		return name;
	}
}
