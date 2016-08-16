package com.javarush.test.level24.lesson14.big01;

public class Ball extends BaseObject {
	private double speed;
	private double direction;
	private double dx;
	private double dy;
	private boolean isFrozen;

	public Ball(double x, double y, double speed, double direction) {
		super(x, y, 1);
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.direction = direction;
		this.isFrozen = true;
	}

	public double getSpeed() {
		return speed;
	}

	public double getDirection() {
		return direction;
	}

	public double getDx() {
		return dx;
	}

	public double getDy() {
		return dy;
	}

	public boolean isFrozen() {
		return isFrozen;
	}

	@Override
	public void draw(Canvas canvas) {
	}

	@Override
	public void move() {
	}
}
