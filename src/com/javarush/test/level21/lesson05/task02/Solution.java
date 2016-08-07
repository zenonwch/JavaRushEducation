package com.javarush.test.level21.lesson05.task02;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* Исправить ошибку
Сравнение объектов Solution не работает должным образом. Найти ошибку и исправить.
Метод main не участвует в тестировании.
*/
public class Solution {
	private final String first, last;

	public Solution(String first, String last) {
		this.first = first;
		this.last = last;
	}

	public boolean equals(Object o) {
		if (o == null) return false;
		if (!(o instanceof Solution)) return false;
		Solution n = (Solution) o;
		return Objects.equals(first, n.first) &&
				Objects.equals(last, n.last);
	}

	@Override
	public int hashCode() {
		return Objects.hash(first, last);
	}

	public static void main(String[] args) {
		Set<Solution> s = new HashSet<>();
		s.add(new Solution("Mickey", "Mouse"));
		s.add(new Solution(null, null));
		s.add(new Solution("first", null));
		s.add(new Solution(null, "last"));

		System.out.println(s.contains(new Solution("Mickey", "Mouse")));
		System.out.println(s.contains(new Solution(null, null)));
		System.out.println(s.contains(new Solution("first", null)));
		System.out.println(s.contains(new Solution(null, "last")));
	}
}
