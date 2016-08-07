package com.javarush.test.level21.lesson08.task01;

import java.util.LinkedHashMap;
import java.util.Map;

/* Глубокое клонирование карты
Клонируйтие объект класса Solution используя глубокое клонирование.
Данные в карте users также должны клонироваться.
Метод main изменять нельзя.
*/
public class Solution implements Cloneable {

	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.users.put("Hubert", new User(172, "Hubert"));
		solution.users.put("Zapp", new User(41, "Zapp"));
		Solution clone = null;
		try {
			clone = solution.clone();
			System.out.println(solution);
			System.out.println(clone);

			System.out.println(solution.users);
			System.out.println(clone.users);

		}
		catch (CloneNotSupportedException e) {
			e.printStackTrace(System.err);
		}
	}

	public Solution clone() throws CloneNotSupportedException {
		Solution clone = (Solution) super.clone();
		clone.users = new LinkedHashMap<>();
		for (Map.Entry<String, User> pair : this.users.entrySet()) {
			clone.users.put(pair.getKey(), pair.getValue().clone());
		}
		return clone;
	}

	protected Map<String, User> users = new LinkedHashMap();

	public static class User implements Cloneable {
		int age;
		String name;

		public User(int age, String name) {
			this.age = age;
			this.name = name;
		}

		@Override
		public User clone() throws CloneNotSupportedException {
			return (User) super.clone();
		}
	}
}
