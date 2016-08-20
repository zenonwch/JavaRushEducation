package com.javarush.test.level25.lesson16.big01;

public class SpaceShip extends BaseObject {
	private double dx = 0;

	public SpaceShip(int x, int y) {
		super(x, y, 3);
	}

	public void moveLeft() {
		dx = -1;
	}

	public void moveRight() {
		dx = 1;
	}

	public void move() {
		if (x + dx - 3 < 0 || x + dx + 3 > Space.game.getWidth()) return;
		x += dx;
	}

	public void draw() {
	}

	public void fire() {
		Rocket leftR = new Rocket(x - 3, y);
		Rocket rightR = new Rocket(x + 3, y);
		Space.game.getRockets().add(leftR);
		Space.game.getRockets().add(rightR);
	}
}
