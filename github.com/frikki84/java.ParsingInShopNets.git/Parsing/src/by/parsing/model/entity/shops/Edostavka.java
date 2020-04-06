package by.parsing.model.entity.shops;

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import by.parsing.model.entity.request.Request;
import by.parsing.model.entity.result.ParsingShopResult;
import by.parsing.model.logic.stringCorrect.StringCorrect;

public class Edostavka extends ShopNet {
	public static final String EDOSTAVKA_SHOP_NAME = "Е-доставка";
	public static final String EDOSTAVKA_MAIN_URL = "https://e-dostavka.by";
	public static final String EDOSTAVKA_URL_START = "https://e-dostavka.by/search/?searchtext=";
	public static final String EDOSTAVKA_URL_FINISH = "";
	public static final String EDOSTAVKA_ITEM_COMMON = "form_wrapper";

	public Edostavka() {
		super.setUrlStart(EDOSTAVKA_URL_START);
		super.setUrlFinish(EDOSTAVKA_URL_FINISH);
		super.setShopName(EDOSTAVKA_SHOP_NAME);
		super.setMainUrl(EDOSTAVKA_MAIN_URL);
		super.setItemCommon(EDOSTAVKA_ITEM_COMMON);
	}

	@Override
	public String toString() {
		return "Edostavka{}";
	}

	@Override
	public ArrayList<ParsingShopResult> searchProduct(Request request) {
		ArrayList<ParsingShopResult> container = new ArrayList<>();

		String urlRequest = getUrlStart() + request.getRequest() + getUrlFinish();
		try {
			Document document = Jsoup.connect(urlRequest).get();

			Elements elements = document.select("div[class = " + getItemCommon() + "]");

			String name = "";
			Double price;
			String image = "";
			String link = "";

			for (Element element : elements) {
				name = element.select("div[class = img] > a > img").attr("title");

				name = StringCorrect.stringCorrectForParsing(name);

				image = element.select("div[class = img] > a > img").attr("src");

				link = element.select("div[class = img] > a").attr("href");

				String priceRub = element.select("div[class = price]").text();
				priceRub = StringCorrect.priceRubCorrection(priceRub);
				String priceCent = element.select("span[class = cent]").text();
				priceCent = StringCorrect.priceCentCorrection(priceCent);

				String middlePrice = priceRub + "." + priceCent;
				price = new Double(middlePrice);
				ParsingShopResult result = new ParsingShopResult(name, price, image, link, getShopName());
				
				container.add(result);

				}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return container;
	}
}