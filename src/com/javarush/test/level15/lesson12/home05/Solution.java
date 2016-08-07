package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

public class Solution {
	public Solution(int a) {}
	public Solution(String s) {}
	public Solution(boolean b) {}

	protected Solution(int a, int b) {}
	protected Solution(String s, String ss) {}
	protected Solution(boolean t, boolean f) {}

	Solution(int a, String s) {}
	Solution(String s, int a) {}
	Solution(boolean b, int a) {}

	private Solution(int a, int b, int c) {}
	private Solution(String s, String ss, String sss) {}
	private Solution(boolean t, boolean f, boolean b) {}
}

