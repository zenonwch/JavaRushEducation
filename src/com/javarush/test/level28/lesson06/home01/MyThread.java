package com.javarush.test.level28.lesson06.home01;

import java.util.concurrent.atomic.AtomicInteger;

public class MyThread extends Thread {
	private static AtomicInteger threadPriority = new AtomicInteger(1);

	public MyThread() {
		setThreadPriority();
	}

	public MyThread(Runnable target) {
		super(target);
		setThreadPriority();
	}

	public MyThread(ThreadGroup group, Runnable target) {
		super(group, target);
		setThreadPriority(group);
	}

	public MyThread(String name) {
		super(name);
		setThreadPriority();
	}

	public MyThread(ThreadGroup group, String name) {
		super(group, name);
		setThreadPriority(group);
	}

	public MyThread(Runnable target, String name) {
		super(target, name);
		setThreadPriority();
	}

	public MyThread(ThreadGroup group, Runnable target, String name) {
		super(group, target, name);
		setThreadPriority(group);
	}

	public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
		super(group, target, name, stackSize);
		setThreadPriority(group);
	}

	private void setThreadPriority() {
		int p = threadPriority.getAndIncrement();
		if (p <= 10) this.setPriority(p);
		else {
			threadPriority.set(1);
			this.setPriority(threadPriority.getAndIncrement());
		}
	}

	private void setThreadPriority(ThreadGroup group) {
		int p = threadPriority.getAndIncrement();
		if (p <= 10 && p < group.getMaxPriority())	this.setPriority(p);
		else if (p > 10) {
			threadPriority.set(1);
			this.setPriority(threadPriority.getAndIncrement());
		}
		else this.setPriority(group.getMaxPriority());
	}
}
