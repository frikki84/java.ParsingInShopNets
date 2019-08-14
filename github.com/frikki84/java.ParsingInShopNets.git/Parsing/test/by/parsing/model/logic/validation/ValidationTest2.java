package by.parsing.model.logic.validation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import by.parsing.model.entity.request.Request;

public class ValidationTest2 {
	@Test
	public void testValidationValidateOnlySpaces() {
		String test = "12   12";
		boolean expected = true;
		
		assertEquals(expected, Validation.validateOnlySpaces(test));
	}

}
