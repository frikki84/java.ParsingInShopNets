package by.parsing.model.stringCorrect;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import by.parsing.model.logic.stringCorrect.StringCorrect;

public class StringCorrectForRequestTest3 {
	@Test
	public void testRequestCorrectForParsing() {
		String test = " Øàìïóíü-óõîä  \"Nivea men\" Ultra, 250 ìë. ";
		
		String expected = "ØÀÌÏÓÍÜ-ÓÕÎÄ NIVEA MEN ULTRA 250 ÌË";
		
		assertEquals(expected, StringCorrect.stringCorrectForParsing(test));
		
	}
}
