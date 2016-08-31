package com.javarush.test.level27.lesson15.big01.ad;

public class AdvertisementStorage {
	private static final AdvertisementStorage INSTANCE = new AdvertisementStorage();

	private AdvertisementStorage() {}

	public static AdvertisementStorage getInstance() {
		return INSTANCE;
	}
}
