package com.javarush.test.level02.lesson03.task02;

/* Три собаки - это сила
Создать 3 объекта типа Dog (собака) и присвоить им имена "Max", "Bella", "Jack".
*/
public class Solution {
	public static void main(String[] args) {
		Dog dog1 = new Dog();
		dog1.name = "Max";

		Dog dog2 = new Dog();
		dog2.name = "Bella";

		Dog dog3 = new Dog();
		dog3.name = "Jack";
	}

	public static class Dog {
		public String name;
	}
}
