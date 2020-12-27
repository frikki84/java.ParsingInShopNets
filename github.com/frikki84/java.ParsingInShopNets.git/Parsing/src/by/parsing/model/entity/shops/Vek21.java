package by.parsing.model.entity.shops;

import java.util.ArrayList;

import by.parsing.model.entity.request.Request;
import by.parsing.model.entity.result.ParsingShopResult;

public class Vek21 extends ShopNet {
	public static final String VEK21_SHOP_NAME = "21 век";
	public static final String VEK21_MAIN_URL = "https://www.21vek.by/";
	public static final String VEK21_URL_START = "https://www.21vek.by/search/?term=";
	public static final String VEK21_URL_FINISH = "&sa=";
	public static final String VEK21_ITEM_COMMON = "result__item cr-result__simple   g-box_lseparator";
	
	public Vek21() {
		super.setShopName(VEK21_SHOP_NAME);
		super.setMainUrl(VEK21_MAIN_URL);
		super.setUrlStart(VEK21_URL_START);
		super.setUrlFinish(VEK21_URL_FINISH);
		super.setItemCommon(VEK21_ITEM_COMMON);
	}
	
	@Override
	public String toString() {
		return "Vek21 []";
	}


	public Vek21(ShopNet shopNet) {
		super.setShopName(shopNet.getShopName());
		super.setMainUrl(shopNet.getMainUrl());
		super.setUrlStart(shopNet.getUrlStart());
		super.setUrlFinish(shopNet.getUrlFinish());
		super.setItemCommon(shopNet.getItemCommon());
	}




	public Vek21(String shopName, String urlStart, String urlFinish, String mainUrl, String itemCommon) {
		super(shopName, urlStart, urlFinish, mainUrl, itemCommon);
		// TODO Auto-generated constructor stub
	}




	public Vek21(String shopName, String urlStart, String urlFinish, String mainUrl) {
		super(shopName, urlStart, urlFinish, mainUrl);
		// TODO Auto-generated constructor stub
	}




	public Vek21(String shopName, String urlStart, String urlFinish) {
		super(shopName, urlStart, urlFinish);
		// TODO Auto-generated constructor stub
	}




	@Override
	public ArrayList<ParsingShopResult> searchProduct(Request request) {
		// TODO Auto-generated method stub
		return null;
	}

}
