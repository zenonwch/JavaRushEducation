package com.javarush.test.level17.lesson10.home02;

/* Comparable
Реализуйте интерфейс Comparable<Beach> в классе Beach, который будет использоваться нитями.
*/

public class Beach implements Comparable<Beach> {
	private volatile String name;      //название
	private volatile float distance;   //расстояние
	private volatile int quality;    //качество

	public Beach(String name, float distance, int quality) {
		this.name = name;
		this.distance = distance;
		this.quality = quality;
	}

	@Override
	public synchronized int compareTo(Beach beach) {
		return (int) (quality - beach.getQuality() +  beach.getDistance() - distance);
	}

	public String getName() {
		return name;
	}

	public synchronized void setName(String name) {
		this.name = name;
	}

	public float getDistance() {
		return distance;
	}

	public synchronized void setDistance(float distance) {
		this.distance = distance;
	}

	public int getQuality() {
		return quality;
	}

	public synchronized void setQuality(int quality) {
		this.quality = quality;
	}
}
