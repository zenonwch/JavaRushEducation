package com.javarush.test.level12.lesson06.task05;

/* Классы Cat и Dog от Pet
Унаследуй классы Cat и Dog от Pet.
Реализуй недостающие методы. Классы Cat и Dog не должны быть абстрактными.
*/

public class Solution {
	public static void main(String[] args) {

	}

	public static abstract class Pet {

		public abstract String getName();

		public abstract Pet getChild();
	}

	public static class Cat extends Pet {
		private String name;

		public String getName() {
			return this.name;
		}

		public Pet getChild() {
			return new Cat();
		}
	}

	public static class Dog extends Pet {
		private String name;

		public String getName() {
			return this.name;
		}

		public Pet getChild() {
			return new Dog();
		}
	}
}
