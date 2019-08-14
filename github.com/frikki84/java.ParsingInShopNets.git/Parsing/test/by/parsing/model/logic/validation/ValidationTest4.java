package by.parsing.model.logic.validation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import by.parsing.model.entity.request.Request;

public class ValidationTest4 {
	@Test
	public void testValidationValidateOnlySpaces() {
		String test = "1234";
		String expected = "1234";
		
		assertEquals(expected, Validation.validateRequest(test));
	}

}