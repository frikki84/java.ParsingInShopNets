package by.parsing.model.logic.search;

import java.util.HashMap;

import org.junit.Test;

import by.parsing.model.entity.request.Request;
import by.parsing.model.entity.shops.Mila;

public class SearchInMila {
	
	@Test
	public void testSearchInMila() {
		Mila mila = new Mila();
		Request request = new Request("�������� Huggies");
		
		HashMap<String, String> expected = new HashMap<String, String>();
		expected.put("�������� ������� ������� Huggies Classic 64��", "4");
		expected.put("�������� ������� ������������ ������� Huggies Elite Soft 64��", "4");
		
		
		
	}
	

}
