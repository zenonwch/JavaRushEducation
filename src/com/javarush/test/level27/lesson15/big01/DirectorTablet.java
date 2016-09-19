package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.ad.Advertisement;
import com.javarush.test.level27.lesson15.big01.ad.StatisticAdvertisementManager;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticEventManager;

import java.util.List;
import java.util.Map;

public class DirectorTablet {
	public void printAdvertisementProfit() {
		long totalAmount = 0;
		for (Map.Entry<String, Long> pair : StatisticEventManager.getInstance().advertisementProfit().entrySet()) {
			ConsoleHelper.writeMessage(pair.getKey() + " - " + (float) pair.getValue() / 100);
			totalAmount += pair.getValue();
		}
		ConsoleHelper.writeMessage("Total - " + (float) totalAmount / 100);
	}

	public void printCookWorkloading() {
		for (Map.Entry<String, Map<String, Integer>> dayWorkload : StatisticEventManager.getInstance().cookWorkloading().entrySet()) {
			ConsoleHelper.writeMessage(dayWorkload.getKey());
			for (Map.Entry<String, Integer> cookWorkload : dayWorkload.getValue().entrySet()) {
				ConsoleHelper.writeMessage(cookWorkload.getKey() + " - " + (int) Math.ceil((float) cookWorkload.getValue() / 60) + " min");
			}
			ConsoleHelper.writeMessage("");
		}
	}

	public void printActiveVideoSet() {
		for (Advertisement ad : StatisticAdvertisementManager.getInstance().getActiveVideoSet()) {
			ConsoleHelper.writeMessage(ad.getName() + " - " + ad.getHits());
		}
	}

	public void printArchivedVideoSet() {
		for (Advertisement ad : StatisticAdvertisementManager.getInstance().getArchivedVideoSet()) {
			ConsoleHelper.writeMessage(ad.getName());
		}
	}

	public void printNoAvailableVideo() {
		for (Map.Entry<String, List<Integer>> noVideo : StatisticEventManager.getInstance().noAvailableVideo().entrySet()) {
			ConsoleHelper.writeMessage(noVideo.getKey());
			for (int time : noVideo.getValue())
				ConsoleHelper.writeMessage("" + time);
		}
	}
}