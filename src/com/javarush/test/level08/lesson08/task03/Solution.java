package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.Map;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution {
	public static void main(String[] args) {
		HashMap<String, String> map = createMap();
		System.out.println(getCountTheSameLastName(map, "Толстой"));
		System.out.println(getCountTheSameFirstName(map, "Михаил"));
	}

	public static HashMap<String, String> createMap() {
		HashMap<String, String> map = new HashMap<>();
		map.put("Петров", "Петр");
		map.put("Иванов", "Иван");
		map.put("Сидоров", "Петр");
		map.put("Некрасов", "Александр");
		map.put("Пушкин", "Александр");
		map.put("Лермонтов", "Михаил");
		map.put("Ломоносов", "Михаил");
		map.put("Лещенко", "Лев");
		map.put("Толстой", "Алексей");
		map.put("Носов", "Николай");
		return map;
	}

	public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {
		int counter = 0;
		for (Map.Entry<String, String> pair : map.entrySet()) if (pair.getValue().equals(name)) counter++;
		return counter;
	}

	public static int getCountTheSameLastName(HashMap<String, String> map, String lastName) {
		int counter = 0;
		for (Map.Entry<String, String> pair : map.entrySet()) if (pair.getKey().equals(lastName)) counter++;
		return counter;
	}
}
