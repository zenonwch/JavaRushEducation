package com.javarush.test.level07.lesson06.task01;

import java.util.ArrayList;

/* 5 различных строчек в списке
1. Создай список строк.
2. Добавь в него 5 различных строчек.
3. Выведи его размер на экран.
4. Используя цикл выведи его содержимое на экран, каждое значение с новой строки.
*/
public class Solution {
	public static void main(String[] args) throws Exception {
		ArrayList<String > list = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			list.add("string" + (i + 1));
		}
		System.out.println(list.size());
		for(String s : list) {
			System.out.println(s);
		}
	}
}
