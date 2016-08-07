package com.javarush.test.level17.lesson10.home01;

import java.util.*;

/* Общий список
1. Изменить класс Solution так, чтобы он стал списком. (Необходимо реализовать интерфейс java.util.List).
2. Список Solution должен работать только с целыми числами Long.
3. Воспользуйтесь полем original.
4. Список будет использоваться нитями, поэтому позаботьтесь, чтобы все методы были синхронизированы.
*/

public class Solution implements List<Long> {
	private ArrayList<Long> original = new ArrayList<>();

	@Override
	public int size() {
		return original.size();
	}

	@Override
	public boolean isEmpty() {
		return original.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return original.contains(o);
	}

	@Override
	public Iterator<Long> iterator() {
		return original.iterator();
	}

	@Override
	public Object[] toArray() {
		return original.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return original.toArray(a);
	}

	@Override
	public boolean add(Long aLong) {
		return original.add(aLong);
	}

	@Override
	public boolean remove(Object o) {
		return original.remove(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return original.containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends Long> c) {
		return original.addAll(c);
	}

	@Override
	public boolean addAll(int index, Collection<? extends Long> c) {
		return original.addAll(index, c);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return original.remove(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return original.retainAll(c);
	}

	@Override
	public void clear() {
		original.clear();
	}

	@Override
	public Long get(int index) {
		return original.get(index);
	}

	@Override
	public Long set(int index, Long element) {
		return original.set(index, element);
	}

	@Override
	public void add(int index, Long element) {
		original.add(index, element);
	}

	@Override
	public Long remove(int index) {
		return original.remove(index);
	}

	@Override
	public int indexOf(Object o) {
		return original.indexOf(o);
	}

	@Override
	public int lastIndexOf(Object o) {
		return original.lastIndexOf(o);
	}

	@Override
	public ListIterator<Long> listIterator() {
		return original.listIterator();
	}

	@Override
	public ListIterator<Long> listIterator(int index) {
		return original.listIterator(index);
	}

	@Override
	public List<Long> subList(int fromIndex, int toIndex) {
		return original.subList(fromIndex, toIndex);
	}
}