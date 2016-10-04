package com.javarush.test.level28.lesson15.big01;

import com.javarush.test.level28.lesson15.big01.model.HHStrategy;
import com.javarush.test.level28.lesson15.big01.model.Model;
import com.javarush.test.level28.lesson15.big01.model.MoikrugStrategy;
import com.javarush.test.level28.lesson15.big01.model.Provider;
import com.javarush.test.level28.lesson15.big01.view.HtmlView;
import com.javarush.test.level28.lesson15.big01.view.SwingView;

public class Aggregator {
	public static void main(String[] args) {
//		HtmlView view = new HtmlView();
		SwingView view = new SwingView();
		Model model = new Model(view, new Provider[] {new Provider(new HHStrategy()), new Provider(new MoikrugStrategy())});
		Controller controller = new Controller(model);

		view.setController(controller);
		view.userCitySelectEmulationMethod();
	}
}