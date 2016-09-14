package com.javarush.test.level27.lesson15.big01.statistic;

import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventDataRow;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventType;

import java.util.*;

public class StatisticManager {
	private static final StatisticManager INSTANCE = new StatisticManager();
	private StatisticStorage statisticStorage = new StatisticStorage();
	private Set<Cook> cooks = new HashSet<>();

	private StatisticManager() {}

	public static StatisticManager getInstance() {
		return INSTANCE;
	}

	public void register(EventDataRow data) {
		statisticStorage.put(data);
	}

	public void register(Cook cook) {
		cooks.add(cook);
	}

	private static class StatisticStorage {
		Map<EventType, List<EventDataRow>> eventTypeMap = new HashMap<>();

		private StatisticStorage() {
			for (EventType e: EventType.values()) {
				eventTypeMap.put(e, new ArrayList<EventDataRow>());
			}
		}

		private void put(EventDataRow data){
			eventTypeMap.get(data.getType()).add(data);
		}
	}
}
