package org.bitbucket.openisoj2.core;

import static org.junit.Assert.*;

import org.junit.Test;

public class Track2SensitiserTests {
	private Sensitiser sensitiser = Track2Sensitiser.getInstance();

	@Test
	public void test1() {
		testEA("123456001234===", "123456**1234===");
	}

	@Test
	public void test10() {
		// For retarted banks that don't create proper track 2 data
		testEA("123456001234=1503", "123456**1234=1503");
	}

	@Test
	public void test11() {
		// For retarted banks that don't create proper track 2 data
		testEA("123456001234=", "123456**1234=");
	}

	@Test
	public void test2() {
		testEA("123456001234=", "123456**1234=");
	}

	@Test
	public void test3() {
		testEA("123456001234=1503=", "123456**1234=1503=");
	}

	@Test
	public void test4() {
		testEA("123456001234==501", "123456**1234==501");
	}

	@Test
	public void test5() {
		testEA("123456001234=1503501", "123456**1234=1503501");
	}

	@Test
	public void test6() {
		testEA("123456001234===987654", "123456**1234===******");
	}

	@Test
	public void test7() {
		testEA("123456001234=1503=987654", "123456**1234=1503=******");
	}

	@Test
	public void test8() {
		testEA("123456001234==501987654", "123456**1234==501******");
	}

	@Test
	public void test9() {
		testEA("123456001234=1503501987654", "123456**1234=1503501******");
	}

	@Test
	public void testDelimiterD() {
		testEA("1234569876543211234D1503501987654321", "123456*********1234D1503501*********");
	}

	private void testEA(String input, String expected) {
		String actual = sensitiser.sensitise(input);
		assertEquals(expected, actual);
	}

	@Test
	public void testFull() {
		testEA("1234569876543211234=1503501987654321", "123456*********1234=1503501*********");
	}

	@Test
	public void testNull() {
		assertNull(sensitiser.sensitise(null));
	}
}
