package com.javarush.test.level27.lesson15.big01.statistic;

import com.javarush.test.level27.lesson15.big01.statistic.event.EventDataRow;

public class StatisticManager {
	private static final StatisticManager INSTANCE = new StatisticManager();

	private StatisticManager() {}

	public static StatisticManager getInstance() {
		return INSTANCE;
	}

	public void register(EventDataRow data) {
		//TODO
	}
}
