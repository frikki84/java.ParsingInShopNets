package by.parsing.model.entity.shops;

import java.util.ArrayList;

import by.parsing.model.entity.request.Request;
import by.parsing.model.entity.result.ParsingShopResult;

public class HitDostavka extends Edostavka {
	public static final String HIT_SHOP_NAME = "’ËÚ";
	public static final String HIT_MAIN_URL = "https://hit.e-dostavka.by/";
	public static final String HIT_URL_START = "https://hit.e-dostavka.by//search/?searchtext=";
	
	
	public HitDostavka() {
		super();
		super.setUrlStart(HIT_URL_START);
		super.setShopName(HIT_SHOP_NAME);
		super.setMainUrl(HIT_MAIN_URL);
	}


	@Override
	public String toString() {
		return "HitDostavka [getShopName()="+ getShopName() + "]";
	}
	
	@Override
	public ArrayList<ParsingShopResult> searchProduct(Request request) {
		return super.searchProduct(request);
	}
	
	
	
	
	
	
	
}
