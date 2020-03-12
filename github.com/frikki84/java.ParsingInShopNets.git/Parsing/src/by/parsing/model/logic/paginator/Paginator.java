package by.parsing.model.logic.paginator;

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Paginator {

	public static final int FIRST_LAST_SEARCH_PAGE = 1;

	public static int findResultsFromAllSearchPages(String urlForParsing, String lastSymbol, String paginatorTegName) {
		int lastPage = 0;

		try {

			Document document = Jsoup.connect(urlForParsing).get();					
					
			// search all pages with results for search in the shop
			Elements searchPages = document.select(paginatorTegName);

			// ������� ���������� ��� ����������� ��������� �������� ����������� ������ �
			// ��������
			String pagesWithResualtsOfSearch = "";

			// ������� ��������� ��� �������� ���� � ������� ������� ������
			ArrayList<String> containerForPages = new ArrayList<>();

			// last number for pages count

			if (searchPages.text().equals("")) {
				lastPage = FIRST_LAST_SEARCH_PAGE;

			} else {

				for (Element page : searchPages) {
					String eachPage = page.text();
					containerForPages.add(eachPage);
				}

				int length = containerForPages.size();
				String lastPoint = "";

				// find last page number
				if (lastSymbol.equals("")) {
					lastPoint = containerForPages.get(length - 1);
				} else {
					lastPoint = containerForPages.get(length - 2);
				}
				lastPage += Integer.parseInt(lastPoint);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return lastPage;
	}

}