package com.javarush.test.level20.lesson10.bonus01;

import java.util.ArrayList;

/* Алгоритмы-числа
Число S состоит из M чисел, например, S=370 и M(количество цифр)=3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.
*/
public class Solution {
	public static void main(String[] args) {
		Runtime r = Runtime.getRuntime();
		Long t0 = System.currentTimeMillis();
		int[] arr = getNumbers(Integer.MAX_VALUE);
		for (int i : arr) System.out.println(i);
		double memoTaken = r.freeMemory();
		Long t1 = System.currentTimeMillis();
		System.out.println("Time: " + (t1 - t0) / 1000 + "sec. Memory: " + memoTaken + ".");
	}

	public static int[] getNumbers(int N) {
		long[] pow = new long[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		int currM = 1;
		ArrayList<Integer> results = new ArrayList<>();
		for (int i = 1; i < N; i++) {
			int res = 0;
			int S = i;
			int newM = (int) Math.log10(S) + 1;
			if (newM > currM) {
				for (int j = 0; j < 10; j++) pow[j] = pow[j] * j;
				currM = newM;
			}
			for (int j = newM; j > 0; j--) {
				if (pow[S % 10] > i) {
					res = 0;
					break;
				}
				res += pow[S % 10];
				if (res > i) break;
				S = S / 10;
			}
			if (i == res)	results.add(res);
		}
		int[] result = new int[results.size()];
		for (int i = 0, l = results.size(); i < l; i++) result[i] = results.get(i);
		return result;
	}
}