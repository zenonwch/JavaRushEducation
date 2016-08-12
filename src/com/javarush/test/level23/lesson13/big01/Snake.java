package com.javarush.test.level23.lesson13.big01;

import java.util.ArrayList;

public class Snake {
	private ArrayList<SnakeSection> sections;
	private boolean isAlive;
	private SnakeDirection direction;

	public Snake (int x, int y) {
		sections = new ArrayList<>();
		sections.add(new SnakeSection(x, y));
		isAlive = true;
	}

	public ArrayList<SnakeSection> getSections() {
		return sections;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public SnakeDirection getDirection() {
		return direction;
	}

	public void setDirection(SnakeDirection direction) {
		this.direction = direction;
	}

	public int getX() {
		return sections.get(0).getX();
	}

	public int getY() {
		return sections.get(0).getY();
	}

	public void move() {}
}