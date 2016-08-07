package com.javarush.test.level12.lesson04.task02;

/* print(int) и print(Integer)
Написать два метода: print(int) и print(Integer).
Написать такой код в методе main, чтобы вызвались они оба.
*/

public class Solution {
	public static void main(String[] args) {
		Integer o = new Integer(5);
		int i = 10;
		print(i);
		print(o);
	}

	public static void print(int i) {
		System.out.print(i);
	}

	public static void print(Integer o) {
		System.out.print(o);
	}
}
