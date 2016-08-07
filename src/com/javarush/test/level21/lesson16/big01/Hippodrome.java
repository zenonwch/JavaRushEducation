package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

public class Hippodrome {

	public static void main(String[] args) throws InterruptedException{
		game = new Hippodrome();

		Horse horse1 = new Horse("First", 3, 0);
		Horse horse2 = new Horse("Second", 3, 0);
		Horse horse3 = new Horse("Third", 3, 0);

		game.getHorses().add(horse1);
		game.getHorses().add(horse2);
		game.getHorses().add(horse3);

		game.run();
		game.printWinner();
	}

	private ArrayList<Horse> horses = new ArrayList<>();

	public static Hippodrome game;

	public ArrayList<Horse> getHorses() {
		return horses;
	}

	public Horse getWinner() {
		Horse winner = null;
		for (Horse horse : horses) {
			if (winner == null) winner = horse;
			else if (horse.getDistance() > winner.getDistance()) winner = horse;
		}
		return winner;
	}

	public void printWinner() {
		System.out.println("Winner is " + this.getWinner().getName() + "!");
	}

	public void run() throws InterruptedException {
		for (int i = 0; i < 100; i++) {
			this.move();
			this.print();
			Thread.sleep(200);
		}
	}

	public void move() {
		for (Horse horse : horses) {
			horse.move();
		}
	}

	public void print() {
		for (Horse horse : horses) {
			horse.print();
		}
		System.out.println();
		System.out.println();
	}
}
