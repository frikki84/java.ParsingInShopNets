package by.parsing.model.logic.finalConstruction;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.event.HyperlinkEvent;

import org.junit.Test;

import by.parsing.model.entity.shops.Hypermall;
import by.parsing.model.entity.shops.OstrovChistoty;
import by.parsing.model.entity.shops.ShopNet;

public class TestFinalAction_PutValuesToFinalHashMap {
	@Test
	public void testPutValuesToFinalHashMap() {
		HashMap<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("tyde", "2.5");
		hashMap.put("tre", "87.1");

		OstrovChistoty chistoty = new OstrovChistoty();
		Hypermall hypermall = new Hypermall();

		ArrayList<ShopNet> list = new ArrayList<ShopNet>();
		list.add(chistoty);
		//list.add(hypermall);

		HashMap<String, ArrayList<HashMap<String, String>>> resultHashMap = new HashMap<String, ArrayList<HashMap<String, String>>>();
		ArrayList<HashMap<String, String>> valueArray = new ArrayList<HashMap<String, String>>();

		HashMap<String, ArrayList<HashMap<String, String>>> expected = new HashMap<String, ArrayList<HashMap<String, String>>>();
		ArrayList<HashMap<String, String>> expectedArray = new ArrayList<HashMap<String, String>>();
		


		
	}

}
