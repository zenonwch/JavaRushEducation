package com.javarush.test.level25.lesson07.home01;

public class TaskManipulator implements Runnable, CustomThreadManipulator {
	private Thread t;

	@Override
	public void start(String threadName) {
		t = new Thread(this);
		t.setName(threadName);
		t.start();
	}

	@Override
	public void stop() {
		if (!t.isInterrupted()) t.interrupt();
	}

	@Override
	public void run() {
		try {
			while (!t.isInterrupted()) {
				Thread.sleep(0, 500000);
				if (t.getState() == Thread.State.RUNNABLE) {
					System.out.println(t.getName());
				}
				Thread.sleep(90);
			}
		}
		catch (Exception e) {
		}
	}
}
