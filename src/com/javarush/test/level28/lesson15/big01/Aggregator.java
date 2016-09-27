package com.javarush.test.level28.lesson15.big01;

import com.javarush.test.level28.lesson15.big01.model.Model;
import com.javarush.test.level28.lesson15.big01.view.HtmlView;

public class Aggregator {
	public static void main(String[] args) {
		HtmlView view = new HtmlView();
		Model model = new Model(view, null);
		Controller controller = new Controller(model);

		view.setController(controller);
		view.userCitySelectEmulationMethod();
	}
}