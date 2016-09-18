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
		while (!Thread.currentThread().isInterrupted()) {
			Tablet tablet = tablets.get((int) (Math.random() * tablets.size()));
			tablet.createTestOrder();
			try {
				Thread.sleep(interval);
			}
			catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
	}
}
