package com.javarush.test.level25.lesson05.home01;

public class LoggingStateThread extends Thread {
	private Thread target;
	private Thread.State lastState;

	public LoggingStateThread(Thread target) {
		super();
		this.target = target;
		setDaemon(true);
		lastState = target.getState();
		System.out.println(lastState);
	}

	@Override
	public void run() {
		while (!target.isInterrupted()) {
			Thread.State currState = target.getState();
			if (currState != lastState) {
				System.out.println(currState);
				lastState = currState;
			}
		}
	}
}
