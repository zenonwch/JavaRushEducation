package com.javarush.test.level08.lesson11.bonus01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* Номер месяца
Программа вводит с клавиатуры имя месяца и выводит его номер на экран в виде: «May is 5 month».
Используйте коллекции.
*/

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String> months = new ArrayList<>();
		months.add(0, null);
		months.add(1, "January");
		months.add(2, "February");
		months.add(3, "March");
		months.add(4, "April");
		months.add(5, "May");
		months.add(6, "June");
		months.add(7, "July");
		months.add(8, "August");
		months.add(9, "September");
		months.add(10, "October");
		months.add(11, "November");
		months.add(12, "December");

		String input = reader.readLine();
		System.out.println(input + " is " + months.indexOf(input) + " month");
	}
}
