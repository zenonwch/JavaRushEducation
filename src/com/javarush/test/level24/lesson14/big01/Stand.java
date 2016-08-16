package com.javarush.test.level24.lesson14.big01;

public class Stand extends BaseObject {
	private double speed;
	private double direction;

	public Stand(double x, double y) {
		super(x, y, 3);
		this.speed = 1;
		this.direction = 0;
	}

	public double getSpeed() {
		return speed;
	}

	public double getDirection() {
		return direction;
	}

	@Override
	public void draw(Canvas canvas) {
	}

	@Override
	public void move() {
		x += speed * direction;
	}

	public void moveLeft() {
		direction = -1;
	}

	public void moveRight() {
		direction = 1;
	}
}
