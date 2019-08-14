package by.parsing.model.entity.shops;

import java.util.HashMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import by.parsing.model.entity.request.Request;
import by.parsing.model.logic.stringCorrect.StringCorrect;

public class Mila extends ShopNet {
	public static final String MILA_URL_START = "https://mila.by/search/?q=";
	public static final String MILA_URL_FINISH = "&send=Y&r=Y";
	public static final String MILA_SEARCH_ITEM_COMMON = "tabloid";
	public static final String MILA_SEARCH_ITEM_NAME = "middle";
	public static final String MILA_SEARCH_ITEM_PRICE = "price-left";
	public static final String MILA_SEARCH_ITEM_PRICE_FOR_SALE = "price";
	public static final String MILA_SEARCH_ITEM_PRICE_CENTS = "sup";
	public static final String MILA_SHOP_NAME = "Мила";

	public static final String MILA_SEARCH_ITEM_COMMON_ID_FOR_ONE_ITEM = "tableContainer";
	public static final String MILA_SEARCH_ITEM_NAME_FOR_ONE_ITEM = "short-desc";
	public static final String MILA_SEARCH_ITEM_PRICE_FOR_ONE_ITEM = "value";
	// public static final String MILA_HREF_FOR_PRODUCT = "href";

	private String milaSearchItemRficeForSale;
	private String milaSearchItenPriceCents;
	private String milaSearchItemCommonIdForOneProduct;
	private String milaSearchItemNameForOneProduct;
	private String milaSearchItemPriceForOneProduct;

	public Mila() {
		super.setUrlStart(MILA_URL_START);
		super.setUrlFinish(MILA_URL_FINISH);
		super.setSearchItemCommon(MILA_SEARCH_ITEM_COMMON);
		super.setSearchItemName(MILA_SEARCH_ITEM_NAME);
		super.setSearchItemPrice(MILA_SEARCH_ITEM_PRICE);
		super.setShopName(MILA_SHOP_NAME);
		milaSearchItemRficeForSale = MILA_SEARCH_ITEM_PRICE_FOR_SALE;
		milaSearchItenPriceCents = MILA_SEARCH_ITEM_PRICE_CENTS;
		milaSearchItemCommonIdForOneProduct = MILA_SEARCH_ITEM_COMMON_ID_FOR_ONE_ITEM;
		milaSearchItemNameForOneProduct = MILA_SEARCH_ITEM_NAME_FOR_ONE_ITEM;
		milaSearchItemPriceForOneProduct = MILA_SEARCH_ITEM_PRICE_FOR_ONE_ITEM;
	}

	

	public String getMilaSearchItemRficeForSale() {
		return milaSearchItemRficeForSale;
	}

	public void setMilaSearchItemRficeForSale(String milaSearchItemRficeForSale) {
		this.milaSearchItemRficeForSale = milaSearchItemRficeForSale;
	}

	public String getMilaSearchItenPriceCents() {
		return milaSearchItenPriceCents;
	}

	public void setMilaSearchItenPriceCents(String milaSearchItenPriceCents) {
		this.milaSearchItenPriceCents = milaSearchItenPriceCents;
	}

	public String getMilaSearchItemCommonIdForOneProduct() {
		return milaSearchItemCommonIdForOneProduct;
	}

	public void setMilaSearchItemCommonIdForOneProduct(String milaSearchItemCommonIdForOneProduct) {
		this.milaSearchItemCommonIdForOneProduct = milaSearchItemCommonIdForOneProduct;
	}

	public String getMilaSearchItemNameForOneProduct() {
		return milaSearchItemNameForOneProduct;
	}

	public void setMilaSearchItemNameForOneProduct(String milaSearchItemNameForOneProduct) {
		this.milaSearchItemNameForOneProduct = milaSearchItemNameForOneProduct;
	}

	public String getMilaSearchItemPriceForOneProduct() {
		return milaSearchItemPriceForOneProduct;
	}

