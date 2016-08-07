package com.javarush.test.level16.lesson13.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Клубок
1. Создай 5 различных своих нитей c отличным от Thread типом:
1.1. нить 1 должна бесконечно выполняться;
1.2. нить 2 должна выводить "InterruptedException" при возникновении исключения InterruptedException;
1.3. нить 3 должна каждые полсекунды выводить "Ура";
1.4. нить 4 должна реализовать интерфейс Message, при вызове метода showWarning нить должна останавливаться;
1.5. нить 5 должна читать с консоли цифры пока не введено слово "N", а потом вывести в консоль сумму введенных цифр.
2. В статическом блоке добавь свои нити в List<Thread> threads в перечисленном порядке.
3. Нити не должны стартовать автоматически.
Подсказка: Нить 4 можно проверить методом isAlive()
*/

public class Solution {
	public static List<Thread> threads = new ArrayList<>(5);

	static {
		threads.add(new InfinitThread());
		threads.add(new InterruptedThread());
		threads.add(new HurayThread());
		threads.add(new MessageThread());
		threads.add(new SumNThread());
	}

	public static class InfinitThread extends Thread {
		public void run() {
			while (!isInterrupted()) {
			}
		}
	}

	public static class InterruptedThread extends Thread {
		public void run() {
			try {
				while (!isInterrupted()) {
					Thread.sleep(10000);
				}
			}
			catch (InterruptedException e) {
				System.out.println("InterruptedException");
			}
		}
	}

	public static class HurayThread extends Thread {
		public void run() {
			try {
				while (true) {
					System.out.println("Ура");
					Thread.sleep(500);
				}
			}
			catch (InterruptedException e) {
			}
		}
	}

	public static class MessageThread extends Thread implements Message {

		@Override
		public void showWarning() {
			this.interrupt();
			try {
				if (this.isAlive()) {
					this.join();
				}
			}
			catch (InterruptedException e) {
			}
		}

		@Override
		public void run() {
			while (!this.isInterrupted()) ;
		}
	}

	public static class SumNThread extends Thread {

		public void run() {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			int sum = 0;
			while (true) {
				try {
					String s = reader.readLine();
					if (s.equals("N")) break;
					sum += Integer.parseInt(s);
				}
				catch (IOException e) {
				}
				System.out.println(sum);
			}
		}
	}
}
