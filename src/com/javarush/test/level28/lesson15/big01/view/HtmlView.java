package com.javarush.test.level28.lesson15.big01.view;

import com.javarush.test.level28.lesson15.big01.Controller;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;

import java.util.List;

public class HtmlView implements View {
	private final String filePath = "./src/" + this.getClass().getPackage().getName().replace(".", "/") + "/vacancies.html";
	private Controller controller;

	@Override
	public void update(List<Vacancy> vacancies) {
		try {
			updateFile(getUpdatedFileContent(vacancies));
		}
		catch (Exception e) {
			e.getStackTrace();
		}
	}

	@Override
	public void setController(Controller controller) {
		this.controller = controller;
	}

	public void userCitySelectEmulationMethod() {
		controller.onCitySelect("Odessa");
	}

	private String getUpdatedFileContent(List<Vacancy> vacancies) {
		return null;
	}

	private void updateFile(String doc) {}
}
