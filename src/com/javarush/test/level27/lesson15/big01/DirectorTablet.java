package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.statistic.StatisticManager;

import java.util.Map;

public class DirectorTablet {
	public void printAdvertisementProfit() {
		long totalAmount = 0;
		for (Map.Entry<String, Long> pair : StatisticManager.getInstance().advertisementProfit().entrySet()) {
			ConsoleHelper.writeMessage(pair.getKey() + " - " + (float) pair.getValue() / 100);
			totalAmount += pair.getValue();
		}
		ConsoleHelper.writeMessage("Total - " + (float) totalAmount / 100);
		ConsoleHelper.writeMessage("");
	}

	public void printCookWorkloading() {
		for (Map.Entry<String, Map<String, Integer>> dayWorkload : StatisticManager.getInstance().cookWorkloading().entrySet()) {
			ConsoleHelper.writeMessage(dayWorkload.getKey());
			for (Map.Entry<String, Integer> cookWorkload : dayWorkload.getValue().entrySet()) {
				ConsoleHelper.writeMessage(cookWorkload.getKey() + " - " + (int) Math.ceil((float) cookWorkload.getValue() / 60) + " min");
			}
			ConsoleHelper.writeMessage("");
		}
	}

	public void printActiveVideoSet() {}
	public void printArchivedVideoSet() {}
}
