package com.javarush.test.level27.lesson15.big01.ad;

import java.util.Collections;
import java.util.Comparator;

public class AdvertisementManager {
	private static final AdvertisementStorage storage = AdvertisementStorage.getInstance();
	private int timeSeconds;

	public AdvertisementManager(int timeSeconds) {
		this.timeSeconds = timeSeconds;
	}

	public void processVideos() {
		if (storage.list().isEmpty()) throw new NoVideoAvailableException();
		Collections.sort(storage.list(), new Comparator<Object>() {
			@Override
			public int compare(Object o1, Object o2) {
				int res = 0;
				Advertisement ad1 = (Advertisement) o1;
				Advertisement ad2 = (Advertisement) o2;
				long amount1 = ad1.getAmountPerOneDisplaying();
				long amount2 = ad2.getAmountPerOneDisplaying();
				float secCoast1 = amount1 / ad1.getDuration();
				float secCoast2 = amount2 / ad1.getDuration();
				if (amount1 > amount2)
					res = 1;
				else if (amount2 > amount1)
					res = -1;
				else {
					if (secCoast1 < secCoast2)
						res = 1;
					if (secCoast2 < secCoast1)
						res = -1;
				}
				return res;
			}
		});
	}
}
