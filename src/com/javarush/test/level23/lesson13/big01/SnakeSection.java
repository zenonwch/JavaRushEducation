package com.javarush.test.level23.lesson13.big01;

public class SnakeSection {
	private int x;
	private int y;

	public SnakeSection(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public boolean equals(Object obj) {
		if (this.getClass() != obj.getClass()) return false;
		return (this.getX() == ((SnakeSection) obj).getX() && this.getY() == ((SnakeSection) obj).getY());
	}

	@Override
	public int hashCode() {
		return 31*(this.getX() + this.getY());
	}
}
