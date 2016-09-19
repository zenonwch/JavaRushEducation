package com.javarush.test.level27.lesson15.big01.ad;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticEventManager;
import com.javarush.test.level27.lesson15.big01.statistic.event.NoAvailableVideoEventDataRow;
import com.javarush.test.level27.lesson15.big01.statistic.event.VideoSelectedEventDataRow;

import java.util.*;

public class AdvertisementManager {
	private static final AdvertisementStorage storage = AdvertisementStorage.getInstance();
	private List<Advertisement> bestSet = new LinkedList<>();
	private long bestCost;
	private int timeOfBestSet;
	private int timeSeconds;

	public AdvertisementManager(int timeSeconds) {
		this.timeSeconds = timeSeconds;
	}

	private void findBestSet(List<Advertisement> available, List<Advertisement> taken, long cost, int time) {
		long newCost = cost;
		int newTime = time;

		if (!available.isEmpty()) {
			Advertisement currAd = available.get(0);

			available.remove(currAd);
			findBestSet(new LinkedList<>(available), new LinkedList<>(taken), cost, time);

			newTime = time + currAd.getDuration();

			if (newTime <= timeSeconds) {
				taken.add(currAd);
				newCost += currAd.getAmountPerOneDisplaying();
				findBestSet(new LinkedList<>(available), new LinkedList<>(taken), newCost, newTime);
			}
		}

		if (newCost > bestCost) {
			bestSet = taken;
			bestCost = newCost;
			timeOfBestSet = newTime;
		}
		if (newCost == bestCost) {
			if (newTime > timeOfBestSet) {
				bestSet = taken;
				timeOfBestSet = newTime;
			} else if (newTime == timeOfBestSet) {
				if (taken.size() < bestSet.size())
					bestSet = taken;
			}
		}
	}

	public void processVideos() {
		if (storage.list().isEmpty()) {
			StatisticEventManager.getInstance().register(new NoAvailableVideoEventDataRow(timeSeconds));
		}
		List<Advertisement> listWithHits = new LinkedList<>();
		for (Object o : storage.list()) {
			if (((Advertisement) o).getHits() > 0) listWithHits.add((Advertisement) o);
		}
		findBestSet(listWithHits, new LinkedList<Advertisement>(), 0, 0);
		if (bestSet.isEmpty()) {
			StatisticEventManager.getInstance().register(new NoAvailableVideoEventDataRow(timeSeconds));
		}
		StatisticEventManager.getInstance().register(new VideoSelectedEventDataRow(bestSet, bestCost, timeOfBestSet));
		Collections.sort(bestSet, new Comparator<Object>() {
			@Override
			public int compare(Object o1, Object o2) {
				Advertisement ad1 = (Advertisement) o1;
				Advertisement ad2 = (Advertisement) o2;
				long amount1 = ad1.getAmountPerOneDisplaying();
				long amount2 = ad2.getAmountPerOneDisplaying();
				float secCoast1 = (float) amount1 / ad1.getDuration();
				float secCoast2 = (float) amount2 / ad1.getDuration();
				if (amount1 == amount2) {
					return Float.compare(secCoast1, secCoast2);
				} else return Long.compare(amount2, amount1);
			}
		});
		for (Advertisement ad : bestSet) {
			ad.revalidate();
			ConsoleHelper.writeMessage(String.format("%s is displaying... %d, %d", ad.getName(), ad.getAmountPerOneDisplaying(), ad.getAmountPerOneDisplaying() * 1000 / ad.getDuration()));
		}
	}
}
