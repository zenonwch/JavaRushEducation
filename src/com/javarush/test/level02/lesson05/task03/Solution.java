package com.javarush.test.level02.lesson05.task03;

/* У каждого животного должна быть хозяйка.
Создайте объект типа Cat(кот), объект типа Dog (собака), объект типа Fish (рыбка) и объект типа Woman.
Присвойте каждому животному владельца (owner).
*/
public class Solution {
	public static void main(String[] args) {
		Woman woman = new Woman();

		Cat cat = new Cat();
		cat.owner = woman;

		Dog dog = new Dog();
		dog.owner = woman;

		Fish fish = new Fish();
		fish.owner = woman;
	}

	public static class Cat {
		public Woman owner;
	}

	public static class Dog {
		public Woman owner;
	}

	public static class Fish {
		public Woman owner;
	}

	public static class Woman {
	}
}
