package com.javarush.test.level08.lesson11.home05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Мама Мыла Раму. Теперь с большой буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа заменяет в тексте первые буквы всех слов на заглавные.
Вывести результат на экран.

Пример ввода:
  мама     мыла раму.

Пример вывода:
  Мама     Мыла Раму.
*/

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String s = reader.readLine();
		ArrayList<Character> chars = new ArrayList<Character>();
		for (char c : s.toCharArray()) {
			chars.add(c);
		}
		for (int i = 0, l = chars.size(); i < l; i++) {
			if (i == 0 && !Character.isWhitespace(chars.get(i))) chars.set(i, Character.toUpperCase(chars.get(i)));
			if (Character.isWhitespace(chars.get(i)) && i != l - 1 && !Character.isWhitespace(chars.get(i + 1))) chars.set(i + 1, Character.toUpperCase(chars.get(i + 1)));
		}
		for (char c : chars) System.out.print(c);
	}
}
