package com.javarush.test.level25.lesson16.big01;

public class BaseObject {
	private double x;
	private double y;
	private double radius;
	private boolean isAlive;

	public BaseObject(double x, double y, double radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
		this.isAlive = true;
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

	public boolean isAlive() {
		return isAlive;
	}

	public void draw() {}

	public void move() {}

	public void die() {
		isAlive = false;
	}

	public boolean isIntersec(BaseObject o) {
		return Math.sqrt((this.x - o.x) * (this.x - o.x) + (this.y - o.y) * (this.y - o.y)) < Math.max(this.radius, o.radius);
	}
}