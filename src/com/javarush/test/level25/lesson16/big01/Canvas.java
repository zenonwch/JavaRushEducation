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

	public void setPoint(double x, double y, char c) {
		if (x < 0 || y < 0 || y > matrix.length || x > matrix[0].length) return;
		int x0 = (int) x;
		int y0 = (int) y;
		matrix[y0][x0] = c;
	}

	public void drawMatrix(double x, double y, int[][] matrix, char c) {
		int x0 = (int) x;
		int y0 = (int) y;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] != 0) setPoint(x + j, y + i, c);
			}
		}
	}

	public void clear() {
		matrix = new char[width][height];
	}

	public void print() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();
	}
}
