package by.parsing.model.logic.structuresForComparison;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

import by.parsing.model.logic.stringCorrect.StringCorrect;

public class CompareHashMap {
	
	//method for divide Strings Into Pieces
	public static void divideStringIntoPieces(HashMap<String, String> sourceHash,
			HashMap<String, ArrayList<String>> resultHash) {

		for (String key : sourceHash.keySet()) {
			String changedKey = key;
			String[] mass = changedKey.split(" ");
			ArrayList<String> arr1 = new ArrayList<>(Arrays.asList(mass));
			Collections.sort(arr1);
			resultHash.put(changedKey, arr1);

		}
	}
	//method for divide taken result into pieces, put it to certain hashmap for further parsing
	public static void divideResultToStringIntoPieces(HashMap<String, ArrayList<HashMap<String, String>>> resultHashMap,
			HashMap<String, ArrayList<String>> hashmapForEquals) {
		for (String key : resultHashMap.keySet()) {
			String changedKey = key;
			String[] mass = changedKey.split(" ");
			ArrayList<String> arr = new ArrayList<>(Arrays.asList(mass));
			Collections.sort(arr);
			hashmapForEquals.put(changedKey, arr);

		}
	}

}
