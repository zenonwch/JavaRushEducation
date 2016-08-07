package com.javarush.test.level05.lesson09.task05;

/* Создать класс прямоугольник (Rectangle)
Создать класс прямоугольник (Rectangle). Его данными будут top, left, width, height (левая координата, верхняя, ширина и высота). Создать для него как можно больше конструкторов:
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

	public Rectangle(Rectangle rectangle) {
		this.top = rectangle.top;
		this.left = rectangle.left;
		this.width = rectangle.width;
		this.height = rectangle.height;
	}

	public Rectangle(int top, int left, int width) {
		this.top = top;
		this.left = left;
		this.width = width;
		height = width;
	}

	public Rectangle(int top, int left) {
		this.top = top;
		this.left = left;
		width = 0;
		height = 0;
	}

	public Rectangle(int top, int left, int width, int height) {
		this.top = top;
		this.left = left;
		this.width = width;
		this.height = height;
	}
}
