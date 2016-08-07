package com.javarush.test.level09.lesson02.task05;

/* Метод должен возвращать результат – глубину его стек-трейса
Написать метод, который возвращает результат – глубину его стек трейса – количество методов в нем (количество элементов в списке). Это же число метод должен выводить на экран.
*/

public class Solution {
	public static int getStackTraceDeep() {
		StackTraceElement[] els = Thread.currentThread().getStackTrace();
		System.out.println(els.length);
		return els.length;
	}
}
