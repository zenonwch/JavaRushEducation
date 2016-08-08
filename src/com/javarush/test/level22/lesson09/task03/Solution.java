package com.javarush.test.level22.lesson09.task03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/* Составить цепочку слов
В методе main считайте с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставить все слова в таком порядке,
чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.
В файле не обязательно будет много слов.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
*/
public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String fileName = reader.readLine();
		reader.close();
		BufferedReader fr = new BufferedReader(new FileReader(fileName));
		String[] words = null;
		while (fr.ready()) {
			words = fr.readLine().split(" ");
		}
		fr.close();
		StringBuilder result = getLine(words);
		System.out.println(result.toString());
	}

	public static StringBuilder getLine(String... words) {
		StringBuilder res = new StringBuilder("");
		if (words == null || words.length == 0) return res;
		ArrayList<String> list = new ArrayList<>(Arrays.asList(words));
		while(list.size() > 0) {
			res = new StringBuilder("");
			ArrayList<String> copyList = new ArrayList<>(list);
			for (String s : copyList) {
				if (res.length() == 0) {
					res.append(s);
					list.remove(s);
				} else if (res.toString().toLowerCase().charAt(res.length() - 1) == s.toLowerCase().charAt(0)) {
					res.append(" ");
					res.append(s);
					list.remove(s);
				}
			}
			if (list.size() > 0) {
				list = new ArrayList<>(copyList);
				Collections.shuffle(list);
			}
		}
		return res;
	}
}