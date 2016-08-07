package com.javarush.test.level08.lesson08.task04;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution {
	public static HashMap<String, Date> createMap() {
		HashMap<String, Date> map = new HashMap<>();
		map.put("Stallone", new Date("JUNE 1 1980"));
		map.put("Arnold", new Date("JULY 1 1980"));
		map.put("Lisa", new Date("SEPTEMBER 1 1980"));
		map.put("Helen", new Date("JANUARY 1 1980"));
		map.put("Nikolas", new Date("MARCH 1 1980"));
		map.put("Duke", new Date("JUNE 1 1980"));
		map.put("Snake", new Date("AUGUST 1 1980"));
		map.put("Viola", new Date("NOVEMBER 1 1980"));
		map.put("Lenny", new Date("DECEMBER 1 1980"));
		map.put("Cris", new Date("DECEMBER 1 1980"));
		return map;
	}

	public static void removeAllSummerPeople(HashMap<String, Date> map) {
		Iterator<Map.Entry<String, Date>> itr = map.entrySet().iterator();
		while (itr.hasNext()) {
			Map.Entry<String, Date> pair = itr.next();
			if (pair.getValue().getMonth() > 4 && pair.getValue().getMonth() < 8) itr.remove();
		}
	}
}
