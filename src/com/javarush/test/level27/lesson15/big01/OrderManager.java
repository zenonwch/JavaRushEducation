package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Order;


import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.LinkedBlockingQueue;

public class OrderManager implements Observer {
	LinkedBlockingQueue<Order> queue;

	public void update(Observable observable, Object object) {
		queue.add((Order) object);
	}
}
