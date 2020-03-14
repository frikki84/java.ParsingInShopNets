package by.parsing.controller;

import java.util.ArrayList;
import java.util.LinkedList;

import by.parsing.model.entity.request.Request;
import by.parsing.model.entity.result.FinalResultEntity;
import by.parsing.model.entity.result.ParsingShopResult;
import by.parsing.model.entity.shops.Edostavka;
import by.parsing.model.entity.shops.OstrovChistoty;
import by.parsing.model.entity.shops.ShopList;
import by.parsing.model.logic.createResultList.MainResultListCreation;

public class ControllerTest {
	public static void main(String[] args) {
		
			
		OstrovChistoty chistoty = new OstrovChistoty();
		Edostavka edostavka = new Edostavka();
		Request request = new Request("Colgate White");
		
		ShopList shopList = new ShopList();
		shopList.addShopNetInList(chistoty);
		shopList.addShopNetInList(edostavka);

		LinkedList<FinalResultEntity> finalList = new LinkedList<>();
		
		finalList = MainResultListCreation.createFinalList(shopList, request);

		
		
		
		
		/*
		 * long finish = System.currentTimeMillis(); long timeConsumedMillis = finish -
		 * start; System.out.println("Time for code: " + timeConsumedMillis);
		 */
	}
	

}
