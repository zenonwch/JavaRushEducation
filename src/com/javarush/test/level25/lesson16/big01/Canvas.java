package com.javarush.test.level25.lesson16.big01;

public class Canvas {
	private int width;
	private int height;
	private char[][] matrix;

	public Canvas(int width, int height) {
		this.width = width;
		this.height = height;
		this.matrix = new char[height][width];
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public char[][] getMatrix() {
		return matrix;
	}
}
