package by.parsing.model.entity.shops;

import java.util.ArrayList;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import by.parsing.model.entity.request.Request;
import by.parsing.model.logic.stringCorrect.StringCorrect;

public class Mila extends ShopNet {
	public static final String MILA_SHOP_NAME = "Мила";

	public static final String MILA_URL_START = "https://mila.by/search/?q=";
	public static final String MILA_URL_FINISH = "&send=Y&r=Y";
	public static final String MILA_MAIN_URL = "mila.by";

	public static final String MILA_ITEM_COMMON = "tabloid";

	public Mila() {
		super.setUrlStart(MILA_URL_START);
		super.setUrlFinish(MILA_URL_FINISH);
		super.setItemCommon(MILA_ITEM_COMMON);
		super.setShopName(MILA_SHOP_NAME);
		super.setMainUrl(MILA_MAIN_URL);
	}
	
	

	@Override
	public String toString() {
		return "Mila [toString()=" + super.toString() + ", hashCode()=" + hashCode() + ", getShopName()="
				+ getShopName() + ", getMainUrl()=" + getMainUrl() + ", getUrlStart()=" + getUrlStart()
				+ ", getUrlFinish()=" + getUrlFinish() + ", getItemCommon()=" + getItemCommon() + ", getClass()="
				+ getClass() + "]";
	}



	@Override
	public ArrayList<ArrayList<String>> searchProduct(Request request) {
		ArrayList<String> responseContainer = new ArrayList<>();
		ArrayList<ArrayList<String>> container = new ArrayList<ArrayList<String>>();

		String urlRequest = getUrlStart() + request.getRequest() + getUrlFinish();
		try {
			Document document = Jsoup.connect(urlRequest).get();
			
			Elements elements = document.select("div[class = " + getItemCommon() + "]");
			
			String name;
			String price ;
			String image;
			String link;

			for (Element element : elements) {
				name = element.select("img").attr("title");
				name = StringCorrect.stringCorrectForParsing(name);

				image = getMainUrl() + element.select("img").attr("src");

				link = getMainUrl() + element.select("a").attr("href");
				
				String cents = element.select("div[class = price-left] > span[class = pr] > sup").text();

				price = element.select("div[class = price-left] > span[class = pr]").text();
				price = price.replace(cents, "") + "." + cents;
				
				if (price.equals(".")) {
				
					String cen = element.select("div[class = price-block] > a[class = price] > sup").text();
					
					price = element.select("div[class = price-block] > a[class = price]").text();
					
					price = (price.replace(cen, "") + "." + cen).replace("руб.", "");
					
				}



				responseContainer.add(name);
				responseContainer.add(price);
				responseContainer.add(image);
				responseContainer.add(link);

				ArrayList<String> mArr = new ArrayList<String>();
				mArr = (ArrayList<String>) responseContainer.clone();

				container.add(mArr);

				responseContainer.clear();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return container;
	}


	

}