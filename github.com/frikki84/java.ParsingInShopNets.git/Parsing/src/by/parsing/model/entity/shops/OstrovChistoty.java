package by.parsing.model.entity.shops;

import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import by.parsing.model.entity.request.Request;
import by.parsing.model.entity.result.ParsingShopResult;
import by.parsing.model.logic.paginator.Paginator;
import by.parsing.model.logic.stringCorrect.StringCorrect;

public class OstrovChistoty extends ShopNet {
	public static final String OCH_SHOP_NAME = "Остров Чистоты";

	public static final String OCH_MAIN_URL = "https://ostrov-shop.by";

	public static final String OCH_URL_START = "https://ostrov-shop.by/catalog/?PAGEN_2=";
	public static final String OCH_URL_FINISH = "&q=";

	public static final String OCH_ITEM_COMMON = "catalog_item_wrapp";

	public static final String NUMBER_OF_FIRST_PAGE_OF_SEACH = "1";

	public OstrovChistoty() {
		super.setUrlStart(OCH_URL_START);
		super.setUrlFinish(OCH_URL_FINISH);
		super.setShopName(OCH_SHOP_NAME);
		super.setMainUrl(OCH_MAIN_URL);
		super.setItemCommon(OCH_ITEM_COMMON);

	}

	@Override
	public String toString() {
		return "OstrovChistoty {}";
	}

	@Override
	public ArrayList<ParsingShopResult> searchProduct(Request request) {
		ArrayList<ParsingShopResult> container = new ArrayList<ParsingShopResult>();

		String urlRequest = getUrlStart() + NUMBER_OF_FIRST_PAGE_OF_SEACH + getUrlFinish() + request.getRequest();

		try {
			//find number of search pages found
			int lastPage = Paginator.findResultsFromAllSearchPages(urlRequest, "",
					"div[class = module-pagination] > span[class = nums] > a");

			for (int i = 1; i <= lastPage; i++) {

				// request for each page with results for search in the shop
				String pagesWithResualtsOfSearch = getUrlStart() + i + getUrlFinish() + request.getRequest();
				// search elements on each page of search
				Document docEachPage = Jsoup.connect(pagesWithResualtsOfSearch).get();

				Elements elements = docEachPage.select("div[class = " + getItemCommon() + "]");

				String name;
				String price;
				Double doublePrice;
				String image;
				String link;

				for (Element element : elements) {
					name = element.select("img").attr("title");

					name = StringCorrect.stringCorrectForParsing(name);

					image = getMainUrl() + element.select("img").attr("src");

					link = getMainUrl() + element.select("a").attr("href");

					price = element.select("div[class = price]").text();
					price = StringCorrect.priceRubCorrection(price);
					doublePrice = new Double(price);

					ParsingShopResult result = new ParsingShopResult(name, doublePrice, image, link, OCH_SHOP_NAME);

					container.add(result);

				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return  container;
	}

}