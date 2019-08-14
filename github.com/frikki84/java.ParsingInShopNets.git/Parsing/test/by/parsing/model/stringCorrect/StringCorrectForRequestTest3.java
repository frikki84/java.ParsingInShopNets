package by.parsing.model.stringCorrect;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import by.parsing.model.logic.stringCorrect.StringCorrect;

public class StringCorrectForRequestTest3 {
	@Test
	public void testRequestCorrectForParsing() {
		String test = " �������-����  \"Nivea men\" Ultra, 250 ��. ";
		
		String expected = "�������-���� NIVEA MEN ULTRA 250 ��";
		
		assertEquals(expected, StringCorrect.stringCorrectForParsing(test));
		
	}
}
