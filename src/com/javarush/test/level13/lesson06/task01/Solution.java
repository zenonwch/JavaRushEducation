package com.javarush.test.level13.lesson06.task01;

/* Dog, Cat и Mouse
1. Создать классы Dog, Cat и Mouse.
2. Реализовать интерфейсы в добавленных классах, учитывая что:
- Кот(Cat) может передвигаться, может кого-то съесть и может быть сам съеден.
- Мышь(Mouse) может передвигаться и может быть съедена.
- Собака(Dog) может передвигаться и съесть кого-то.
*/

public class Solution {

	public interface Moveable {
		void move();
	}

	public interface Eatable{
		void eaten();
	}

	public interface Eat  {
		void eat();
	}

	public abstract class Dog implements Eat, Moveable {}
	public abstract class Cat implements Eat, Eatable, Moveable {}
	public abstract class Mouse implements Eatable, Moveable {}
}
