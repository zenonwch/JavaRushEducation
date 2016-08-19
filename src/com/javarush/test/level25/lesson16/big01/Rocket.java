package com.javarush.test.level25.lesson16.big01;

/**
 * Класс для ракеты.
 */
public class Rocket extends BaseObject {
	public Rocket(double x, double y) {
		super(x, y, 1);
	}

	/**
	 * Отрисовываем себя на холсте.
	 */
	@Override
	public void draw(Canvas canvas) {
		canvas.setPoint(x, y, 'R');
	}

	/**
	 * Двигаем себя вниз на один ход.
	 */
	@Override
	public void move() {
		y--;
	}
}
