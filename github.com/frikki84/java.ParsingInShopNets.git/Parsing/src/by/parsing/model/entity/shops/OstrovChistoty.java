package by.parsing.model.entity.shops;

import java.util.HashMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import by.parsing.model.entity.request.Request;
import by.parsing.model.logic.stringCorrect.StringCorrect;

public class OstrovChistoty extends ShopNet {
	public static final String OCH_SHOP_NAME = "Остров Чистоты";
	public static final String OCH_URL_START = "https://ostrov-shop.by/catalog/?q=";
	public static final String OCH_URL_FINISH = "&how=";
	public static final String OCH_SEARCH_ITEM_COMMON = "item_wrap";
	public static final String OCH_SEARCH_ITEM_NAME = "item-title";
	public static final String OCH_SEARCH_ITEM_PRICE = "_price";
	public static final String OCH_SEARCH_ITEM_PRICE_SALE = "cost prices clearfix";

	private String searchItemPriceSale;
	
	public OstrovChistoty() {
		super.setShopName(OCH_SHOP_NAME);
		super.setUrlStart(OCH_URL_START);
		super.setUrlFinish(OCH_URL_FINISH);
		super.setSearchItemCommon(OCH_SEARCH_ITEM_COMMON);
		super.setSearchItemName(OCH_SEARCH_ITEM_NAME);
		super.setSearchItemPrice(OCH_SEARCH_ITEM_PRICE);
		this.searchItemPriceSale = OCH_SEARCH_ITEM_PRICE_SALE;

	}
	
	public String getSearchItemPriceSale() {
		return searchItemPriceSale;
	}
	
	public void setSearchItemPriceSale(String searchItemPriceSale) {
		this.searchItemPriceSale = searchItemPriceSale;
	}
	
	

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((searchItemPriceSale == null) ? 0 : searchItemPriceSale.hashCode());
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
		OstrovChistoty other = (OstrovChistoty) obj;
		if (searchItemPriceSale == null) {
			if (other.searchItemPriceSale != null)
				return false;
		} else if (!searchItemPriceSale.equals(other.searchItemPriceSale))
			return false;
		return true;
	}

	
	
	@Override
	public String toString() {
		return "OstrovChistoty [searchItemPriceSale=" + searchItemPriceSale + "]";
	}

	@Override
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

				Element priceMid = element.getElementById(getSearchItemPrice());
				if (priceMid != null) {
					price = priceMid.text();
				} else {
					price = element.getElementsByClass(getSearchItemPriceSale()).text();
				}

				responseContainer.put(name, StringCorrect.priceRubCorrection(price));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return responseContainer;
	}
	
	

	

}
