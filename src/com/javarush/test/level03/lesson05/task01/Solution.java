package com.javarush.test.level03.lesson05.task01;

/* Измените программу
Подумайте, что делает программа.
Измените метод public static void printFullName(Student student). Метод должен выводить полное ФИО студента на экран.
Слова разделить пробелом.
Пример вывода:
Mark Elliot Zuckerberg
*/

public class Solution {
	public static void main(String[] args) {
		Student student = new Student();
		student.firstName = "Mark";
		student.middleName = "Elliot";
		student.lastName = "Zuckerberg";
		printFullName(student);
	}

	public static void printFullName(Student student) {
		System.out.print(student.firstName + " " + student.middleName + " " + student.lastName);
	}

	public static class Student {
		public String firstName;
		public String middleName;
		public String lastName;
	}
}