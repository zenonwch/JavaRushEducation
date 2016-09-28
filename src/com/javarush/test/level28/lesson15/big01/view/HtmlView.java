package com.javarush.test.level28.lesson15.big01.view;

import com.javarush.test.level28.lesson15.big01.Controller;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class HtmlView implements View {
	private final String filePath = "."+ File.separator + "src" + File.separator + this.getClass().getPackage().getName().replace(".", File.separator) + File.separator + "vacancies.html";
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
		String content = "";
		try {
			Document doc = getDocument();
			Element el = doc.getElementsByClass("template").get(0);

			Element templateEl = el.clone();
			templateEl.removeAttr("style");
			templateEl.removeClass("template");

			for (Element vacEl : doc.select("tr[class=vacancy]"))
				vacEl.remove();

			for (Vacancy vac : vacancies) {
				Element copyTemplateEl = templateEl.clone();
				copyTemplateEl.getElementsByClass("city").get(0).text(vac.getCity());
				copyTemplateEl.getElementsByClass("companyName").get(0).text(vac.getCompanyName());
				copyTemplateEl.getElementsByClass("salary").get(0).text(vac.getSalary());
				copyTemplateEl.getElementsByTag("a").get(0).text(vac.getTitle());
				copyTemplateEl.getElementsByTag("a").get(0).attr("href", vac.getUrl());
				el.before(copyTemplateEl.outerHtml());
			}

			content = doc.outerHtml();
		}
		catch (Exception e) {
			System.out.println("Some exception occurred");
		}
		return content;
	}

	private void updateFile(String doc) {
		File file = new File(filePath);
		try {
			FileWriter fw = new FileWriter(file);
			fw.write(doc);
			fw.close();
		}
		catch (IOException ignored) {
		}
	}

	protected Document getDocument() throws IOException {
		return Jsoup.parse(new File(filePath), "UTF-8");
	}
}
