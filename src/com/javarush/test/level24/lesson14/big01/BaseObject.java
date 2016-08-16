package com.javarush.test.level24.lesson14.big01;

public abstract class BaseObject {
	private double x;
	private double y;
	private double radius;

	public BaseObject(double x, double y, double radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public abstract void draw();

	public abstract void move();

	public boolean isIntersec(BaseObject o) {
		return Math.sqrt((this.x  - o.x)*(this.x - o.x) + (this.y - o.y) * (this.y - o.y)) < Math.max(this.radius, o.radius);
	}
}
