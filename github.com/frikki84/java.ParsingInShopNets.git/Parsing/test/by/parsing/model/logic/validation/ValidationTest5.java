package by.parsing.model.logic.validation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class ValidationTest5 {
	@Test
	public void testValidationValidateOnlySpaces() {
		String test = "       ";
		String expected = "1234";
		
		assertEquals(expected, Validation.validateRequest(test));
	}

}