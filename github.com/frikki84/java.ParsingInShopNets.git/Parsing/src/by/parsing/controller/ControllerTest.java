package by.parsing.controller;

import java.util.ArrayList;
import java.util.LinkedList;

import by.parsing.model.entity.request.Request;
import by.parsing.model.entity.result.FinalResultEntity;
import by.parsing.model.entity.result.ParsingShopResult;
import by.parsing.model.entity.shops.Edostavka;
import by.parsing.model.entity.shops.Hypermall;
import by.parsing.model.entity.shops.OstrovChistoty;
import by.parsing.model.entity.shops.Oz;
import by.parsing.model.entity.shops.ShopList;
import by.parsing.model.logic.createResultList.MainResultListCreation;

public class ControllerTest {
	public static void main(String[] args) {
		
			
		OstrovChistoty chistoty = new OstrovChistoty();
		Edostavka edostavka = new Edostavka();
		Hypermall hypermall = new Hypermall();
		Oz oz = new Oz();
		
		
		ShopList shopList = new ShopList();
		shopList.addShopNetInList(chistoty);
		shopList.addShopNetInList(edostavka);
		shopList.addShopNetInList(hypermall);
		shopList.addShopNetInList(oz);

		
		Request request = new Request("colgate elmex");
		LinkedList<FinalResultEntity> finalList = new LinkedList<>();
		
		finalList = MainResultListCreation.createFinalList(shopList, request);
		System.out.println(finalList);

		

	}
	

}
