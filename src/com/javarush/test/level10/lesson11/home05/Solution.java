package com.javarush.test.level10.lesson11.home05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/* Количество букв
Ввести с клавиатуры 10 строчек и подсчитать в них количество различных букв (для 33 букв алфавита).  Вывести результат на экран.
Пример вывода:
а 5
б 8
в 3
г 7
д 0
…
я 9
*/

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		//алфавит
		String abc = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
		char[] abcArray = abc.toCharArray();

		ArrayList<Character> alphabet = new ArrayList<>();
		for (int i = 0; i < abcArray.length; i++) {
			alphabet.add(abcArray[i]);
		}

		//ввод строк
		ArrayList<String> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			String s = reader.readLine();
			list.add(s.toLowerCase());
		}

		Map<Character, Integer> map = new HashMap<>();
		for (char c : abcArray) {
			map.put(c, 0);
		}
		for (String s : list) {
			char[] sArray = s.toCharArray();
			for (char c : sArray) {
				char lowC = Character.toLowerCase(c);
				if (alphabet.contains(lowC)) map.put(lowC, map.get(lowC) + 1);
			}
		}
		for (char a : alphabet) System.out.println(a + " " + map.get(a));
	}
}
