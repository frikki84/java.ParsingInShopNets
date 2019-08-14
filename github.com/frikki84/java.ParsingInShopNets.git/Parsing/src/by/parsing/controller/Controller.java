package by.parsing.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import by.parsing.model.entity.request.Request;
import by.parsing.model.entity.shops.Hypermall;
import by.parsing.model.entity.shops.Mila;
import by.parsing.model.entity.shops.OstrovChistoty;
import by.parsing.model.entity.shops.ShopList;
import by.parsing.model.entity.shops.ShopNet;
import by.parsing.model.logic.addElementsToHashMap.HashMapElementsAddition;
import by.parsing.model.logic.stringCorrect.StringCorrect;
import by.parsing.model.logic.structuresForComparison.CompareHashMap;
import by.parsing.model.logic.userInput.UserInput;
import by.parsing.model.logic.validation.Validation;
import by.parsing.view.ConsolePrinter;

public class Controller {
	public static void main(String[] args) {

		Hypermall hypermall = new Hypermall();

		OstrovChistoty chistoty = new OstrovChistoty();

		Mila mila = new Mila();

		ShopList list = new ShopList();
		list.addShopNetInList(chistoty);
		list.addShopNetInList(mila);
		list.addShopNetInList(hypermall);

		// string for creation request for parsing
		String listOfShops = "";
		int countOfShops = 0;
		for (ShopNet item : list.getShopList()) {
			listOfShops += item.getShopName();
			countOfShops += 1;
			if (countOfShops != list.getShopList().size()) {
				listOfShops += ", ";
			}
		}

		// take the user's request
		String askingForRequest = UserInput
				.inputString("Введите ваш запрос для поиска товара в торговых сетях " + listOfShops + ": ");

		// request verification
		askingForRequest = Validation.validateRequest(askingForRequest);

		Request request = new Request(askingForRequest);

		ConsolePrinter.print("Подождите, Ваш запрос обрабатывается.\n");

		// main HashMap to store all the information about product : [shopName : price]
		HashMap<String, ArrayList<HashMap<String, String>>> resultHashMap = new HashMap<String, ArrayList<HashMap<String, String>>>();

		// HashMap for comparison of products in different shops (one product can have
		// different names in different shops)
		HashMap<String, ArrayList<String>> hashmapForEquals = new HashMap<String, ArrayList<String>>();

		// search product in 1 shop
		HashMap<String, String> result = list.getShopList().get(0).searchProduct(request);
//add information to resultHashMap
		resultHashMap = HashMapElementsAddition.addElementsToMainResultHashMap(result, resultHashMap, list);

		// add information to hashmapForEquals
		CompareHashMap.divideResultToStringIntoPieces(resultHashMap, hashmapForEquals);

		list.getShopList().remove(0);

		// hashmap for intermediate results
		HashMap<String, String> middleHashMap = new HashMap<String, String>();

		while (list.getShopList().size() > 0) {

			//search products in all the shops, process acquired information, put it to result hashmaps
			HashMap<String, String> innerResult = list.getShopList().get(0).searchProduct(request);
			HashMap<String, ArrayList<String>> hashForEqualsLittle = new HashMap<String, ArrayList<String>>();
			CompareHashMap.divideStringIntoPieces(innerResult, hashForEqualsLittle);

			int counter = 0;
			for (HashMap.Entry<String, ArrayList<String>> itemLittle : hashForEqualsLittle.entrySet()) {

				for (HashMap.Entry<String, ArrayList<String>> itemBig : hashmapForEquals.entrySet()) {
					if (itemLittle.getValue().equals(itemBig.getValue())) {
						HashMap<String, String> innerMap = new HashMap<String, String>();
						String inerKey = list.getShopList().get(0).getShopName();
						String innerValue = innerResult.get(itemLittle.getKey());
						innerMap.put(inerKey, innerValue);
						resultHashMap.get(itemBig.getKey()).add(innerMap);
					} else {
						counter += 1;
					}

				}

				if (counter == hashmapForEquals.size()) {
					middleHashMap.put(itemLittle.getKey(), innerResult.get(itemLittle.getKey()));

					counter = 0;
				}
			}

			for (Entry<String, String> itemMid : middleHashMap.entrySet()) {
				HashMap<String, String> innerMap = new HashMap<String, String>();
				String inerKey = list.getShopList().get(0).getShopName();
				String innerValue = itemMid.getValue().toString();
				innerMap.put(inerKey, innerValue);
				ArrayList<HashMap<String, String>> valueArray = new ArrayList<HashMap<String, String>>();
				valueArray.add(innerMap);
				String innerRequest = StringCorrect.stringCorrectForParsing(itemMid.getKey().toString());
				resultHashMap.put(innerRequest, valueArray);

			}

			CompareHashMap.divideResultToStringIntoPieces(resultHashMap, hashmapForEquals);
			middleHashMap.clear();
			list.getShopList().remove(0);
		}

		//print result information to console
		int i = 1;
		for (HashMap.Entry<String, ArrayList<HashMap<String, String>>> entry : resultHashMap.entrySet()) {
			ConsolePrinter.print(i + ") " + entry.getKey() + " \n " + entry.getValue());
			i += 1;
		}

	}
}
