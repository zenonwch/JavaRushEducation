package com.javarush.test.level27.lesson15.big01.ad;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;

import java.util.*;

public class AdvertisementManager {
	private static final AdvertisementStorage storage = AdvertisementStorage.getInstance();
	private List<Object> bestSet = new LinkedList<>();
	private long bestCost;
	private int timeOfBestSet;
	private int timeSeconds;

	public AdvertisementManager(int timeSeconds) {
		this.timeSeconds = timeSeconds;
	}

	private void findBestSet(List<Object> available, List<Object> taken, long cost, int time) {
		long newCost = cost;
		int newTime = time;

		if (!available.isEmpty()) {
			Advertisement currAd = (Advertisement) available.get(0);

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
		if (storage.list().isEmpty()) throw new NoVideoAvailableException();
		List<Object> listWithHits = new LinkedList<>();
		for (Object o : storage.list()) {
			if (((Advertisement) o).getHits() > 0) listWithHits.add(o);
		}
		findBestSet(listWithHits, new LinkedList<>(), 0, 0);
		if (bestSet.isEmpty()) throw new NoVideoAvailableException();
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
		for (Object o : bestSet) {
			Advertisement ad = (Advertisement) o;
			ad.revalidate();
			ConsoleHelper.writeMessage(String.format("%s is displaying... %d, %d", ad.getName(), ad.getAmountPerOneDisplaying(), ad.getAmountPerOneDisplaying() * 1000 / ad.getDuration()));
		}
	}
}
