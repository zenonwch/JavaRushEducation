package com.javarush.test.level23.lesson13.big01;

public class Room {
	public static void main(String[] args) {
		Snake snake = new Snake(1, 1);
		game = new Room(10, 10, snake);
		game.getSnake().setDirection(SnakeDirection.DOWN);
		game.createMouse();
		game.run();
	}
	public static Room game;

	private int width;
	private int height;
	private Snake snake;
	private Mouse mouse;

	public Room(int width, int height, Snake snake) {
		this.width = width;
		this.height = height;
		this.snake = snake;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Snake getSnake() {
		return snake;
	}

	public void setSnake(Snake snake) {
		this.snake = snake;
	}

	public Mouse getMouse() {
		return mouse;
	}

	public void setMouse(Mouse mouse) {
		this.mouse = mouse;
	}

	public void createMouse() {
		setMouse(new Mouse((int) (Math.random() * width), (int) (Math.random() * height)));
	}

	public void eatMouse() {
		createMouse();
	}

	public void run() {}

	public void print() {}

	public void sleep() {}
}