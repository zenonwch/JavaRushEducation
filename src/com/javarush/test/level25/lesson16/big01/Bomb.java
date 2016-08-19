package com.javarush.test.level25.lesson16.big01;

public class Bomb extends BaseObject {
	public Bomb(double x, double y) {
		super(x, y, 1);
	}

	public void move() {
		y = y + 1;
	}

	public void draw(Canvas canvas) {
		canvas.setPoint(x, y, 'B');
	}
}
