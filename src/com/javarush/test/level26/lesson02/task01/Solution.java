package com.javarush.test.level26.lesson02.task01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/* Почитать в инете про медиану выборки
Реализовать логику метода sort, который должен сортировать данные в массиве по удаленности от его медианы
Вернуть отсортированный массив от минимального расстояния до максимального
Если удаленность одинаковая у нескольких чисел, то выводить их в порядке возрастания
*/
public class Solution {
	public static Integer[] sort(Integer[] array) {
		Arrays.sort(array);
		int len = array.length;
		final double median;
		if (len % 2 != 0) median = array[len / 2];
		else median = (double) (array[len / 2 - 1] + array[len / 2]) / 2;

		Arrays.sort(array, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				double res = Math.abs(o1 - median) - Math.abs(o2 - median);
				if (res == 0) return o1 - o2;
				else return (int) res;
			}
		});

		return array;
	}
}