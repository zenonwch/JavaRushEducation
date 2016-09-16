package com.javarush.test.level27.lesson15.big01.statistic;

import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.statistic.event.CookedOrderEventDataRow;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventDataRow;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventType;
import com.javarush.test.level27.lesson15.big01.statistic.event.VideoSelectedEventDataRow;

import java.text.SimpleDateFormat;
import java.util.*;

public class StatisticEventManager {
	private static final StatisticEventManager INSTANCE = new StatisticEventManager();
	private StatisticStorage statisticStorage = new StatisticStorage();
	private Set<Cook> cooks = new HashSet<>();
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");

	private StatisticEventManager() {
	}

	public static StatisticEventManager getInstance() {
		return INSTANCE;
	}

	public void register(EventDataRow data) {
		statisticStorage.put(data);
	}

	public void register(Cook cook) {
		cooks.add(cook);
	}

	public Map<String, Long> advertisementProfit() {
		NavigableMap<String, Long> profitPerDay = new TreeMap<>();

		for (EventDataRow event : statisticStorage.getEventTypeMap().get(EventType.SELECTED_VIDEOS)) {
			VideoSelectedEventDataRow eventVideoSelected = (VideoSelectedEventDataRow) event;
			String eventDate = dateFormat.format(eventVideoSelected.getDate());

			if (profitPerDay.get(eventDate) == null)
				profitPerDay.put(eventDate, eventVideoSelected.getAmount());
			else
				profitPerDay.put(eventDate, profitPerDay.get(eventDate) + eventVideoSelected.getAmount());
		}
		return profitPerDay.descendingMap();
	}

	public Map<String, Map<String, Integer>> cookWorkloading() {
		NavigableMap<String, Map<String, Integer>> workloadPerDay = new TreeMap<>();

		for (EventDataRow event : statisticStorage.getEventTypeMap().get(EventType.COOKED_ORDER)) {
			CookedOrderEventDataRow cookedOrderEvent = ((CookedOrderEventDataRow) event);
			String eventDate = dateFormat.format(cookedOrderEvent.getDate());
			String cookName = cookedOrderEvent.getCookName();
			int cookTime = cookedOrderEvent.getTime();

			if (workloadPerDay.get(eventDate) == null)
				workloadPerDay.put(eventDate, new TreeMap<String, Integer>());

			if (workloadPerDay.get(eventDate).get(cookName) == null)
				workloadPerDay.get(eventDate).put(cookName, cookTime);
			else
				workloadPerDay.get(eventDate).put(cookName, workloadPerDay.get(eventDate).get(cookName) + cookTime);
		}
		return workloadPerDay.descendingMap();
	}

	private static class StatisticStorage {
		private Map<EventType, List<EventDataRow>> eventTypeMap = new HashMap<>();

		private StatisticStorage() {
			for (EventType e : EventType.values()) {
				eventTypeMap.put(e, new ArrayList<EventDataRow>());
			}
		}

		private Map<EventType, List<EventDataRow>> getEventTypeMap() {
			return eventTypeMap;
		}

		private void put(EventDataRow data) {
			eventTypeMap.get(data.getType()).add(data);
		}
	}
}
