package by.parsing.model.stringCorrect;

import org.junit.Test;

import by.parsing.model.logic.stringCorrect.StringCorrect;

import static org.junit.Assert.*;

public class StringCorrectTest {
	@Test
	public void testPriceCorrection() {
		String test = "    1.25      руб длыоваз ыддлваозц ыддввлаощыгуа9цууц";
		
		String expected = "1.25";
		
		assertEquals(expected, StringCorrect.priceRubCorrection(test));

	}

}
