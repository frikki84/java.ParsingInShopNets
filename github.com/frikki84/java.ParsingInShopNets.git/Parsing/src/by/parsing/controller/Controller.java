package by.parsing.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;

import by.parsing.model.entity.request.Request;
import by.parsing.model.entity.result.FinalResultEntity;
import by.parsing.model.entity.shops.Edostavka;
import by.parsing.model.entity.shops.Hypermall;
import by.parsing.model.entity.shops.OstrovChistoty;
import by.parsing.model.entity.shops.Oz;
import by.parsing.model.entity.shops.ShopList;
import by.parsing.model.entity.shops.ShopNet;
import by.parsing.model.logic.createResultList.MainResultListCreation;
import by.parsing.model.logic.userInput.UserInput;
import by.parsing.view.ConsolePrinter;

public class Controller {
	public static void main(String[] args) {

		String strForRequest = UserInput.inputString("Please enter the product name: ");
		Request request = new Request(strForRequest);
		ConsolePrinter.print("Please wait");

		OstrovChistoty chistoty = new OstrovChistoty();
		Edostavka edostavka = new Edostavka();
		Hypermall hypermall = new Hypermall();
		Oz oz = new Oz();

		ShopList shopList = new ShopList();
		shopList.addShopNetInList((new ShopNet[] { chistoty, edostavka, hypermall, oz }));

		ArrayList<FinalResultEntity> finalList = new ArrayList<>();
		finalList = MainResultListCreation.createFinalList(shopList, request);

		ConsolePrinter.print("RESULTS:");
		for (FinalResultEntity entity : finalList) {
			ConsolePrinter.print((finalList.indexOf(entity) + 1) + ") " + entity.getName());
			for (Map.Entry<String, Double> point : entity.getPriceHash().entrySet()) {
				ConsolePrinter.print(point.getKey() + " --- " + point.getValue() + " руб.");
			}

		}

	}

}
