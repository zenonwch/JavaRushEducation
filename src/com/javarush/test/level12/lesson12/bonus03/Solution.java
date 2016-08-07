package com.javarush.test.level12.lesson12.bonus03;

/* Задача по алгоритмам
Написать метод, который возвращает минимальное число в массиве и его позицию (индекс).
*/

public class Solution {
	public static void main(String[] args) throws Exception {
		int[] data = new int[]{1, 2, 3, 5, -2, -8, 0, 77, 5, 5};

		Pair<Integer, Integer> result = getMinimumAndIndex(data);

		System.out.println("Minimum is " + result.x);
		System.out.println("Index of minimum element is " + result.y);
	}

	public static Pair<Integer, Integer> getMinimumAndIndex(int[] array) {
		if (array == null || array.length == 0) {
			return new Pair<>(null, null);
		}
		int ind = 0;
		int min = array[0];
		for (int i = 0, l = array.length; i < l; i++) {
			if (array[i] < min) {
				min = array[i];
				ind = i;
			}
		}
		return new Pair<>(min, ind);
	}


	public static class Pair<X, Y> {
		public X x;
		public Y y;

		public Pair(X x, Y y) {
			this.x = x;
			this.y = y;
		}
	}
}
