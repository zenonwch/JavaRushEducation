package com.javarush.test.level27.lesson15.big01.ad;

import java.util.ArrayList;
import java.util.List;

class AdvertisementStorage {
	private static final AdvertisementStorage INSTANCE = new AdvertisementStorage();
	private final List<Object> videos = new ArrayList<>();

	private AdvertisementStorage() {
		add(new Advertisement(new Object(), "First Video", 5000, 100, 3 * 60));
		add(new Advertisement(new Object(), "second Video", 100, 10, 15 * 60));
		add(new Advertisement(new Object(), "Third Video", 400, 2, 10 * 60));
	}

	public static AdvertisementStorage getInstance() {
		return INSTANCE;
	}

	public List<Object> list() {
		return videos;
	}

	public void add(Advertisement advertisement) {
		videos.add(advertisement);
	}
}