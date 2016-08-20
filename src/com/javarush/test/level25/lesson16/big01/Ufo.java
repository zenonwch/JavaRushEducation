package com.javarush.test.level25.lesson16.big01;

public class Ufo extends BaseObject {
	private int moveCount = 0;

	public Ufo(double x, double y) {
		super(x, y, 3);
	}

	public void draw() {}

	public void move() {
		double dx = Math.random() * 2 - 1;
		double dy = Math.random() * 2 - 1;
		x += dx;
		if (y + dy <= Space.game.getHeight() / 2) return;
		y += dy;
		moveCount++;
		if (moveCount % 10 == 0) fire();
	}

	public void fire() {
		Space.game.getBombs().add(new Bomb(x, y));
	}
}
