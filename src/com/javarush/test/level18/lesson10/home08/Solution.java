package com.javarush.test.level18.lesson10.home08;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
	public static Map<String, Integer> resultMap = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String line = reader.readLine();
			if (line.equals("exit")) break;
			new ReadThread(line).start();
		}
		reader.close();
	}

	public static class ReadThread extends Thread {
		public ReadThread(String fileName) {
			super(fileName);
		}

		public void run() {
			try {
				FileInputStream fis = new FileInputStream(this.getName());
				Map<Integer, Integer> map = new HashMap<>();
				int maxByteCount = Integer.MIN_VALUE;
				int maxByte = 0;

				while (fis.available() > 0) {
					int b = fis.read();
					if (map.containsKey(b)) map.put(b, map.get(b) + 1);
					else map.put(b, 1);
				}

				fis.close();

				for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
					if (pair.getValue() > maxByteCount) {
						maxByteCount = pair.getValue();
						maxByte = pair.getKey();
					}
				}

				synchronized (Solution.class) {
					resultMap.put(this.getName(), maxByte);
				}
			}
			catch (IOException e) {
			}
		}
	}
}