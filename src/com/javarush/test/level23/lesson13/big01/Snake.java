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

	public void move() {
		ArrayList<SnakeSection> oldSections = new ArrayList<>(sections);

		switch (getDirection()) {
			case UP:
				sections.add(0, new SnakeSection(getX(), getY() - 1));
				break;
			case RIGHT:
				sections.add(0, new SnakeSection(getX() + 1, getY()));
				break;
			case DOWN:
				sections.add(0, new SnakeSection(getX(), getY() + 1));
				break;
			case LEFT:
				sections.add(0, new SnakeSection(getX() - 1, getY()));
				break;
		}
		if (getX() < 0 || getX() >= Room.game.getWidth() || getY() < 0 || getY() >= Room.game.getHeight()) isAlive = false;
		for (SnakeSection section : oldSections) if (getX() == section.getX() && getY() == section.getY()) isAlive = false;
		if (isAlive) {
			if (sections.get(0).getX() == Room.game.getMouse().getX() && sections.get(0).getY() == Room.game.getMouse().getY()) {
				Room.game.eatMouse();
			} else sections.remove(getSections().size() - 1);
		}
		else sections = oldSections;
	}
}