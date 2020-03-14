package by.parsing.model.entity.shops;

import java.util.ArrayList;
import java.util.HashMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import by.parsing.model.entity.request.Request;
import by.parsing.model.entity.result.ParsingShopResult;
import by.parsing.model.logic.stringCorrect.StringCorrect;

public class Hypermall extends ShopNet {
	public static final String HYPERMALL_SHOP_NAME = "Гипермолл";
	public static final String HYPERMALL_MAIN_URL = "https://gipermall.by";
	public static final String HYPERMALL_URL_START = "https://gipermall.by/search/?searchtext=";
	public static final String HYPERMALL_URL_FINISH = "";
	public static final String HYPERMALL_ITEM_COMMON = "form_wrapper";

	public Hypermall() {
		super.setUrlStart(HYPERMALL_URL_START);
		super.setUrlFinish(HYPERMALL_URL_FINISH);
		super.setShopName(HYPERMALL_SHOP_NAME);
		super.setMainUrl(HYPERMALL_MAIN_URL);
		super.setItemCommon(HYPERMALL_ITEM_COMMON);
	}

	@Override
	public String toString() {
		return "Hypermall{}";
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
				String midPrice = priceRub + "." + priceCent;
				price = new Double(midPrice);
				ParsingShopResult result = new ParsingShopResult(name, price, image, link, HYPERMALL_SHOP_NAME);

				container.add(result);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return container;
	}

}
