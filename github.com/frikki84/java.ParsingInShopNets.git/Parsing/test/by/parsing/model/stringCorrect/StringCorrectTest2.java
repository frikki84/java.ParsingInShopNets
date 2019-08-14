package by.parsing.model.stringCorrect;

import org.junit.Test;

import by.parsing.model.logic.stringCorrect.StringCorrect;

import static org.junit.Assert.*;

public class StringCorrectTest2 {
	@Test
	public void testPriceCorrection() {
		String test = "125.1415";
		
		String expected = "125.1415";
		
		assertEquals(expected, StringCorrect.priceRubCorrection(test));

	}

}