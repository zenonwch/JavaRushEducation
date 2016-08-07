package com.javarush.test.level08.lesson08.task05;

import java.util.HashMap;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution {
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

	public static void removeTheFirstNameDuplicates(HashMap<String, String> map) {
		HashMap<String, Integer> counter = new HashMap<>();
		for (Map.Entry<String, String> pair : map.entrySet()) {
			String name = pair.getValue();
			if (counter.containsKey(name)) counter.put(name, counter.get(name) + 1);
			else counter.put(name, 1);
		}
		for (Map.Entry<String, Integer> pair : counter.entrySet()) {
			if (pair.getValue() > 1) {
				removeItemFromMapByValue(map, pair.getKey());
			}
		}
	}

	public static void removeItemFromMapByValue(HashMap<String, String> map, String value) {
		HashMap<String, String> copy = new HashMap<>(map);
		for (Map.Entry<String, String> pair : copy.entrySet()) {
			if (pair.getValue().equals(value))
				map.remove(pair.getKey());
		}
	}
}