	public void setMilaSearchItemPriceForOneProduct(String milaSearchItemPriceForOneProduct) {
		this.milaSearchItemPriceForOneProduct = milaSearchItemPriceForOneProduct;
	}

	@Override
	public String toString() {
		return "Mila [milaSearchItenPriceCents=" + milaSearchItenPriceCents + ", milaSearchItemCommonIdForOneProduct="
				+ milaSearchItemCommonIdForOneProduct + ", milaSearchItemNameForOneProduct="
				+ milaSearchItemNameForOneProduct + ", milaSearchItemPriceForOneProduct="
				+ milaSearchItemPriceForOneProduct + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((milaSearchItemCommonIdForOneProduct == null) ? 0 : milaSearchItemCommonIdForOneProduct.hashCode());
		result = prime * result
				+ ((milaSearchItemNameForOneProduct == null) ? 0 : milaSearchItemNameForOneProduct.hashCode());
		result = prime * result
				+ ((milaSearchItemPriceForOneProduct == null) ? 0 : milaSearchItemPriceForOneProduct.hashCode());
		result = prime * result + ((milaSearchItenPriceCents == null) ? 0 : milaSearchItenPriceCents.hashCode());
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
		Mila other = (Mila) obj;
		if (milaSearchItemCommonIdForOneProduct == null) {
			if (other.milaSearchItemCommonIdForOneProduct != null)
				return false;
		} else if (!milaSearchItemCommonIdForOneProduct.equals(other.milaSearchItemCommonIdForOneProduct))
			return false;
		if (milaSearchItemNameForOneProduct == null) {
			if (other.milaSearchItemNameForOneProduct != null)
				return false;
		} else if (!milaSearchItemNameForOneProduct.equals(other.milaSearchItemNameForOneProduct))
			return false;
		if (milaSearchItemPriceForOneProduct == null) {
			if (other.milaSearchItemPriceForOneProduct != null)
				return false;
		} else if (!milaSearchItemPriceForOneProduct.equals(other.milaSearchItemPriceForOneProduct))
			return false;
		if (milaSearchItenPriceCents == null) {
			if (other.milaSearchItenPriceCents != null)
				return false;
		} else if (!milaSearchItenPriceCents.equals(other.milaSearchItenPriceCents))
			return false;
		return true;
	}
	
	@Override
	public HashMap<String, String> searchProduct(Request request) {
		HashMap<String, String> responseContainer = new HashMap<String, String>();
		String urlRequest = getUrlStart() + request.getRequest() + getUrlFinish();
		try {
			Document document = Jsoup.connect(urlRequest).get();
			String name = "No product";
			String price = " - ";
			Elements elements = document.getElementsByClass(getSearchItemCommon());
			// if (elements == null) {

			for (Element element : elements) {
				name = element.getElementsByClass(getSearchItemName()).text();
				name = StringCorrect.stringCorrectForParsing(name);

				Elements elems = element.getElementsByClass(getSearchItemPrice());
				for (Element priceElement : elems) {
					String cents = priceElement.getElementsByTag(getMilaSearchItenPriceCents()).text();
					String rubls = priceElement.getElementsByClass(getSearchItemPrice()).text().replace(cents, "")
							.replace(" Цена по карте «Мила»", "");
					price = rubls + "." + cents;
				}

				if (price == " - ") {
					String cents = element.getElementsByTag(getMilaSearchItenPriceCents()).text();
					price = element.getElementsByClass(getMilaSearchItemRficeForSale()).text().replace(cents, "") + "."
							+ cents.replace("руб.", "");
				}

				if (name == "No product") {
					name = document.getElementsByClass("short-desc").text();
					System.out.println("iuhgi");
					price = document.getElementsByClass("value").text();

				}

				responseContainer.put(name, price);
			}

		}

		catch (Exception e) {
			// TODO: handle exception
		}
		return responseContainer;
	}

}
