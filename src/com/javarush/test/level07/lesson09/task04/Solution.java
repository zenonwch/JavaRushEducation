package com.javarush.test.level07.lesson09.task04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Буква «р» и буква «л»
1. Создай список слов, заполни его самостоятельно.
2. Метод fix должен:
2.1. удалять из списка строк все слова, содержащие букву «р»
2.2. удваивать все слова содержащие букву «л».
2.3. если слово содержит и букву «р» и букву «л», то оставить это слово без изменений.
2.4. с другими словами ничего не делать.
Пример:
роза
лира
лоза
Выходные данные:
лира
лоза
лоза
*/

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

		ArrayList<String> list = new ArrayList<>();
		list.add("азов"); //0
		list.add("роза"); //0
		list.add("роза"); //0
		list.add("лира"); //1
		list.add("лоза"); //2
		list.add("дно"); //2
		list.add("зерно"); //2
		list.add("лепра"); //2
		list.add("зола"); //2
		list = fix(list);

		for (String s : list) {
			System.out.println(s);
		}
	}

	public static ArrayList<String> fix(ArrayList<String> list) {
		for (int i = 0; i < list.size(); ) {
			if (list.get(i).contains("р") && !list.get(i).contains("л")) {
				list.remove(i);
			} else if (list.get(i).contains("л") && !list.get(i).contains("р")) {
				list.add(i, list.get(i));
				i += 2;
			} else {
				i++;
			}
		}
		return list;
	}
}