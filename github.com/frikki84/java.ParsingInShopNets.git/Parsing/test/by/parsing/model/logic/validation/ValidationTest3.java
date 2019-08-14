package by.parsing.model.logic.validation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import by.parsing.model.entity.request.Request;

public class ValidationTest3 {
	@Test
	public void testValidationValidateOnlySpaces() {
		String test = "       ";
		boolean expected = false;
		
		assertEquals(expected, Validation.validateOnlySpaces(test));
	}

}
