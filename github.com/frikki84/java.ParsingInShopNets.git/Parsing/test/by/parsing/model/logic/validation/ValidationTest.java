package by.parsing.model.logic.validation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import by.parsing.model.entity.request.Request;

public class ValidationTest {
	@Test
	public void testValidationValidateOnlySpaces() {
		String test = "1234";
		boolean expected = true;
		
		assertEquals(expected, Validation.validateOnlySpaces(test));
	}

}
