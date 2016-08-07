package com.javarush.test.level17.lesson10.home09;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Транзакционность
Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
1. Считать с консоли 2 имени файла
2. Считать построчно данные из файлов. Из первого файла - в allLines, из второго - в forRemoveLines
В методе joinData:
3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки, которые есть в forRemoveLines
4. Если список allLines НЕ содержит каких-либо строк, которые есть в forRemoveLines, то
4.1. очистить allLines от данных
4.2. выбросить исключение CorruptedDataException
Метод joinData должен вызываться в main. Все исключения обработайте в методе main.
*/

public class Solution {
	public static List<String> allLines = new ArrayList<>();
	public static List<String> forRemoveLines = new ArrayList<>();

	public static void main(String[] args) {
		String f1;
		String f2;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			f1 = reader.readLine();
			f2 = reader.readLine();
			BufferedReader fileReader1 = new BufferedReader(new FileReader(f1));
			BufferedReader fileReader2 = new BufferedReader(new FileReader(f2));
			while (fileReader1.ready()) allLines.add(fileReader1.readLine());
			while (fileReader2.ready()) forRemoveLines.add(fileReader2.readLine());
			reader.close();
			fileReader1.close();
			fileReader2.close();
			new Solution().joinData();
		}
		catch (IOException e) {
		}
	}

	public void joinData() throws CorruptedDataException {
			if (allLines.containsAll(forRemoveLines)) allLines.removeAll(forRemoveLines);
			else {
				allLines.clear();
				throw new CorruptedDataException();
			}
	}
}
