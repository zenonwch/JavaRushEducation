package com.javarush.test.level13.lesson02.task05;

/* 4 ошибки
Исправь 4 ошибки в программе, чтобы она компилировалась.
Объявление интерфейсов не изменять.
*/

public class Solution {

	public static void main(String[] args) throws Exception {

		System.out.println(new Hobbie().HOBBIE.toString());
		System.out.println(new Hobbie().toString());

	}

	interface Desire {
	}

	interface Dream {
		Hobbie HOBBIE = new Hobbie();
	}

	static class Hobbie implements Desire, Dream {
		static int INDEX = 1;

		@Override
		public String toString() {
			INDEX++;
			return "" + INDEX;
		}
	}

}
