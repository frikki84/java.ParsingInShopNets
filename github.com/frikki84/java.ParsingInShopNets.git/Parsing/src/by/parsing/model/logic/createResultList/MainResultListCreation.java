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

	/*
	 * find first shop in ShopList with request product and add search result to
	 * final LinkedList<FinalResultEntity>
	 */
	public static LinkedList<FinalResultEntity> firstPointInFinalList(ShopList shopList, Request request) {
		LinkedList<FinalResultEntity> finalList = new LinkedList<>();

		ArrayList<ParsingShopResult> mList = new ArrayList<>();

		FinalResultEntity finalEntity = new FinalResultEntity();

		for (ShopNet i : shopList.getShopList()) {
			if (finalList.equals(new LinkedList<FinalResultEntity>())) {

				mList = i.searchProduct(request);

				for (ParsingShopResult j : mList) {

					HashMap<String, Double> priceHash = new HashMap<>();
					HashMap<String, String> imageHash = new HashMap<>();
					HashMap<String, String> linkHash = new HashMap<>();

					priceHash.put(j.getShop(), j.getPrice());
					imageHash.put(j.getShop(), j.getImage());
					linkHash.put(j.getShop(), j.getLink());

					finalEntity.setName(j.getName());
					finalEntity.setPriceHash(priceHash);
					finalEntity.setLinkHash(linkHash);
					finalEntity.setImageHash(imageHash);

					finalList.add(new FinalResultEntity(finalEntity));
				}
			}
		}

		return finalList;
	}

	public static ShopList changeShopList(ShopList list, LinkedList<FinalResultEntity> finalList) {
		int index = 0;
		for (ShopNet shop : list.getShopList()) {
			if (finalList.get(0).getPriceHash().containsKey(shop.getShopName())) {
				index += list.getShopList().indexOf(shop);
				break;
			}
		}
		ShopList newList = new ShopList();
		for (int i = index + 1; i < list.getShopList().size(); i++) {
			newList.addShopNetInList(list.getShopList().get(i));
		}

		return newList;
	}

	public static LinkedList<FinalResultEntity> upgrateFinalList(ShopList shopList, Request request,
			LinkedList<FinalResultEntity> finalList) {

		// main result LinkedList
		LinkedList<FinalResultEntity> lastFinalList = new LinkedList<>(finalList);

		// counter to define if the final list contains value from new shop research
		// list
		int counter = 0;

		for (ShopNet i : shopList.getShopList()) {
			ArrayList<ParsingShopResult> mList = new ArrayList<>();
			mList = i.searchProduct(request);

			for (ParsingShopResult j : mList) {
				for (FinalResultEntity f : finalList) {
					// if product name from final list equals product name from mList
					if (j.getName().equals(f.getName())) {
						int index = lastFinalList.indexOf(f);
						lastFinalList.get(index).getPriceHash().put(j.getShop(), j.getPrice());
						lastFinalList.get(index).getImageHash().put(j.getShop(), j.getImage());
						lastFinalList.get(index).getLinkHash().put(j.getShop(), j.getLink());
					} else {
						counter += 1;
					}
				}

				if (counter == finalList.size()) {
					HashMap<String, Double> priceHash = new HashMap<>();
					HashMap<String, String> imageHash = new HashMap<>();
					HashMap<String, String> linkHash = new HashMap<>();

					priceHash.put(j.getShop(), j.getPrice());
					imageHash.put(j.getShop(), j.getImage());
					linkHash.put(j.getShop(), j.getLink());

					FinalResultEntity addEntity = new FinalResultEntity(j.getName(), priceHash, imageHash, linkHash);
					lastFinalList.add(addEntity);
				}
				counter = 0;
			}
		}
		return lastFinalList;
	}

	public static LinkedList<FinalResultEntity> createFinalList(ShopList shopList, Request request) {
		LinkedList<FinalResultEntity> list = MainResultListCreation.firstPointInFinalList(shopList, request);
		ShopList listShop = MainResultListCreation.changeShopList(shopList, list);
		LinkedList<FinalResultEntity> finalResult = MainResultListCreation.upgrateFinalList(listShop, request, list);
		return finalResult;
	}

}
