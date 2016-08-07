package com.javarush.test.level13.lesson11.home10;

import java.awt.*;

/* Компиляция программы
1. Исправь классы Fox и BigFox так, чтобы программа компилировалась. Задача не предполагает создания экземпляров базового класса.
2. Метод main менять нельзя.
*/

public class Solution {

	public static void main(String[] args) throws Exception {
		Fox bigFox = new BigFox();
		System.out.println(bigFox.getName());
		System.out.println(bigFox.getColor());
	}

	public interface Animal {
		Color getColor();
	}

	public abstract static class Fox implements Animal {
		public String getName() {
			return "Fox";
		}
	}

	public static class BigFox extends Fox {
		Color color;

		public Color getColor() {
			return this.color;
		}
	}

}
