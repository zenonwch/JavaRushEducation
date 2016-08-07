package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution {
	public static void main(String[] args) {
		Human grandfatherM = new Human("Пафнутий", true, 70);
		Human grandfatherF = new Human("Илларион", true, 65);
		Human grandmotherM = new Human("Фекла", false, 60);
		Human grandmotherF = new Human("Элеонора", false, 57);
		Human father = new Human("Энди", true, 35);
		Human mother = new Human("Элен", false, 32);
		Human son = new Human("Максим", true, 10);
		Human daughter1 = new Human("Мэри", false, 5);
		Human daughter2 = new Human("Кейт", false, 1);

		ArrayList<Human> fasChild = new ArrayList<>();
		fasChild.add(father);
		ArrayList<Human> masChild = new ArrayList<>();
		masChild.add(mother);
		ArrayList<Human> children = new ArrayList<>();
		children.add(son);
		children.add(daughter1);
		children.add(daughter2);

		grandfatherF.children = fasChild;
		grandmotherF.children = fasChild;
		grandfatherM.children = masChild;
		grandmotherM.children = masChild;
		father.children = children;
		mother.children = children;

		System.out.println(grandfatherF);
		System.out.println(grandmotherF);
		System.out.println(grandfatherM);
		System.out.println(grandmotherM);
		System.out.println(father);
		System.out.println(mother);
		System.out.println(son);
		System.out.println(daughter1);
		System.out.println(daughter2);
	}

	public static class Human {
		String name;
		boolean sex;
		int age;
		ArrayList<Human> children;

		public Human(String name, boolean sex, int age) {
			this.name = name;
			this.sex = sex;
			this.age = age;
			this.children = new ArrayList<>();
		}

		public String toString() {
			String text = "";
			text += "Имя: " + this.name;
			text += ", пол: " + (this.sex ? "мужской" : "женский");
			text += ", возраст: " + this.age;

			int childCount = this.children.size();
			if (childCount > 0) {
				text += ", дети: " + this.children.get(0).name;

				for (int i = 1; i < childCount; i++) {
					Human child = this.children.get(i);
					text += ", " + child.name;
				}
			}

			return text;
		}
	}

}
