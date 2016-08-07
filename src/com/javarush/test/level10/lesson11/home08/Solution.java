package com.javarush.test.level10.lesson11.home08;

import java.util.ArrayList;

/* Массив списков строк
Создать массив, элементами которого будут списки строк. Заполнить массив любыми данными и вывести их на экран.
*/

public class Solution {
	public static void main(String[] args) {
		ArrayList<String>[] arrayOfStringList = createList();
		printList(arrayOfStringList);
	}

	public static ArrayList<String>[] createList() {
		int arraySize = 3;
		ArrayList<String>[] arrayOfLists = new ArrayList[arraySize];
		ArrayList<String> list1 = new ArrayList<>();
		ArrayList<String> list2 = new ArrayList<>();
		ArrayList<String> list3 = new ArrayList<>();

		arrayOfLists[0] = list1;
		arrayOfLists[1] = list2;
		arrayOfLists[2] = list3;

		list1.add("list1.1");
		list1.add("list1.2");
		list2.add("list2.1");
		list2.add("list2.2");
		list2.add("list2.3");
		list2.add("list2.4");
		list3.add("list3.1");
		list3.add("list3.2");
		list3.add("list3.3");

		return arrayOfLists;
	}

	public static void printList(ArrayList<String>[] arrayOfStringList) {
		for (ArrayList<String> list : arrayOfStringList) {
			for (String s : list) {
				System.out.println(s);
			}
		}
	}
}