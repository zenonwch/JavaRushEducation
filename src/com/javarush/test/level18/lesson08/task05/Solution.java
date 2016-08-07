package com.javarush.test.level18.lesson08.task05;

import java.util.List;

/* Таблица
Измените класс TableInterfaceWrapper так, чтобы он стал Wrapper-ом для ATableInterface.
Метод setModel должен вывести в консоль количество элементов в новом листе перед обновлением модели
Метод getHeaderText должен возвращать текст в верхнем регистре - используйте метод toUpperCase()
*/

public class Solution {
	public class TableInterfaceWrapper implements ATableInterface {
		private ATableInterface ati;

		public TableInterfaceWrapper(ATableInterface ati) {
			this.ati = ati;
		}

		public void setModel(List rows) {
			System.out.println(rows.size());
			this.ati.setModel(rows);
		}

		public void setHeaderText(String headerText) {
			this.ati.setHeaderText(headerText);
		}

		public String getHeaderText() {
			return this.ati.getHeaderText().toUpperCase();
		}
	}

	public interface ATableInterface {
		void setModel(List rows);

		String getHeaderText();

		void setHeaderText(String newHeaderText);
	}
}