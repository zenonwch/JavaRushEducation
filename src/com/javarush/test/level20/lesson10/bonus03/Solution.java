package com.javarush.test.level20.lesson10.bonus03;

import java.util.ArrayList;
import java.util.List;

/* Кроссворд
1. Дан двумерный массив, который содержит буквы английского алфавита в нижнем регистре.
2. Метод detectAllWords должен найти все слова из words в массиве crossword.
3. Элемент(startX, startY) должен соответствовать первой букве слова, элемент(endX, endY) - последней.
text - это само слово, располагается между начальным и конечным элементами
4. Все слова есть в массиве.
5. Слова могут быть расположены горизонтально, вертикально и по диагонали как в нормальном, так и в обратном порядке.
6. Метод main не участвует в тестировании
*/
public class Solution {
	public static void main(String[] args) {
		int[][] crossword = new int[][]{
				{'f', 'd', 'e', 'r', 'l', 'k'},
				{'u', 's', 'a', 'm', 'e', 'o'},
				{'l', 'n', 'g', 'r', 'o', 'v'},
				{'m', 'l', 'p', 'r', 'r', 'h'},
				{'p', 'o', 'e', 'e', 'j', 'j'}
		};
		System.out.println(detectAllWords(crossword, "home", "same"));
		/*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
	}

	public static List<Word> detectAllWords(int[][] crossword, String... words) {
		List<Word> list = new ArrayList<>();
		Word w;
		for (String word : words) {
			w = null;
			for (int i = 0, l = crossword.length; i < l; i++) {
				for (int j = 0, k = crossword[i].length; j < k; j++) {
					if (crossword[i][j] == (word.charAt(0))) {
						//west
						w = checkWord(crossword, word, i, j, 0, 1);
						if (w != null) break;
						//south-west
						w = checkWord(crossword, word, i, j, 1, 1);
						if (w != null) break;
						//south
						w = checkWord(crossword, word, i, j, 1, 0);
						if (w != null) break;
						//south-east
						w = checkWord(crossword, word, i, j, 1, -1);
						if (w != null) break;
						//east
						w = checkWord(crossword, word, i, j, 0, -1);
						if (w != null) break;
						//north-east
						w = checkWord(crossword, word, i, j, -1, -1);
						if (w != null) break;
						//north
						w = checkWord(crossword, word, i, j, -1, 0);
						if (w != null) break;
						//north-west
						w = checkWord(crossword, word, i, j, -1, 1);
						if (w != null) break;
					}
				}
				if (w != null) break;
			}
			if (w != null) list.add(w);
		}
		return list;
	}

	public static Word checkWord(int[][] cw, String word, int x, int y, int dx, int dy) {
		int d = word.length() - 1;
		Word w = null;
		int counter = 1;
		for (int i = 1; i <= d; i++) {
			try {
				if (cw[x + i * dx][y + i * dy] == word.charAt(i)) counter++;
				else break;
			}
			catch (ArrayIndexOutOfBoundsException e) {
				break;
			}
		}
		if (counter == word.length()) {
			w = new Word(word);
			w.setStartPoint(y, x);
			w.setEndPoint(y + d * dy, x + d * dx);
		}
		return w;
	}

	public static class Word {
		private String text;
		private int startX;
		private int startY;
		private int endX;
		private int endY;

		public Word(String text) {
			this.text = text;
		}

		public void setStartPoint(int i, int j) {
			startX = i;
			startY = j;
		}

		public void setEndPoint(int i, int j) {
			endX = i;
			endY = j;
		}

		@Override
		public String toString() {
			return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
		}
	}
}
