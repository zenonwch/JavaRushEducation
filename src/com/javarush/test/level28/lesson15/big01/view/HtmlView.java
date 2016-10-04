package com.javarush.test.level28.lesson15.big01.view;

import com.javarush.test.level28.lesson15.big01.Controller;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class HtmlView implements View {
	private final String filePath = "."+ File.separator + "src" + File.separator + this.getClass().getPackage().getName().replace(".", File.separator) + File.separator + "vacancies.html";
	private Controller controller;
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd MM yyyy", new Locale("ru"));

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
		Collections.sort(vacancies, new Comparator<Vacancy>() {
			public int compare(Vacancy o1, Vacancy o2) {
				if (o1.getDate() == null || o2.getDate() == null)
					return 0;
				return o2.getDate().compareTo(o1.getDate());
			}
		});

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
				String date = vac.getDate() == null ? "" : dateFormat.format(vac.getDate());
				copyTemplateEl.getElementsByClass("creationDate").get(0).text(date);
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
