package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HHStrategy implements Strategy {
	private static final String URL_FORMAT = "http://hh.ua/search/vacancy?text=java+%s&page=%d";
	private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.116 Safari/537.36";
	private static final String REFERRER = "https://hh.ua/";
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
				els = doc.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy");
				if (els.isEmpty())
					break;
				for (Element el : els) {
					Elements elSalary = el.select("[data-qa=vacancy-serp__vacancy-compensation]");
					Vacancy vacancy = new Vacancy();
					vacancy.setTitle(el.select("[data-qa=vacancy-serp__vacancy-title]").first().text());
					vacancy.setSalary(elSalary.size() == 0 ? "" : elSalary.first().text());
					vacancy.setCity(el.select("[data-qa=vacancy-serp__vacancy-address]").first().text());
					vacancy.setCompanyName(el.select("[data-qa=vacancy-serp__vacancy-employer]").first().text());
					vacancy.setSiteName(REFERRER);
					vacancy.setUrl(el.select("[data-qa=vacancy-serp__vacancy-title]").first().attr("href"));
					vacancies.add(vacancy);
				}
			}
			catch (IOException ignored) {
			}
		}
		return vacancies;
	}

	protected Document getDocument(String searchString, int page) throws IOException {
		return Jsoup.connect(String.format(URL_FORMAT, searchString, page))
				.userAgent(USER_AGENT)
				.referrer(REFERRER)
				.timeout(TIMEOUT)
				.get();
	}
}
