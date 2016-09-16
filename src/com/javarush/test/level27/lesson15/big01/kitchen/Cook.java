package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticEventManager;
import com.javarush.test.level27.lesson15.big01.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;
import java.util.Observer;

public class Cook extends Observable implements Observer {
	private String name;

	public Cook(String name) {
		this.name = name;
	}

	@Override
	public void update(Observable observable, Object arg) {
		ConsoleHelper.writeMessage("Start cooking - " + arg + ", cooking time " + ((Order) arg).getTotalCookingTime() + "min");
		StatisticEventManager.getInstance().register(new CookedOrderEventDataRow(((Order) arg).getTablet().toString(), name, ((Order) arg).getTotalCookingTime() * 60, ((Order) arg).getDishes()));
		setChanged();
		notifyObservers(arg);
	}

	@Override
	public String toString() {
		return name;
	}
}
