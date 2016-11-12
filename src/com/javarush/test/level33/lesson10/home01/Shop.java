package com.javarush.test.level33.lesson10.home01;

import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class Shop {
	@XmlElementWrapper(name = "goods")
	public List<String> names = new ArrayList<>();
	public int count;
	public double profit;
	public List<String> secretData = new ArrayList<>();

	public Shop() {
	}

	@Override
	public String toString() {
		return "Shop {\n\t goods = " + names + ",\n\t count = " + count + ",\n\t profit = " + profit + ",\n\t secretData = " + secretData + "\n}";
	}
}
