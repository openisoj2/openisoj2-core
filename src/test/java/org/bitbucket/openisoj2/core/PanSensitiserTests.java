package org.bitbucket.openisoj2.core;

import static org.junit.Assert.*;

import org.junit.Test;

public class PanSensitiserTests {
	private Sensitiser sensitiser = PanSensitiser.getInstance();

	@Test
	public void testLen10() {
		String input = "123456001234";
		String expected = "123456**1234";
		String actual = sensitiser.sensitise(input);
		assertEquals(expected, actual);
	}

	@Test
	public void testLen16() {
		String input = "1234560000001234";
		String expected = "123456******1234";
		String actual = sensitiser.sensitise(input);
		assertEquals(expected, actual);
	}

	@Test
	public void testLen19() {
		String input = "1234569876543211234";
		String expected = "123456*********1234";
		String actual = sensitiser.sensitise(input);
		assertEquals(expected, actual);
	}

	@Test
	public void testNull() {
		assertNull(sensitiser.sensitise(null));
	}
}
