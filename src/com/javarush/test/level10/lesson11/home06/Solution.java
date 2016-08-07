package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution {
	public static void main(String[] args) {

	}

	public static class Human {
		String name;
		int age;
		boolean sex;
		int height;
		int weight;
		String nationality;

		public Human(String name, int age, boolean sex, int height, int weight, String nationality) {
			this.name = name;
			this.age = age;
			this.sex = sex;
			this.height = height;
			this.weight = weight;
			this.nationality = nationality;
		}

		public Human(String name, int age, boolean sex, int weight) {
			this.name = name;
			this.age = age;
			this.sex = sex;
			this.weight = weight;
		}

		public Human(String name, String nationality) {
			this.name = name;
			this.nationality = nationality;
		}

		public Human(String name, boolean sex) {
			this.name = name;
			this.sex = sex;
		}

		public Human(String name, int age, int weight, int height, boolean sex) {
			this.name = name;
			this.age = age;
			this.weight = weight;
			this.height = height;
			this.sex = sex;
		}

		public Human(String name, int age, String nationality, boolean sex) {
			this.name = name;
			this.age = age;
			this.nationality = nationality;
			this.sex = sex;
		}

		public Human(String name, int age, boolean sex) {
			this.name = name;
			this.age = age;
			this.sex = sex;
		}

		public Human(String name, int age, int height, int weight) {
			this.name = name;
			this.age = age;
			this.height = height;
			this.weight = weight;
		}

		public Human(String name, int age) {
			this.name = name;
			this.age = age;
		}

		public Human(String name) {
			this.name = name;
		}
	}
}
