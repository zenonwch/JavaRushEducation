package com.javarush.test.level22.lesson09.task01;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример содержимого файла
рот тор торт о
о тот тот тот
Вывод:
рот тор
о о
тот тот
*/
public class Solution {
	public static List<Pair> result = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String fileName = reader.readLine();
		reader.close();
		BufferedReader fr = new BufferedReader(new FileReader(fileName));
		ArrayList<String> list = new ArrayList<>();
		while (fr.ready()) {
			String line = fr.readLine();
			list.addAll(Arrays.asList(line.split(" ")));
		}
		fr.close();
		while (true) {
			if (list.size() == 0) break;
			String word = list.remove(0);
			for (String s : list) {
				if (new StringBuilder(s).reverse().toString().equals(word)) {
					Pair pair = new Pair();
					pair.first = word;
					pair.second = s;
					result.add(pair);
					list.remove(list.indexOf(s));
					break;
				}
			}
		}
		for (Pair p : result) System.out.println(p);
	}

	public static class Pair {
		String first;
		String second;

		@Override
		public String toString() {
			return first == null && second == null ? "" :
					first == null && second != null ? second :
							second == null && first != null ? first :
									first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

		}
	}

}
