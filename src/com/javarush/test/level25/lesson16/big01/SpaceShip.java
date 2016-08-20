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
}
