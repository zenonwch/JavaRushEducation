package com.javarush.test.level30.lesson04.home01;

import java.util.Objects;

//this class shows how to call other constructors using 'this'
public class ShareItem {
	public String description;
	public int itemId;

	public ShareItem() {
		this("Test Item", 0);
	}

	public ShareItem(String description) {
		this(description, 0);
	}

	public ShareItem(int itemId) {
		this("Test Item", itemId);
	}

	public ShareItem(String description, int itemId) {
		this.description = description;
		this.itemId = itemId;
	}

	public String getDescription() {
		return description;
	}

	public int getItemId() {
		return itemId;
	}

	@Override
	public String toString() {
		return "ShareItem{" +
				"description='" + description + '\'' +
				", itemId=" + itemId +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ShareItem shareItem = (ShareItem) o;
		return Objects.equals(itemId, shareItem.itemId) &&
				Objects.equals(description, shareItem.description);
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, itemId);
	}
}
