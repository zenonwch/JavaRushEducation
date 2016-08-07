package com.javarush.test.level05.lesson07.task05;

/* Создать класс прямоугольник (Rectangle)
Создать класс прямоугольник (Rectangle). Его данными будут top, left, width, height (левая координата, верхняя, ширина и высота). Создать для него как можно больше методов initialize(…)
Примеры:
-	заданы 4 параметра: left, top, width, height
-	ширина/высота не задана (оба равны 0)
-	высота не задана (равно ширине) создаём квадрат
-	создаём копию другого прямоугольника (он и передаётся в параметрах)
*/

public class Rectangle {
	int top;
	int left;
	int width;
	int height;

	public void initialize(Rectangle rectangle) {
		this.left = rectangle.left;
		this.top = rectangle.top;
		this.width = rectangle.width;
		this.height = rectangle.height;
	}

	public void initialize(int left, int top, int width) {
		this.left = left;
		this.top = top;
		this.width = width;
		height = width;
	}

	public void initialize(int left, int top) {
		this.left = left;
		this.top = top;
		width = 0;
		height = 0;
	}

	public void initialize(int left, int top, int width, int height) {
		this.left = left;
		this.top = top;
		this.width = width;
		this.height = height;
	}
}
