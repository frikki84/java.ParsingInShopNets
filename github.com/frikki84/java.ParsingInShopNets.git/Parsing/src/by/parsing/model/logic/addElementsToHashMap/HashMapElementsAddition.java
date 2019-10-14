package by.parsing.model.logic.addElementsToHashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import by.parsing.model.entity.shops.ShopList;
import by.parsing.model.logic.stringCorrect.StringCorrect;

public class HashMapElementsAddition {
	
	//add element to the main resultHashMap after the first parsing
	public static HashMap<String, ArrayList<HashMap<String, String>>> addElementsToMainResultHashMap(
			ArrayList<ArrayList<String>> sourceArrayList, HashMap<String, ArrayList<HashMap<String, String>>> resultHashMap,
			ShopList list) {

		for (Map.Entry<String, String> entry : sourceHashMap.entrySet()) {

			HashMap<String, String> innerMap = new HashMap<String, String>();
			String inerKey = list.getShopList().get(0).getShopName();
			String innerValue = entry.getValue().toString();
			innerMap.put(inerKey, innerValue);
			ArrayList<HashMap<String, String>> valueArray = new ArrayList<HashMap<String, String>>();
			valueArray.add(innerMap);
			String innerRequest = StringCorrect.stringCorrectForParsing(entry.getKey());
			resultHashMap.put(innerRequest, valueArray);
		}

		return resultHashMap;

	}

	
}
