package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.List;

public class HHStrategy implements Strategy {
	private static final String URL_FORMAT = "http://hh.ua/search/vacancy?text=java+%s&page=%d";
	private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.116 Safari/537.36";
	private static final String REFERRER = "https://hh.ua/search/vacancy?text=java+%D0%BA%D0%B8%D0%B5%D0%B2";
	private static final int TIMEOUT = 5 * 1000;

	@Override
	public List<Vacancy> getVacancies(String searchString) {
		Document doc;
		try {
			doc = Jsoup.connect(String.format(URL_FORMAT, searchString, 1))
					.userAgent(USER_AGENT)
					.referrer(REFERRER)
					.timeout(TIMEOUT)
					.get();
		}
		catch (IOException ignored) {}
		return null;
	}
}
