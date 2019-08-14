package by.parsing.model.logic.search;

import java.util.HashMap;

import org.junit.Test;

import by.parsing.model.entity.request.Request;
import by.parsing.model.entity.shops.Mila;

public class SearchInMila {
	
	@Test
	public void testSearchInMila() {
		Mila mila = new Mila();
		Request request = new Request("салфетки Huggies");
		
		HashMap<String, String> expected = new HashMap<String, String>();
		expected.put("Салфетки влажные детские Huggies Classic 64шт", "4");
		expected.put("Салфетки влажные многослойные детские Huggies Elite Soft 64шт", "4");
		
		
		
	}
	

}
