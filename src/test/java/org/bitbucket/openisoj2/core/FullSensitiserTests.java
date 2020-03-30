package org.bitbucket.openisoj2.core;

import static org.junit.Assert.*;

import org.junit.Test;

public class FullSensitiserTests {
	private Sensitiser sensitiser = FullSensitiser.getInstance();

	@Test
	public void testNull() {
		assertNull(sensitiser.sensitise(null));
	}

	@Test
	public void testValid() {
		String input = "123456";
		String expected = "******";
		String actual = sensitiser.sensitise(input);
		assertEquals(expected, actual);
	}
}
