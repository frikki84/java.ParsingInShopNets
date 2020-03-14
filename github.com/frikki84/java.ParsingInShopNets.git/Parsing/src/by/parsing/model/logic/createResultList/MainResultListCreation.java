package by.parsing.model.logic.createResultList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import by.parsing.model.entity.request.Request;
import by.parsing.model.entity.result.FinalResultEntity;
import by.parsing.model.entity.result.ParsingShopResult;
import by.parsing.model.entity.shops.ShopList;
import by.parsing.model.entity.shops.ShopNet;

public class MainResultListCreation {
	public static LinkedList<FinalResultEntity> firstPointInFinalList(ShopList shopList, Request request) {
		LinkedList<FinalResultEntity> finalList = new LinkedList<>();

		ArrayList<ParsingShopResult> mList = new ArrayList<>();
		for (ShopNet i : shopList.getShopList()) {

			mList = i.searchProduct(request);

			for (ParsingShopResult j : mList) {

				HashMap<String, Double> priceHash = new HashMap<>();
				HashMap<String, String> imageHash = new HashMap<>();
				HashMap<String, String> linkHash = new HashMap<>();

				priceHash.put(j.getShop(), j.getPrice());
				imageHash.put(j.getShop(), j.getImage());
				linkHash.put(j.getShop(), j.getLink());

				FinalResultEntity finalEntity = new FinalResultEntity(j.getName(), priceHash, imageHash, linkHash);
				finalList.add(finalEntity);

				if (finalList != null) {

					break;
				}

			}

		}

		return finalList;
	}

	public static ShopList changeShopList(ShopList list, LinkedList<FinalResultEntity> finalList) {
		int index = 0;
		for (ShopNet shop : list.getShopList()) {
			if (shop.getShopName().equals(finalList.get(0).getPriceHash().keySet())) {
				index += list.getShopList().indexOf(shop);
				break;
			}
		}
		ShopList newList = new ShopList();
		for (int i = index; i < list.getShopList().size(); i++) {
			newList.addShopNetInList(list.getShopList().get(i));
		}
		return newList;
	}

	public static LinkedList<FinalResultEntity> upgrateFinalList(ShopList shopList, Request request,
			LinkedList<FinalResultEntity> finalList) {
		LinkedList<FinalResultEntity> lastFinalList = new LinkedList<>(finalList);

		ArrayList<ParsingShopResult> mList = new ArrayList<>();
		for (ShopNet i : shopList.getShopList()) {

			mList = i.searchProduct(request);

			for (ParsingShopResult j : mList) {
				for (FinalResultEntity f : finalList) {
					if (j.getName().equals(f.getName())) {
						int index = finalList.indexOf(f);
						finalList.get(index).getPriceHash().put(j.getShop(), j.getPrice());
						finalList.get(index).getImageHash().put(j.getShop(), j.getImage());
						finalList.get(index).getLinkHash().put(j.getShop(), j.getLink());
					} else {

						HashMap<String, Double> priceHash = new HashMap<>();
						HashMap<String, String> imageHash = new HashMap<>();
						HashMap<String, String> linkHash = new HashMap<>();

						priceHash.put(j.getShop(), j.getPrice());
						imageHash.put(j.getShop(), j.getImage());
						linkHash.put(j.getShop(), j.getLink());

						FinalResultEntity addEntity = new FinalResultEntity(j.getName(), priceHash, imageHash,
								linkHash);
						lastFinalList.add(addEntity);
					}

				}

			}
		}
		return lastFinalList;
	}
	
	
	public static LinkedList<FinalResultEntity> createFinalList(ShopList shopList, Request request) {
		LinkedList<FinalResultEntity> list = MainResultListCreation.firstPointInFinalList(shopList, request);
		System.out.println(list);
		ShopList listShop = MainResultListCreation.changeShopList(shopList, list);
		System.out.println(listShop);
		
		
		
		//LinkedList<FinalResultEntity> finalResult = MainResultListCreation.upgrateFinalList(listShop, request, list);
		return new LinkedList<>();//finalResult;
	}
	
}
