package com.javarush.test.level08.lesson08.task02;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* Удалить все числа больше 10
Создать множество чисел(Set<Integer>), занести туда 20 различных чисел.
Удалить из множества все числа больше 10.
*/

public class Solution {
	public static HashSet<Integer> createSet() {
		HashSet<Integer> set = new HashSet<>();
		Collections.addAll(set, 5, 8, 9, 11, 45, 2, 19, 23, 90, 6, 17, 12, 33, 14, 51, 3, 4, 0, -3, -55);
		return set;
	}

	public static HashSet<Integer> removeAllNumbersMoreThan10(HashSet<Integer> set) {
		Iterator<Integer> i = set.iterator();
		while (i.hasNext()) {
			int n = i.next();
			if (n > 10) i.remove();
		}
		return set;
	}
}
