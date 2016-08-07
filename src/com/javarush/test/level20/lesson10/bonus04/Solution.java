package com.javarush.test.level20.lesson10.bonus04;

import java.io.*;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* Свой список
Посмотреть, как реализован LinkedList.
Элементы следуют так: 1->2->3->4  и так 4->3->2->1
По образу и подобию создать Solution.
Элементы должны следовать так:
1->3->7->15
    ->8...
 ->4->9
    ->10
2->5->11
    ->12
 ->6->13
    ->14
Удалили 2 и 9
1->3->7->15
    ->8
 ->4->10
Добавили 16,17,18,19,20 (всегда добавляются на самый последний уровень к тем элементам, которые есть)
1->3->7->15
       ->16
    ->8->17
       ->18
 ->4->10->19
        ->20
Удалили 18 и 20
1->3->7->15
       ->16
    ->8->17
 ->4->10->19
Добавили 21 и 22 (всегда добавляются на самый последний уровень к тем элементам, которые есть.
Последний уровень состоит из 15, 16, 17, 19. 19 последний добавленный элемент, 10 - его родитель.
На данный момент 10 не содержит оба дочерних элемента, поэтому 21 добавился к 10. 22 добавляется в следующий уровень.)
1->3->7->15->22
       ->16
    ->8->17
 ->4->10->19
        ->21

