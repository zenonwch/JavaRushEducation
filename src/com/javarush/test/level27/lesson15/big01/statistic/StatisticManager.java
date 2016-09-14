package com.javarush.test.level27.lesson15.big01.statistic;

import com.javarush.test.level27.lesson15.big01.statistic.event.EventDataRow;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatisticManager {
	private static final StatisticManager INSTANCE = new StatisticManager();
	private StatisticStorage storage = new StatisticStorage();

	private StatisticManager() {}

	public static StatisticManager getInstance() {
		return INSTANCE;
	}

	public void register(EventDataRow data) {
		//TODO
	}

	private class StatisticStorage {
		Map<EventType, List<EventDataRow>> map = new HashMap<>();

		private StatisticStorage() {
			for (EventType e: EventType.values()) {
				map.put(e, new ArrayList<EventDataRow>());
			}
		}
	}
}
