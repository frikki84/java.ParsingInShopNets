package by.parsing.model.entity.shops;

import java.util.HashMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import by.parsing.model.entity.request.Request;
import by.parsing.model.logic.stringCorrect.StringCorrect;

public class Hypermall extends ShopNet {
	public static final String HYPER_SHOP_NAME = "Гипермолл";
	public static final String HYPER_URL_START = "https://gipermall.by/search/?searchtext=";
	public static final String HYPER_URL_FINISH = "";
	public static final String HYPER_SEARCH_ITEM_COMMON = "form_wrapper";
	public static final String HYPER_SEARCH_ITEM_NAME = "fancy_ajax";
	public static final String HYPER_SEARCH_ITEM_PRICE = "price";
	public static final String HYPER_SEARCH_ITEM_PRICE_CENT = "cent";

	private String searchItemPriceCent;

	public Hypermall() {
		super.setShopName(HYPER_SHOP_NAME);
		super.setUrlStart(HYPER_URL_START);
		super.setUrlFinish(HYPER_URL_FINISH);
		super.setSearchItemCommon(HYPER_SEARCH_ITEM_COMMON);
		super.setSearchItemName(HYPER_SEARCH_ITEM_NAME);
		super.setSearchItemPrice(HYPER_SEARCH_ITEM_PRICE);
		this.searchItemPriceCent = HYPER_SEARCH_ITEM_PRICE_CENT;
	}

	public String getSearchItemPriceCent() {
		return searchItemPriceCent;
	}

	public void setSearchItemPriceCent(String searchItemPriceCent) {
		this.searchItemPriceCent = searchItemPriceCent;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((searchItemPriceCent == null) ? 0 : searchItemPriceCent.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hypermall other = (Hypermall) obj;
		if (searchItemPriceCent == null) {
			if (other.searchItemPriceCent != null)
				return false;
		} else if (!searchItemPriceCent.equals(other.searchItemPriceCent))
			return false;
		return true;
	}

	
	
	@Override
	public String toString() {
		return "Hypermall [searchItemPriceCent=" + searchItemPriceCent + "]";
	}

	public HashMap<String, String> searchProduct(Request request) {
		HashMap<String, String> responseContainer = new HashMap<String, String>();
		String urlRequest = getUrlStart() + request.getRequest() + getUrlFinish();
		try {
			Document document = Jsoup.connect(urlRequest).get();
			Elements elements = document.getElementsByClass(getSearchItemCommon());
			String name = "No product";
			String price = " - ";

			for (Element element : elements) {
				name = element.getElementsByClass(getSearchItemName()).text();
				name = StringCorrect.stringCorrectForParsing(name);

				price = StringCorrect.priceRubCorrection(element.getElementsByClass(getSearchItemPrice()).text())
						+ "." + StringCorrect
								.priceCentCorrection(element.getElementsByClass(getSearchItemPriceCent()).text());

				responseContainer.put(name, price);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return responseContainer;
	}
	
}