Во внутренней реализации элементы должны добавляться по 2 на каждый уровень
Метод getParent должен возвращать элемент, который на него ссылается.
Например, 3 ссылается на 7 и на 8, т.е.  getParent("8")=="3", а getParent("13")=="6"
Строки могут быть любыми.
При удалении элемента должна удаляться вся ветка. Например, list.remove("5") должен удалить "5", "11", "12"
Итерироваться элементы должны в порядке добавления
Доступ по индексу запрещен, воспользуйтесь при необходимости UnsupportedOperationException
Должно быть наследование AbstractList<String>, List<String>, Cloneable, Serializable
Метод main в тестировании не участвует
*/
public class Solution
		extends AbstractList<String>
		implements List<String>, Cloneable, Serializable {

	public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
		List<String> list = new Solution();
		for (int i = 1; i < 16; i++) {
			list.add(String.valueOf(i));
		}
		System.out.println("Expected 3, actual is " + ((Solution) list).getParent("8"));
		System.out.println(list);
		list.remove("2");
		list.remove("9");
		System.out.println("Удалили 2 и 9:");
		System.out.println(list);

		for (int i = 16; i < 21; i++) {
			list.add(String.valueOf(i));
		}
		System.out.println("Добавили 16, 17, 18, 19, 20:");
		System.out.println(list);

		list.remove("18");
		list.remove("20");
		System.out.println("Удалили 18 и 20:");
		System.out.println(list);

		list.add("21");
		list.add("22");
		System.out.println("Добавили 21 и 22:");
		System.out.println(list);

		System.out.println("Expected null, actual is " + ((Solution) list).getParent("1"));
		System.out.println("Expected null, actual is " + ((Solution) list).getParent("2"));
		System.out.println("Expected 1, actual is " + ((Solution) list).getParent("3"));
		System.out.println("Expected 1, actual is " + ((Solution) list).getParent("4"));
		System.out.println("Expected null, actual is " + ((Solution) list).getParent("5"));
		System.out.println("Expected null, actual is " + ((Solution) list).getParent("6"));
		System.out.println("Expected 3, actual is " + ((Solution) list).getParent("7"));
		System.out.println("Expected 3, actual is " + ((Solution) list).getParent("8"));
		System.out.println("Expected null, actual is " + ((Solution) list).getParent("9"));
		System.out.println("Expected 4, actual is " + ((Solution) list).getParent("10"));
		System.out.println("Expected null, actual is " + ((Solution) list).getParent("11"));
		System.out.println("Expected null, actual is " + ((Solution) list).getParent("12"));
		System.out.println("Expected null, actual is " + ((Solution) list).getParent("13"));
		System.out.println("Expected null, actual is " + ((Solution) list).getParent("14"));
		System.out.println("Expected 7, actual is " + ((Solution) list).getParent("15"));
		System.out.println("Expected 7, actual is " + ((Solution) list).getParent("16"));
		System.out.println("Expected 8, actual is " + ((Solution) list).getParent("17"));
		System.out.println("Expected null, actual is " + ((Solution) list).getParent("18"));
		System.out.println("Expected 10, actual is " + ((Solution) list).getParent("19"));
		System.out.println("Expected null, actual is " + ((Solution) list).getParent("20"));
		System.out.println("Expected 10, actual is " + ((Solution) list).getParent("21"));
		System.out.println("Expected 15, actual is " + ((Solution) list).getParent("22"));

		try {
			ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("myLinkList.ser"));
			outputStream.writeObject(list);
			outputStream.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}

		list.clear();
		System.out.println("\nОчистили лист:");
		System.out.println(list);

		try {
			ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("myLinkList.ser"));
			list = (Solution) inputStream.readObject();
		}
		catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}

		System.out.println("\nЛист востановлен:");
		System.out.println(list);

		System.out.println("Expected 15, actual is " + ((Solution) list).getParent("22"));
	}

	public String getParent(String value) {
		value = value == null ? "null" : value;
		String parent = null;
		for (Node<String> x = first; x != null; x = x.next) {
			if (value.equals(x.item)) {
				if (x.parent != null) parent = x.parent.item;
			}
		}
		return parent;
	}

	private int size = 0;
	private Node<String> first = null;
	private Node<String> last = null;

	public Solution() {
	}

	@Override
	public String get(int index) {
		throw new UnsupportedOperationException();
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean add(String s) {
		s = s == null ? "null" : s;
		final Node<String> l = last;
		final Node<String> newNode = new Node<>(null, s, l, null, null, null);
		last = newNode;
		if (l == null) first = newNode;
		else {
			l.next = newNode;
			newNode.prev = l;
			if (l.prev == first) {
				l.prev.left = newNode;
				newNode.parent = l.prev;
			} else if (l.parent != null && l.parent.right == null) {
				l.parent.right = newNode;
				newNode.parent = l.parent;
			} else if (l.parent != null) {
				l.parent.next.left = newNode;
				newNode.parent = l.parent.next;
			}
		}
		size++;
		return true;
	}

	@Override
	public boolean remove(Object s) {
		s = s == null ? "null" : s;
		for (Node<String> x = first; x != null; ) {
			Node<String> tmpNextX = x.next;
			if (s.equals(x.item)) {
				if (x.parent != null) {
					if (x == x.parent.left) x.parent.left = null;
					if (x == x.parent.right) x.parent.right = null;
				}
				if (x.prev != null) {
					x.prev.next = x.next;
					if (x == last) last = x.prev;
				}
				if (x.next != null) {
					x.next.prev = x.prev;
					if (x == first) first = x.next;
				}

				x.item = null;

				if (x == first && x == last) first = last = null;
				if (x.left != null) remove(x.left.item);
				if (x.right != null) remove(x.right.item);
				size--;
			}
			x = tmpNextX;
		}
		return true;
	}

	@Override
	public void clear() {
		for (Node<String> x = this.first; x != null; ) {
			Node<String> next = x.next;
			x.item = null;
			x.next = null;
			x.prev = null;
			x.parent = null;
			x.left = null;
			x.right = null;
			x = next;
		}
		first = last = null;
		size = 0;
	}

	@Override
	protected Solution clone() throws CloneNotSupportedException {
		Solution clone;
		try {
			clone = (Solution) super.clone();
		}
		catch (CloneNotSupportedException e) {
			throw new InternalError();
		}
		clone.first = clone.last = null;
		clone.size = 0;
		for (Node<String> x = first; x != null; x = x.next) clone.add(x.item);
		return clone;
	}

	@Override
	public Iterator<String> iterator() {
		return new Iterator<String>() {
			private Node<String> lastReturned = null;
			private Node<String> next = first;

			@Override
			public boolean hasNext() {
				return next != null;
			}

			@Override
			public String next() {
				if (!hasNext())
					throw new NoSuchElementException();

				lastReturned = next;
				next = next.next;
				return lastReturned.item;
			}

			@Override
			public void remove() {
				if (lastReturned == null)
					throw new IllegalStateException();

				final Node<String> parent = lastReturned.parent;
				final Node<String> next = lastReturned.next;
				final Node<String> prev = lastReturned.prev;
				final Node<String> leftChild = lastReturned.left;
				final Node<String> rightChild = lastReturned.right;

				Node<String> lastNext = lastReturned.next;

				if (parent != null) {
					if (lastReturned == parent.left) parent.left = null;
					if (lastReturned == parent.right) parent.right = null;
				}
				if (prev != null) {
					prev.next = next;
					if (lastReturned == last) last = prev;
				}
				if (next != null) {
					next.prev = prev;
					if (lastReturned == first) first = next;
				}
				if (lastReturned == first && lastReturned == last) first = last = null;

				lastReturned.item = null;

				if (leftChild != null) {
					lastReturned = leftChild;
					remove();
				}
				if (rightChild != null) {
					lastReturned = rightChild;
					remove();
				}
				size--;
				lastReturned = lastNext;
			}
		};
	}

	private static class Node<E> implements Serializable {
		E item;
		Node<E> parent;
		Node<E> prev;
		Node<E> next;
		Node<E> left;
		Node<E> right;

		Node(Node<E> parent, E element, Node<E> prev, Node<E> next, Node<E> left, Node<E> right) {
			this.parent = parent;
			this.item = element;
			this.prev = prev;
			this.next = next;
			this.left = left;
			this.right = right;
		}
	}
}