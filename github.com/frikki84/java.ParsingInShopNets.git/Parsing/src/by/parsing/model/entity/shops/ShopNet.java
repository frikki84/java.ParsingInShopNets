package by.parsing.model.entity.shops;

import java.util.HashMap;

import org.jsoup.select.Elements;

import by.parsing.model.entity.request.Request;

public abstract class ShopNet {
	private String shopName;
	private String urlStart;
	private String urlFinish;
	private String searchItemCommon;
	private String searchItemName;
	private String searchItemPrice;


	public ShopNet() {

	}

	public ShopNet(String shopName, String urlStart, String urlFinish) {
		this.shopName = shopName;
		this.urlStart = urlStart;
		this.urlFinish = urlFinish;
	}

	public ShopNet(String shopName,String urlStart, String urlFinish, String searchItemCommon) {
		this.shopName = shopName;
		this.urlStart = urlStart;
		this.urlFinish = urlFinish;
		this.searchItemCommon = searchItemCommon;
	}

	public ShopNet(String shopName,String urlStart, String urlFinish, String searchItemCommon, String searchItemName) {
		this.shopName = shopName;
		this.urlStart = urlStart;
		this.urlFinish = urlFinish;
		this.searchItemCommon = searchItemCommon;
		this.searchItemName = searchItemName;
	}

	public ShopNet(String shopName, String urlStart, String urlFinish, String searchItemCommon, String searchItemName,
			String searchItemPrice) {
		this.shopName = shopName;
		this.urlStart = urlStart;
		this.urlFinish = urlFinish;
		this.searchItemCommon = searchItemCommon;
		this.searchItemName = searchItemName;
		this.searchItemPrice = searchItemPrice;
	}

	public ShopNet(ShopNet shopNet) {
		this.shopName = shopNet.shopName;
		this.urlStart = shopNet.urlStart;
		this.urlFinish = shopNet.urlFinish;
		this.searchItemCommon = shopNet.searchItemCommon;
		this.searchItemName = shopNet.searchItemName;
		this.searchItemPrice = shopNet.searchItemPrice;
		
	}

	public String getShopName() {
		return shopName;
	}
	
	public String getUrlStart() {
		return urlStart;
	}

	public String getUrlFinish() {
		return urlFinish;
	}

	public String getSearchItemPrice() {
		return searchItemPrice;
	}

	public String getSearchItemCommon() {
		return searchItemCommon;
	}

	public String getSearchItemName() {
		return searchItemName;
	}
	
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	
	public void setUrlStart(String urlStart) {
		this.urlStart = urlStart;
	}

	public void setUrlFinish(String urlFinish) {
		this.urlFinish = urlFinish;
	}

	public void setSearchItemCommon(String searchItemCommon) {
		this.searchItemCommon = searchItemCommon;
	}

	public void setSearchItemName(String searchItemName) {
		this.searchItemName = searchItemName;
	}

	public void setSearchItemPrice(String searchItemPrice) {
		this.searchItemPrice = searchItemPrice;
	}
	
		
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((searchItemCommon == null) ? 0 : searchItemCommon.hashCode());
		result = prime * result + ((searchItemName == null) ? 0 : searchItemName.hashCode());
		result = prime * result + ((searchItemPrice == null) ? 0 : searchItemPrice.hashCode());
		result = prime * result + ((shopName == null) ? 0 : shopName.hashCode());
		result = prime * result + ((urlFinish == null) ? 0 : urlFinish.hashCode());
		result = prime * result + ((urlStart == null) ? 0 : urlStart.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShopNet other = (ShopNet) obj;
		if (searchItemCommon == null) {
			if (other.searchItemCommon != null)
				return false;
		} else if (!searchItemCommon.equals(other.searchItemCommon))
			return false;
		if (searchItemName == null) {
			if (other.searchItemName != null)
				return false;
		} else if (!searchItemName.equals(other.searchItemName))
			return false;
		if (searchItemPrice == null) {
			if (other.searchItemPrice != null)
				return false;
		} else if (!searchItemPrice.equals(other.searchItemPrice))
			return false;
		if (shopName == null) {
			if (other.shopName != null)
				return false;
		} else if (!shopName.equals(other.shopName))
			return false;
		if (urlFinish == null) {
			if (other.urlFinish != null)
				return false;
		} else if (!urlFinish.equals(other.urlFinish))
			return false;
		if (urlStart == null) {
			if (other.urlStart != null)
				return false;
		} else if (!urlStart.equals(other.urlStart))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "ShopNet [shopName=" + shopName + ", urlStart=" + urlStart + ", urlFinish=" + urlFinish
				+ ", searchItemCommon=" + searchItemCommon + ", searchItemName=" + searchItemName + ", searchItemPrice="
				+ searchItemPrice + "]";
	}

	public abstract HashMap <String, String> searchProduct(Request request);

}
