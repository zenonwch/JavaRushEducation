package com.javarush.test.level27.lesson15.big01;

import java.util.List;

public class RandomOrderGeneratorTask implements Runnable {
	private List<Tablet> tablets;
	private int interval;

	public RandomOrderGeneratorTask(List<Tablet> tablets, int interval) {
		this.tablets = tablets;
		this.interval = interval;
	}

	@Override
	public void run() {
		Tablet tablet = tablets.get((int) (Math.random() * tablets.size()));
		try {
			while(!Thread.currentThread().isInterrupted()) {
				tablet.createTestOrder();
				Thread.sleep(interval);
			}
		}
		catch (InterruptedException e) {}
	}
}
