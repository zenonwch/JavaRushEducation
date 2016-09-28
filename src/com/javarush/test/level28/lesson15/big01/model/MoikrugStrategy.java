package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MoikrugStrategy implements Strategy {
		private static final String URL_FORMAT = "https://moikrug.ru/vacancies?q=java+%s&page=%d";
		private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.116 Safari/537.36";
		private static final String REFERRER = "https://moikrug.ru/";
		private static final int TIMEOUT = 5 * 1000;

		@Override
		public List<Vacancy> getVacancies(String searchString) {
			List<Vacancy> vacancies = new ArrayList<>();
			Document doc;
			Elements els;
			int page = 0;

			while (true) {
				try {
					doc = getDocument(searchString, page++);
					els = doc.getElementsByClass("job");
					if (els.isEmpty())
						break;
					for (Element el : els) {
						Elements elSalary = el.select(".salary");
						Vacancy vacancy = new Vacancy();
						vacancy.setTitle(el.select(".title").first().text());
						vacancy.setSalary(elSalary.size() == 0 ? "" : elSalary.first().text());
						Elements elCity = el.select(".location");
						vacancy.setCity(elCity.size() == 0 ? "" : elCity.first().text());
						vacancy.setCompanyName(el.select(".company_name > a").first().text());
						vacancy.setSiteName(REFERRER);
						vacancy.setUrl("https://moikrug.ru" + el.select(".title > a").first().attr("href"));
								vacancies.add(vacancy);
					}
				}
				catch (IOException ignored) {
				}
			}
			return vacancies;
		}

	protected Document getDocument(String searchString, int page) throws IOException {
		return Jsoup.connect(String.format(URL_FORMAT,  searchString, page))
				.userAgent(USER_AGENT)
				.referrer(REFERRER)
				.get();
	}
}
