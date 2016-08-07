package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human). Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

public class Solution {
	public static void main(String[] args) {
		Human grandfatherM = new Human("Пафнутий", true, 70);
		Human grandfatherF = new Human("Илларион", true, 65);
		Human grandmotherM = new Human("Фекла", false, 60);
		Human grandmotherF = new Human("Элеонора", false, 57);
		Human father = new Human("Энди", true, 35, grandfatherF, grandmotherF);
		Human mother = new Human("Элен", false, 32, grandfatherM, grandmotherM);
		Human son = new Human("Максим", true, 10, father, mother);
		Human daughter1 = new Human("Мэри", false, 5, father, mother);
		Human daughter2 = new Human("Кейт", false, 1, father, mother);

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
		Human father;
		Human mother;

		public Human(String name, boolean sex, int age, Human father, Human mother) {
			this.name = name;
			this.sex = sex;
			this.age = age;
			this.father = father;
			this.mother = mother;
		}

		public Human(String name, boolean sex, int age) {
			this.name = name;
			this.sex = sex;
			this.age = age;
		}

		public String toString() {
			String text = "";
			text += "Имя: " + this.name;
			text += ", пол: " + (this.sex ? "мужской" : "женский");
			text += ", возраст: " + this.age;

			if (this.father != null)
				text += ", отец: " + this.father.name;

			if (this.mother != null)
				text += ", мать: " + this.mother.name;

			return text;
		}
	}

}
